package com.joar.fact.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.joar.fact.bussines.exception.AppException;
import com.joar.fact.bussines.tools.AppResponse;
import com.joar.fact.commons.Util;

@RestControllerAdvice(basePackages = {"com.joar.fact.controller.rest"})
public class RestGlobalException {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public AppResponse myGlobalError(Exception ex) {
		System.out.println(Util.getStackTrace(ex));
		AppResponse appResp = new AppResponse();
		appResp.setSuccess(false);
		appResp.setAlert(AppUtil.getAlertExceptionDefault());
	    return appResp;
	}
	
	@ExceptionHandler(AppException.class)
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	public AppResponse myAppError(AppException ex) {
		System.out.println(Util.getStackTrace(ex));
		AppResponse appResp = new AppResponse();
		appResp.setSuccess(false);
		appResp.setAlert(ex.getAlert());
	    return appResp;
	}
	
	
}
