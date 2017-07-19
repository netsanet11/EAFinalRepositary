package edu.mum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Product;
import edu.mum.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping({ "", "/all" })
	public String list(Model model, HttpServletRequest httpServletRequest) {
		model.addAttribute("newProduct", new Product());
		model.addAttribute("products", this.productService.findAll());
		return "addProduct";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(Model model, @Valid @ModelAttribute("newProduct") Product product, BindingResult result) {

		if (!result.hasErrors()) {
			this.productService.save(product);
			model.addAttribute("newProduct", new Product());
			model.addAttribute("products", this.productService.findAll());
		}

		return "addProduct";
	}

	@RequestMapping("delete/{id}")
	public String delete(Model model, @PathVariable("id") Long id) {

		this.productService.remove(id);
		model.addAttribute("newProduct", new Product());
		model.addAttribute("products", this.productService.findAll());
		return "redirect:/product";
	}
}
