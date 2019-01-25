package com.joar.fact.bussines;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joar.fact.bussines.exception.AppException;
import com.joar.fact.bussines.tools.AppAlert;
import com.joar.fact.bussines.tools.AppAlertType;
import com.joar.fact.db.MySqlProducto;
import com.joar.fact.db.beans.Producto;
import com.joar.fact.db.beans.ProductoGrupo;
import com.joar.fact.db.beans.Usuario;

@Service
public class NProducto {

	@Autowired
	private MySqlProducto mySqlProducto;
	
	@Autowired
	private NProductoGrupo nProductoGrupo;
	
	public void insertarProducto(Producto producto) throws Exception {
		producto.setUsuModificacion(new Usuario());
		int r = mySqlProducto.insertar(producto);
		if (r != 1) {
			AppAlert alert = new AppAlert();
			alert.setTitle("Error");
			alert.setMessage("No se pudo grabar su solicitud.");
			alert.setType(AppAlertType.ERROR.getValue());
			throw new AppException(alert);
		}
	}
	
	public List<ProductoGrupo> listarArbolConGrupos() throws Exception {
		List<ProductoGrupo> grupos = nProductoGrupo.listarArbolGruposProductos();
		List<Producto> productos = mySqlProducto.listaTodo(false);
		agregaProductoAGrupo(grupos, productos);
		return grupos;
	}
	
	public void actualizaEstado(BigInteger idProducto, boolean estado) throws Exception {
		mySqlProducto.actualizaActivo(idProducto, estado);
	}
	
	private void agregaProductoAGrupo(List<ProductoGrupo> grupos, List<Producto> productos) {
		if (productos == null)
			return;
		for(ProductoGrupo grupo: grupos) {
			for(Producto producto: productos) {
				if (grupo.getIdProdGrupo() == producto.getProductoGrupo().getIdProdGrupo()) {
					List<Producto> hijos = grupo.getProductos();
					if (hijos == null) {
						hijos = new ArrayList<Producto>();
						grupo.setProductos(hijos);
					}
					hijos.add(producto);
				}
			}
			if(grupo.getProductos() != null) {
				for(Producto p: grupo.getProductos()) {
					productos.remove(p);
				}
			}
			if(productos.size()>0) {
				agregaProductoAGrupo(grupo.getHijos(), productos);
			}
		}
	}

}
