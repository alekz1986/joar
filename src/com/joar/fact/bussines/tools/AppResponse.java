package com.joar.fact.bussines.tools;

import java.io.Serializable;

public class AppResponse implements Serializable {

	private boolean success;
	private AppAlert alert;
	private Object data;

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public AppAlert getAlert() {
		return alert;
	}
	public void setAlert(AppAlert alert) {
		this.alert = alert;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
