package com.joar.fact.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joar.fact.config.Ctes;
import com.joar.fact.config.CtesAtr;

@Controller
@RequestMapping("/mantenimiento")
public class MantenimientoController {

	
	@GetMapping("/producto-grupo")
	public String productoGrupo(Model model) {
		System.out.println("productoGrupo");
		model.addAttribute(CtesAtr.SUB_HEADER, Ctes.SubTitulo.Mantenimiento.PRODUCTO_GRUPO);
		return "mantenimiento/producto-grupo";
	}
	
	@GetMapping("/producto")
	public String producto(Model model) {
		model.addAttribute(CtesAtr.SUB_HEADER, Ctes.SubTitulo.Mantenimiento.PRODUCTO);
		return "mantenimiento/producto";
	}

}
