package com.joar.fact.bussines.tools;

import com.joar.fact.config.Ctes;

public class AppAlert {

	public String title;
	public String message;
	public int type;
	public String confirmMessage;
	public String cancelMessage;

	public AppAlert() {
		this.title = Ctes.AppAlert.DEFAULT_TITLE;
		this.type = AppAlertType.CUSTOM_BUTTON.getValue();
		this.confirmMessage = Ctes.AppAlert.DEFAULT_CONFIRM_BUTTON;
		this.cancelMessage = Ctes.AppAlert.DEFAULT_CANCEL_BUTTON;
	}
	
	public AppAlert(String title, String message, int type, String confirmMessage, String cancelMessage) {
		this.title = title;
		this.message = message;
		this.type = type;
		this.confirmMessage = confirmMessage;
		this.cancelMessage = cancelMessage;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getConfirmMessage() {
		return confirmMessage;
	}
	public void setConfirmMessage(String confirmMessage) {
		this.confirmMessage = confirmMessage;
	}
	public String getCancelMessage() {
		return cancelMessage;
	}
	public void setCancelMessage(String cancelMessage) {
		this.cancelMessage = cancelMessage;
	}
	
}
