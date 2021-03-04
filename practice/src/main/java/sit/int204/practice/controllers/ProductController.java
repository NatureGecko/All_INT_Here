package sit.int204.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sit.int204.repositories.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping("/Product")
	public String product(Model model) {
		model.addAttribute("products",productRepository.findAll());
		return "product";
	}
}
