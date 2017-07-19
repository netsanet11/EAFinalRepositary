package edu.mum.controller;

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
import edu.mum.service.UserService;

@Controller
@RequestMapping("/shop")
public class ShoppingController {

	@Autowired
	private ProductService productService;

	private UserService userService;

	@RequestMapping({ "", "/all" })
	public String list(Model model, HttpServletRequest httpServletRequest) {
		model.addAttribute("products", this.productService.findAll());
		User user = new User();
		user.setFirstName("Test User");
		httpServletRequest.getSession().setAttribute("testuser", user);
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
			this.productService.save(productToBeAdded);
		} catch (Exception up) {
			System.out.println("Transaction Failed!!!");

		}

		return "redirect:/products";
	}

	@RequestMapping(value = "/addItem", method = RequestMethod.GET)
	public String addProduct(Model model, @RequestParam("id") Long productId, HttpServletRequest httpServletRequest) {
		this.productService.findOne(productId);

		Product findOne = this.productService.findOne(productId);
		OrderItem orderItem = new OrderItem();
		orderItem.setProduct(findOne);

		User user = (User) httpServletRequest.getSession().getAttribute("testuser");
		Order order = new Order();
		orderItem.setOrder(order);
		user.getOrders().add(order);

		return "redirect:/products";

	}

}
