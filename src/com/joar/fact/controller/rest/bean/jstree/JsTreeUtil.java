package com.joar.fact.controller.rest.bean.jstree;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;

import com.joar.fact.db.beans.EnumProductoGrupoTipo;
import com.joar.fact.db.beans.Producto;
import com.joar.fact.db.beans.ProductoGrupo;
import com.joar.fact.db.beans.ProductoGrupoTipo;

public class JsTreeUtil {

	public final String ICON_FAMILIA = "";
	public final String ICON_SUBFAMILIA = "";
	public final String ICON_CATEGORIA = "";
	public final String ICON_ = "";
	
	public static void convertFromProductoGrupo(JsTreeNode jsTree, ProductoGrupo raiz) {
		jsTree.setText(raiz.getDescripcion());
		JsTreeState state = new JsTreeState();
		state.setOpened(true);
		jsTree.setState(state);
		if(raiz.getGrupoTipo() != null) {
			jsTree.setType(
					StringUtils.stripAccents(
							raiz.getGrupoTipo().getDescripcion().toLowerCase()));			
		}
		jsTree.setExtraData(new Object() {
			int id = raiz.getIdProdGrupo();
			ProductoGrupoTipo grupoTipo = raiz.getGrupoTipo();
			ProductoGrupo padre = raiz.getPadre();
			public int getId() { return id; }
			public ProductoGrupoTipo getGrupoTipo() { return grupoTipo; }
			public ProductoGrupo getPadre() { return padre; }
		});
		jsTree.setChildren(new Vector<Object>(50, 20));
		if (raiz.getHijos() != null)
		for(ProductoGrupo pg: raiz.getHijos()) {
			JsTreeNode hijo = new JsTreeNode();
			jsTree.getChildren().addElement(hijo);
			convertFromProductoGrupo(hijo, pg);
		}
		//Agrega Productos
		if (raiz.getProductos() == null)
			return;
		for(Producto prod: raiz.getProductos()) {
			JsTreeNode hijo = new JsTreeNode();
			hijo.setText(prod.getNombreCorto());
			JsTreeState pState = new JsTreeState();
			state.setOpened(false);
			hijo.setState(pState);
			hijo.setType(EnumProductoGrupoTipo.PRODUCTO.getName());
			hijo.setExtraData(new Object() {
				BigInteger id = prod.getIdProducto();
				ProductoGrupo padre = prod.getProductoGrupo();
				public BigInteger getId() { return id; }
				public ProductoGrupo getPadre() { return padre; }
				
			});
			jsTree.getChildren().addElement(hijo);
		}
	}

}
