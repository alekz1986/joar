package com.joar.fact.db.beans;

public class ProductoGrupoTipo {

	private int idGrupoTipo;
	private String descripcion;
	private boolean esActivo;
	private int nivel;
	
	public int getIdGrupoTipo() {
		return idGrupoTipo;
	}
	public void setIdGrupoTipo(int idGrupoTipo) {
		this.idGrupoTipo = idGrupoTipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isEsActivo() {
		return esActivo;
	}
	public void setEsActivo(boolean esActivo) {
		this.esActivo = esActivo;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}	
	
}
