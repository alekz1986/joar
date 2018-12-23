package com.joar.fact.controller.view;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.joar.fact.db.MySqlUsuario;
import com.joar.fact.db.beans.Usuario;


@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private MySqlUsuario mySqlUsuario;
	
	

	public MySqlUsuario getMySqlUsuario() {
		return mySqlUsuario;
	}

	public void setMySqlUsuario(MySqlUsuario mySqlUsuario) {
		this.mySqlUsuario = mySqlUsuario;
	}

	@GetMapping("/inicial")
	public String login(Model model) {
		String mensaje = (String) model.asMap().get("error");
		model.addAttribute("errorx", "errorx");
		System.out.println("mensaje = " + mensaje);
		return "login"; 
	}

	@PostMapping("/ingresar")
	//public String ingresar(@RequestBody Map<String,Object> body) throws SQLException {
	public String ingresar(@RequestParam String usuario, @RequestParam String chash,
			RedirectAttributes ra) throws SQLException {
		System.out.println("ingreso a ingresar");
		System.out.println("strUsuario = " + usuario);
		System.out.println("clave = " + chash);
		Usuario usu = mySqlUsuario.getUsuario(usuario, chash);
		if (usu == null) {
			ra.addFlashAttribute("error", "Usuario y/o clave incorrecta.");
			return "redirect:/login/inicial";
		}
		return "redirect:/login/home";
	}
	
	@GetMapping("/home")
	public String home() {
		System.out.println("ingreso a home");
		return "home";
	}
	
}
