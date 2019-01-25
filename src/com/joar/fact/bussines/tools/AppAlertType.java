package com.joar.fact.bussines.tools;

public enum AppAlertType {

	EXCEPTION(0),
	BASIC(1),
	TITLE_TEXT(2),
	WARNING(3),
	ERROR(4),
	SUCCESS(5),
	INFO(6),
	QUESTION(7),
	CUSTOM_BUTTON(8),
	CUSTOM_2_BUTTON(9),
	AUTO_CLOSE(10);
	
	
	private final int value;
	private AppAlertType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public static AppAlertType getByValue(int value) {
	    for(AppAlertType e : values()) {
	        if(e.value == value) return e;
	    }
	    return BASIC;
	}
	
}
