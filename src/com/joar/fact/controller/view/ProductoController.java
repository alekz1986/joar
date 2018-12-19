package com.joar.fact.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	
	@GetMapping("/categoria")
	public String nuevaCategoria() {
		return "categoria...";
	}
	
}
