package com.joar.fact.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joar.fact.bussines.NMetrica;
import com.joar.fact.bussines.NProductoGrupo;
import com.joar.fact.bussines.NProductoGrupoTipo;
import com.joar.fact.bussines.exception.AppException;
import com.joar.fact.bussines.tools.AppAlert;
import com.joar.fact.bussines.tools.AppAlertType;
import com.joar.fact.config.CtesAtr;
import com.joar.fact.db.beans.EnumProductoGrupoTipo;
import com.joar.fact.db.beans.Metrica;
import com.joar.fact.db.beans.ProductoGrupo;
import com.joar.fact.db.beans.ProductoGrupoTipo;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private NProductoGrupoTipo nProductoGrupoTipo;

	@Autowired
	private NProductoGrupo nProductoGrupo;
	
	@Autowired
	private NMetrica nMetrica;

	
	@GetMapping("/nuevo-grupo")
	public String nuevaCategoria(Model model, @RequestParam int idProdGrupoPadre, @RequestParam int idGrupoTipo) throws Exception {
		ProductoGrupo pg = null;
		ProductoGrupoTipo pdgt = null;
		if (idProdGrupoPadre != 0) {
			pg = nProductoGrupo.obtener(idProdGrupoPadre);
		}
		pdgt = nProductoGrupoTipo.obtenerPorId(idGrupoTipo);
		if(pdgt == null) {
			AppAlert alert = new AppAlert();
			alert.setTitle("Error de Configuración");
			alert.setMessage("No se encuentra configurado el grupo o no existe.");
			alert.setType(AppAlertType.ERROR.getValue());
			throw new AppException(alert);
		}
		model.addAttribute(CtesAtr.PRODUCTO_GRUPO, pg);
		model.addAttribute(CtesAtr.PRODUCTO_GRUPO_TIPO, pdgt);
		model.addAttribute(CtesAtr.PRODUCTO_TITULO, "Nueva " + pdgt.getDescripcion());
		return "mantenimiento/producto/nuevo-grupo";
	}
	
	@GetMapping("/carga-nuevo-producto")
	public String nuevaCategoria(Model model, @RequestParam int idProdGrupoPadre) throws Exception {
		List<Metrica> metricas = nMetrica.listarActivos();
		ProductoGrupo pg = nProductoGrupo.obtener(idProdGrupoPadre);
		String mensajeError = null;
		if(metricas == null || metricas.size()==0)
			mensajeError = "No se encontraron métricas configuradas.";
		if(pg == null)
			mensajeError = "El grupo del producto no se puede determinar.";
		if (mensajeError != null) {
			AppAlert alert = new AppAlert();
			alert.setTitle("Error de Configuración");
			alert.setMessage("No se encontraron métricas configuradas.");
			alert.setType(AppAlertType.ERROR.getValue());
			throw new AppException(alert);
		}
		model.addAttribute(CtesAtr.PRODUCTO_GRUPO, pg);
		model.addAttribute(CtesAtr.PRODUCTO_METRICAS, metricas);
		return "mantenimiento/producto/nuevo-producto";
	}
	
	@GetMapping("/ver-detalle-grupo")
	public String verDetalleGrupo() throws Exception {
		return "mantenimiento/producto/ver-detalle-grupo";
	}
	
}
