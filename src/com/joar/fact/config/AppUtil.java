package com.joar.fact.config;

import com.joar.fact.bussines.tools.AppAlert;
import com.joar.fact.bussines.tools.AppAlertType;

public class AppUtil {

	public static AppAlert getAlertExceptionDefault() {
		AppAlert alert = new AppAlert();
		alert.setTitle(Ctes.AppAlert.ERROR_DEFAULT_TITLE);
		alert.setMessage(Ctes.AppAlert.ERROR_DEFAULT_MESSAGE);
		alert.setType(AppAlertType.EXCEPTION.getValue());
		return alert;
	}
	
	public static String getFullMessageException(AppAlert alert) {
		return (alert.getTitle() == null) ? alert.getMessage() :
				alert.getTitle() + ", " + alert.getMessage();
	}
}
