package com.joar.fact.db.beans;

public class Metrica {

	private int idMetrica;
	private String descripcion;
	private String simbolo;
	private boolean esActivo;
	
	public int getIdMetrica() {
		return idMetrica;
	}
	public void setIdMetrica(int idMetrica) {
		this.idMetrica = idMetrica;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
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
	
}
