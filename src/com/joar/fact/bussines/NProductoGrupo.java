	package com.joar.fact.bussines;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.joar.fact.bussines.exception.AppException;
import com.joar.fact.bussines.tools.AppAlert;
import com.joar.fact.bussines.tools.AppAlertType;
import com.joar.fact.config.Ctes;
import com.joar.fact.db.MySqlProductoGrupo;
import com.joar.fact.db.beans.ProductoGrupo;

import javafx.scene.control.Alert.AlertType;

@Service
public class NProductoGrupo {

	@Autowired
	private MySqlProductoGrupo mysqlProductoGrupo;
	
	
	public void grabarProductoGrupo(ProductoGrupo pg) throws Exception {
		int r = mysqlProductoGrupo.insertar(pg);
		if (r != 1) {
			AppAlert alert = new AppAlert();
			alert.setTitle("Error");
			alert.setMessage("No se pudo grabar su solicitud.");
			alert.setType(AppAlertType.ERROR.getValue());
			throw new AppException(alert);
		}
	}
	
	public ProductoGrupo obtener(int idProdGrupo) throws Exception {
		return mysqlProductoGrupo.obtenerPorId(idProdGrupo);
	}
	
	public List<ProductoGrupo> listarArbolGruposProductos() throws Exception {
		List<ProductoGrupo> grupos = mysqlProductoGrupo.listaActivos();
		ProductoGrupo raiz = new ProductoGrupo();
		reordenaHijos(raiz, grupos);
		return raiz.getHijos();
	}
	
	public void eliminaGrupoEnCascada(int idProdGrupo) throws Exception {
		if (idProdGrupo <= 0) {
			AppAlert alert = new AppAlert();
			alert.setTitle("No se puede procesar su solicitud.");
			alert.setMessage("El codigo seleccionado no existe o es inválido.");
			alert.setType(AppAlertType.WARNING.getValue());
			alert.setConfirmMessage(Ctes.AppAlert.DEFAULT_CONFIRM_BUTTON);
			alert.setCancelMessage(Ctes.AppAlert.DEFAULT_CANCEL_BUTTON);
			throw new AppException(alert);		
		}
		mysqlProductoGrupo.eliminaGrupoEnCascada(idProdGrupo);
	}
	
	private void reordenaHijos(ProductoGrupo padre, List<ProductoGrupo> lista) throws SAXException, JAXBException {
		ListIterator<ProductoGrupo> ite = lista.listIterator();
		if(padre == null) padre = new ProductoGrupo();
		if(padre.getHijos() == null) {
			padre.setHijos(new ArrayList<ProductoGrupo>());
		}
		while(ite.hasNext()) {
			ProductoGrupo pg = ite.next();
			if(pg.getIdProdGrupo() == padre.getIdProdGrupo())
				continue;
			if(padre != null && pg.getPadre()!=null && pg.getPadre().getIdProdGrupo() == padre.getIdProdGrupo()) {
				padre.getHijos().add(pg);
			}
		}
		for(ProductoGrupo pg: padre.getHijos())
			lista.remove(pg);		
		for(ProductoGrupo pg: padre.getHijos())
			reordenaHijos(pg, lista);	
	}

}
