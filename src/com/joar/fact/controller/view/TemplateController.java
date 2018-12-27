package com.joar.fact.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class TemplateController {

	@GetMapping("/header")
	public String _header() {
		System.out.println("Heder");
		return "template/_header";
	}
	
}
