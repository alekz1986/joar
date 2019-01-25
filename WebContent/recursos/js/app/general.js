
var __alert_type_EXCEPTION = 0;
var __alert_type_BASIC = 1;
var __alert_type_TITLE_TEXT = 2;
var __alert_type_WARNING = 3;
var __alert_type_ERROR = 4;
var __alert_type_SUCCESS = 5;
var __alert_type_INFO = 6;
var __alert_type_QUESTION = 7;
var __alert_type_CUSTOM_BUTTON = 8;
var __alert_type_CUSTOM_2_BUTTON = 9;
var __alert_type_AUTO_CLOSE = 10;


var Notify = function() {
	var show = function(content, options) {
		console.log(content);
		var localcontent = {};
		var localoptions = {
			//type: 'danger',
            allow_dismiss: true,
            newest_on_top: false,
            mouse_over:  false,
            showProgressbar:  false,
            spacing: 10,                    
            timer: 4000,
            placement: {
                from: 'top', 
                align: 'right'
            },
            offset: {
                x: 30, //30 
                y: 30  //30
            },
            delay: 1500, //tiempo que permanece la notificacion.
            z_index: 10000,
            animate: {
                enter: 'animated ' + 'fadeInRight',
                exit: 'animated ' + 'fadeOut'
            }
		};
		localcontent.icon = 'none';
		$.extend(localcontent, content);
		$.extend(localoptions, options);
		$.notify(localcontent, localoptions);
	};
	
	var showException = function(alert) {
		Notify.show({
			message: alert.message,
			title: alert.title,
			icon: 'icon flaticon-warning'
		}, {
			type: 'danger'
		});
	};
	
	return {
		show: show,
		showException: showException
	}
}();


var JoarSweetAlert = function() {
	var basic = function(message) {
		swal(message);
	};
	var basicTitleText = function(title, message) {
		swal(title, message);
	}
	var warning = function(alert) {
		swal(alert.title, alert.message, "warning");
	};
	var error = function(alert) {
		swal(alert.title, alert.message, "error");
	};
	var success = function(alert) {
		swal(alert.title, alert.message, "success");
	};
	var customButton = function(data) {
		var config = {
			confirmButtonClass: 'btn btn-primary m-btn m-btn--pill m-btn--air',
			confirmButtonText: 'Ok'
		};
		$.extend(config, data);
		swal(config);
	};
	return {
		basic: basic,
		basicTitleText: basicTitleText,
		warning: warning,
		error: error,
		customButton: customButton
	}
}();

var JoarAlert = function() {
	var show = function(alert) {
		switch(alert.type) {
			case __alert_type_EXCEPTION:
				Notify.showException(alert);
				break;
			case __alert_type_BASIC:
				JoarSweetAlert.basic(alert.message);
				break;
			case __alert_type_TITLE_TEXT:
				console.log("__alert_type_TITLE_TEXT = " + __alert_type_TITLE_TEXT);
				break;
			case __alert_type_WARNING:
				JoarSweetAlert.warning(alert);
				break;
			case __alert_type_ERROR:
				JoarSweetAlert.error(alert);
				break;
			case __alert_type_CUSTOM_BUTTON:
				JoarSweetAlert.customButton({
					title: alert.title,
					text: alert.message
				});
				break;
			default:
				console.log("alert not configured");
				break;
		}
	};
	return {
		show: show
	}
}();

//events
$(document).ajaxError(function (event, jqxhr, settings, thrownError) {
	console.log("$(document).ajaxError");
	var data = jqxhr.responseJSON;
	if (data && data.alert) {
		JoarAlert.show(data.alert);
	} else {
		JoarAlert.show({
			title: __EXCEPTION_DEFAULT_TITLE,
			message: __EXCEPTION_DEFAULT_MESSAGE,
			type: __alert_type_EXCEPTION
		});
	}
});

//overrides
var __i = 0;

$(document).ajaxSend(function(event, request, settings) {
	__i++;
	console.log("block! i=" + __i);
	if (__i == 1) {
		mApp.blockPage({
	        overlayColor: '#1a000d',
	        type: 'loader',
	        state: 'primary',
	        message: 'Espere por favor...'
	    });
	}
});
$(document).ajaxComplete(function(event, request, settings) {
	__i--;
    console.log("unblock! i=" + __i);
    if (__i <= 0) {
    	mApp.unblockPage();
    }
});
