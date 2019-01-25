package com.joar.fact.bean;

import java.util.List;

public class SubHeader {

	public String icono;
	public List<SubHeaderItem> items;

	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	public List<SubHeaderItem> getItems() {
		return items;
	}
	public void setItems(List<SubHeaderItem> items) {
		this.items = items;
	}
	
}
