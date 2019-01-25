package com.joar.fact.controller.rest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joar.fact.bussines.NProducto;
import com.joar.fact.bussines.NProductoGrupo;
import com.joar.fact.bussines.NProductoGrupoTipo;
import com.joar.fact.bussines.tools.AppAlert;
import com.joar.fact.bussines.tools.AppAlertType;
import com.joar.fact.bussines.tools.AppResponse;
import com.joar.fact.config.Ctes;
import com.joar.fact.controller.rest.bean.jstree.JsTreeNode;
import com.joar.fact.controller.rest.bean.jstree.JsTreeUtil;
import com.joar.fact.db.beans.Producto;
import com.joar.fact.db.beans.ProductoGrupo;
import com.joar.fact.db.beans.Usuario;

@RestController
@RequestMapping("/api/producto")
public class RestProductoController {
	
	@Autowired
	private NProductoGrupoTipo nProductoGrupoTipo;

	@Autowired
	private NProducto nProducto; 

	
	@GetMapping("/arbol-productos")
	public AppResponse getArbolProductos() throws Exception {
		AppResponse rpta = new AppResponse();
		List<ProductoGrupo> tree = nProducto.listarArbolConGrupos();
		List<JsTreeNode> jsTree = new ArrayList<JsTreeNode>();
		for(ProductoGrupo pg: tree) {
			JsTreeNode node = new JsTreeNode();
			JsTreeUtil.convertFromProductoGrupo(node, pg);
			jsTree.add(node);
		}
		rpta.setSuccess(true);
		rpta.setData(jsTree);
		return rpta;
	}
	
	@GetMapping("/listar-producto-grupo-tipo")
	public AppResponse listarTodo() throws Exception {
		AppResponse rpta = new AppResponse();
		rpta.setSuccess(true);
		rpta.setData(nProductoGrupoTipo.obtenerListaCompleta());
		return rpta;
	}
	
	@PostMapping("/crea-producto")
	public AppResponse nuevoProducto(HttpServletRequest req, @RequestBody Producto producto) throws Exception {
		Usuario usuario = (Usuario)req.getSession().getAttribute(Ctes.Session.USUARIO);
		producto.setActivo(true);
		producto.setUsuCreacion(usuario);
		nProducto.insertarProducto(producto);
		AppResponse rpta = new AppResponse();
		AppAlert alert = new AppAlert();
		alert.setTitle("Información");
		alert.setMessage("Se creó su Producto Satisfactoriamente.");
		alert.setType(AppAlertType.SUCCESS.getValue());
		rpta.setSuccess(true);
		rpta.setAlert(alert);
		return rpta;
	}
	
	@PostMapping("/elimina-producto")
	public AppResponse eliminaProducto(@RequestParam("idProducto") BigInteger idProducto) throws Exception {
		nProducto.actualizaEstado(idProducto, false);
		AppResponse rpta = new AppResponse();
		rpta.setSuccess(true);
		return rpta;
	}
	
}
