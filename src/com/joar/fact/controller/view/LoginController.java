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
		return "login"; 
	}

	@PostMapping("/ingresar")
	public String ingresar(@RequestBody Map<String,Object> body) throws SQLException {
		System.out.println("ingreso a ingresar");
		String strUsuario = (String)body.get("usuario");
		String clave = (String)body.get("claveHash");
		Usuario usuario = mySqlUsuario.getUsuario(strUsuario, clave);
		if (usuario != null)
			return "redirect:/login/home";
		return "redirect:/login/inicial";
	}
	
	@GetMapping("/home")
	public String home() {
		System.out.println("ingreso a home");
		return "home";
	}
	
}
