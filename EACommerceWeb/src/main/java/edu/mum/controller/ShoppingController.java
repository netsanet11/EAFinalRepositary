package edu.mum.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.domain.Order;
import edu.mum.domain.OrderItem;
import edu.mum.domain.OrderStatus;
import edu.mum.domain.Product;
import edu.mum.service.ProductService;

@Controller
@RequestMapping("/shop")
public class ShoppingController {

	private static final String ORDER = "order";
	private static final String PRODUCTS = "products";
	private static final String COUNT = "count";
	@Autowired
	private ProductService productService;

	@RequestMapping({ "", "/all" })
	public String list(Model model, HttpServletRequest httpServletRequest) {
		model.addAttribute(PRODUCTS, this.productService.findAll());
		if (httpServletRequest.getSession().getAttribute(COUNT) == null) {
			httpServletRequest.getSession().setAttribute(COUNT, 0);
		}

		return PRODUCTS;
	}

	@RequestMapping("/product")
	public String getProductById(Model model, @RequestParam("id") Long id) {

		Product product = this.productService.findOne(id);
		model.addAttribute("product", product);
		return "product";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@Valid @ModelAttribute("newProduct") Product productToBeAdded,
			BindingResult result) {
		if (result.hasErrors()) {
			return "addProduct";
		}

		try {
			this.productService.save(productToBeAdded);
		} catch (Exception up) {
			System.out.println("Transaction Failed!!!");

		}

		return "redirect:/shop";
	}

	@RequestMapping(value = "/addItem", method = RequestMethod.GET)
	public String addProduct(Model model, @RequestParam("id") Long productId, HttpServletRequest httpServletRequest) {
		this.productService.findOne(productId);
		Order order = (Order) httpServletRequest.getSession().getAttribute(ORDER);

		Product findOne = this.productService.findOne(productId);
		OrderItem orderItem = new OrderItem();
		orderItem.setProduct(findOne);

		if (order == null) {
			order = new Order();
			order.setStatus(OrderStatus.UNDELIV);

			httpServletRequest.getSession().setAttribute(ORDER, order);
		}
		orderItem.setOrder(order);

		Set<OrderItem> items = order.getItems();
		boolean flag = false;
		for (OrderItem item : items) {
			if (item.getProduct().equals(orderItem.getProduct())) {
				flag = true;
				item.setQuantity(item.getQuantity() + 1);
				System.out.println("Item quantity increase " + item.getQuantity());
			}
		}
		if (!flag) {
			orderItem.setQuantity(1);
			// order.getItems().add(orderItem);\
			order.getItems().add(orderItem);
		}

		httpServletRequest.getSession().setAttribute("items", order.getItems());
		httpServletRequest.getSession().setAttribute(COUNT, order.getItems().size());

		return "redirect:/shop";

	}

}
