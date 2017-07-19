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
import edu.mum.domain.Product;
import edu.mum.domain.User;
import edu.mum.service.ProductService;

@Controller
@RequestMapping("/shop")
public class ShoppingController {

	@Autowired
	private ProductService productService;

	@RequestMapping({ "", "/all" })
	public String list(Model model, HttpServletRequest httpServletRequest) {
		model.addAttribute("products", productService.findAll());
		if (httpServletRequest.getSession().getAttribute("testuser") == null) {
			User user = new User();
			user.setFirstName("Test User");
			model.addAttribute("testuser", user);
			httpServletRequest.getSession().setAttribute("count", 0);
			httpServletRequest.getSession().setAttribute("testuser", user);
		}
		// httpServletRequest.getSession().setAttribute("count",
		// order.getItems().size());

		return "products";
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
			productService.save(productToBeAdded);
		} catch (Exception up) {
			System.out.println("Transaction Failed!!!");

		}

		return "redirect:/shop";
	}

	@RequestMapping(value = "/addItem", method = RequestMethod.GET)
	public String addProduct(Model model, @RequestParam("id") Long productId, HttpServletRequest httpServletRequest) {
		productService.findOne(productId);
		Order order = (Order) httpServletRequest.getSession().getAttribute("order");

		Product findOne = productService.findOne(productId);
		OrderItem orderItem = new OrderItem();
		orderItem.setProduct(findOne);

		User user = (User) httpServletRequest.getSession().getAttribute("testuser");
		if (order == null) {
			order = new Order();
			user.getOrders().add(order);
			httpServletRequest.getSession().setAttribute("order", order);
		}
		orderItem.setOrder(order);

		Set<OrderItem> items = order.getItems();

		for (OrderItem item : items) {
			if (item.equals(orderItem)) {
				item.setQuantity(item.getQuantity() + 1);
				System.out.println(item.getQuantity());
			} else {
				order.getItems().add(orderItem);
			}
		}

		httpServletRequest.getSession().setAttribute("items", order.getItems());
		httpServletRequest.getSession().setAttribute("count", order.getItems().size());
		return "redirect:/shop";

	}

}
