package com.joar.fact.bussines.exception;

import com.joar.fact.bussines.tools.AppAlert;
import com.joar.fact.config.AppUtil;

public class AppException extends Exception {

	private AppAlert alert;
	
	public AppException() {
		super();
		getAlert();
	}
	
	public AppException(AppAlert alert) {
		super(AppUtil.getFullMessageException(alert));
		this.alert = getAlert(alert);
	}
	
	public AppException(Throwable cause) {
		super(cause);
		this.alert = getAlert(null);
	}
	
	public AppException(AppAlert alert, Throwable cause) {
		super(AppUtil.getFullMessageException(alert), cause);
		this.alert = getAlert(alert);
	}
	
	public AppException(AppAlert alert, Throwable cause, boolean enableSuppression, 
			boolean writableStackTrace) {
		super(AppUtil.getFullMessageException(alert), 
				cause, enableSuppression, writableStackTrace);
		this.alert = getAlert(alert);
	}
	
	private AppAlert getAlert(AppAlert alert) {
		return alert == null ? 
				AppUtil.getAlertExceptionDefault() :
					alert;
	}

	public AppAlert getAlert() {
		return alert;
	}
	
	
	
}
