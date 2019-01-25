package com.joar.fact.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joar.fact.bussines.NProductoGrupo;
import com.joar.fact.bussines.tools.AppAlert;
import com.joar.fact.bussines.tools.AppAlertType;
import com.joar.fact.bussines.tools.AppResponse;
import com.joar.fact.db.beans.ProductoGrupo;

@RestController
@RequestMapping("/api/producto-grupo")
public class RestProductoGrupoController {

	@Autowired
	private NProductoGrupo nProductoGrupo;
	
	@PutMapping("/guardar")
	public AppResponse guardar(@RequestBody ProductoGrupo pg) throws Exception {
		nProductoGrupo.grabarProductoGrupo(pg);
		AppResponse rpta = new AppResponse();
		AppAlert alert = new AppAlert();
		alert.setTitle("Informacion");
		alert.setMessage("Se grabó su solicitud satisfactoriamente.");
		alert.setType(AppAlertType.SUCCESS.getValue());
		rpta.setSuccess(true);
		rpta.setAlert(alert);
		return rpta;
	}
	
	@PostMapping("/elimina-grupo")
	public AppResponse eliminaProducto(@RequestParam("idProdGrupo") int idProdGrupo) throws Exception {
		nProductoGrupo.eliminaGrupoEnCascada(idProdGrupo);
		AppResponse rpta = new AppResponse();
		AppAlert alert = new AppAlert();
		alert.setTitle("Informacion");
		alert.setMessage("Se realizó el borrado satisfactoriamente.");
		alert.setType(AppAlertType.SUCCESS.getValue());
		rpta.setSuccess(true);
		rpta.setAlert(alert);
		return rpta;
	}
	
	
	
}
