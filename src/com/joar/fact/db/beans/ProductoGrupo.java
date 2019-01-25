package com.joar.fact.db.beans;

import java.util.List;

public class ProductoGrupo {
	
	private int idProdGrupo;
	private Producto producto;
	private String nombre;
	private String descripcion;
	private boolean esActivo;
	private ProductoGrupoTipo grupoTipo;
	private ProductoGrupo padre;
	private List<ProductoGrupo> hijos;
	private List<Producto> productos;

	public int getIdProdGrupo() {
		return idProdGrupo;
	}
	public void setIdProdGrupo(int idProdGrupo) {
		this.idProdGrupo = idProdGrupo;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ProductoGrupoTipo getGrupoTipo() {
		return grupoTipo;
	}
	public void setGrupoTipo(ProductoGrupoTipo grupoTipo) {
		this.grupoTipo = grupoTipo;
	}
	public boolean isEsActivo() {
		return esActivo;
	}
	public void setEsActivo(boolean esActivo) {
		this.esActivo = esActivo;
	}
	public ProductoGrupo getPadre() {
		return padre;
	}
	public void setPadre(ProductoGrupo padre) {
		this.padre = padre;
	}
	public List<ProductoGrupo> getHijos() {
		return hijos;
	}
	public void setHijos(List<ProductoGrupo> hijos) {
		this.hijos = hijos;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
