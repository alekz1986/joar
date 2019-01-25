package com.joar.fact.db.beans;

import java.math.BigInteger;
import java.sql.Date;

public class Producto {

	private BigInteger idProducto;
	private String nombreCorto;
	private String nombreLargo;
	private String descripcion;
	private boolean activo;
	
	private ProductoGrupo productoGrupo;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Usuario usuCreacion;
	private Usuario usuModificacion;
	private String idPos;
	private Metrica unidadCompra;
	private Metrica unidadVenta;
	private Metrica unidadAlmacenaje;
	private boolean esComprable;
	private boolean esVendible;
	private boolean esInventariable;
	

	public BigInteger getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(BigInteger idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public String getNombreLargo() {
		return nombreLargo;
	}
	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public ProductoGrupo getProductoGrupo() {
		return productoGrupo;
	}
	public void setProductoGrupo(ProductoGrupo productoGrupo) {
		this.productoGrupo = productoGrupo;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public Usuario getUsuCreacion() {
		return usuCreacion;
	}
	public void setUsuCreacion(Usuario usuCreacion) {
		this.usuCreacion = usuCreacion;
	}
	public Usuario getUsuModificacion() {
		return usuModificacion;
	}
	public void setUsuModificacion(Usuario usuModificacion) {
		this.usuModificacion = usuModificacion;
	}
	public String getIdPos() {
		return idPos;
	}
	public void setIdPos(String idPos) {
		this.idPos = idPos;
	}
	public Metrica getUnidadCompra() {
		return unidadCompra;
	}
	public void setUnidadCompra(Metrica unidadCompra) {
		this.unidadCompra = unidadCompra;
	}
	public Metrica getUnidadVenta() {
		return unidadVenta;
	}
	public void setUnidadVenta(Metrica unidadVenta) {
		this.unidadVenta = unidadVenta;
	}
	public Metrica getUnidadAlmacenaje() {
		return unidadAlmacenaje;
	}
	public void setUnidadAlmacenaje(Metrica unidadAlmacenaje) {
		this.unidadAlmacenaje = unidadAlmacenaje;
	}
	public boolean isEsComprable() {
		return esComprable;
	}
	public void setEsComprable(boolean esComprable) {
		this.esComprable = esComprable;
	}
	public boolean isEsVendible() {
		return esVendible;
	}
	public void setEsVendible(boolean esVendible) {
		this.esVendible = esVendible;
	}
	public boolean isEsInventariable() {
		return esInventariable;
	}
	public void setEsInventariable(boolean esInventariable) {
		this.esInventariable = esInventariable;
	}
	
}
