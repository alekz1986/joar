package com.joar.fact.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class TemplateController {

	@GetMapping("/header")
	public String _header() {
		System.out.println("_header");
		return "template/_header";
	}
	
	@GetMapping("/aside-menu")
	public String _aside_menu() {
		System.out.println("_aside-menu");
		return "template/_aside-menu";
	}
	
	@GetMapping("/footer")
	public String _footer() {
		System.out.println("_footer");
		return "template/_footer";
	}
	
	@GetMapping("/script-footer-1")
	public String _script_footer_1() {
		System.out.println("_script-footer-1");
		return "template/_script-footer-1";
	}
	
	@GetMapping("/script-footer-2")
	public String _script_footer_2() {
		System.out.println("_script-footer-2");
		return "template/_script-footer-2";
	}
	
	@GetMapping("/script-header-1")
	public String _script_header_1() {
		System.out.println("_script-header-1");
		return "template/_script-header-1";
	}
	
	@GetMapping("/script-header-2")
	public String _script_header_2() {
		System.out.println("_script-header-2");
		return "template/_script-header-2";
	}
	
	@GetMapping("/sub-header")
	public String _sub_header() {
		System.out.println("_sub_header");
		return "template/_sub-header";
	}
}
