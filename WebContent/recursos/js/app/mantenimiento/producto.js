//Tree View Producto
var TreeViewProducto = function() {
	
	var _tvProducto = null;
	var _data_raiz = [{
			'text': 'Raiz',
			'type': 'principal',
			extraData: {
				id: 0
			},
			'ex-id-value': 0,
			'ex-nivel' : _nivelTreeMaximo
		}];
	
	var treeProducto = function(data, menu) {
		treeData = _data_raiz;
		treeData[0].children = data;
		_tvProducto = $('#tree_producto').jstree({
			'core': {
				'themes' : {
					'responsive': false
				},
				'check_callback': true,
				'data': treeData,
			},
			'types': {
				'principal': {
					'icon': 'fa fa-book-open m--front-brand'
				},
				'empty': {
					'icon': 'la la-question-circle'
				},
				'familia': {
					'icon': 'fa fa-folder m--font-danger m--front-brand'
				},
				'subfamilia': {
					'icon': 'fa fa-folder m--font-warning m--front-brand'
				},
				'categoria': {
					'icon': 'fa fa-folder m--font-info m--front-brand'
				},
				'producto': {
					'icon': 'fa flaticon-tool-1 m--font-info m--front-brand'
				}
			},
			'state': {
				'key': 'temporal1'
			},
			'contextmenu': {
				'items': menu
			},
			'plugins': ['contextmenu', 'state', 'types'],
		});
		_tvProducto.on('select_node.jstree', function(e,data) {
			console.log("click");
        });
	}
	
	var cargarNuevaData = function(d) {
		treeData = _data_raiz;
		treeData[0].children = d.data;
		_tvProducto.jstree(true).settings.core.data = treeData;
		_tvProducto.jstree(true).refresh();
	}
	
	var refrescarArbol = function() {
		getData(cargarNuevaData);
	}
	
	var getData = function(f) {
		$.ajax({
		  type: "GET",
		  url: _PRODUCTO_getArbolProducto,
		  //data: data,
		  success: function(data, textStatus) {
			  f(data);
		  },
		  dataType: "json"
		});
	}
	
	return {
		init: function(menu) {
			getData(function(response) {
				treeProducto(response.data, menu);
			})
		},
		refrescar: refrescarArbol,
		cargar: cargarNuevaData,
		getData: getData,
	};
}();


var _tipoGrupos = null; 
var _nivelTreeMaximo = null;
var _nivel3 = 3;
var _nivel2 = 2;
var _nivel1 = 1;


var listarTipoGrupos = function(afterSuccess) {
	$.ajax({
		type: "GET",
		url: _PRODUCTO_listarProductoGrupoTipo,
		success: function(resp, textStatus) {
			_tipoGrupos = resp.data;
			afterSuccess();
		},
		error: function() {
			console.log("manipulacion ajax error");
		},
		dataType: "json"
	});
}

var treeContextMenu = function(node) {
	var options = { 
		'ver': {
			'separator_before': false,
			'separator_after': false,
			'label': 'Ver Detalle',
			'id': node.original.extraData.id,
		},
		'nuevo': {
			'separator_before': false,
			'separator_after': false,
			'label': 'Crear',
			'idProdGrupo': node.original.extraData.id,
		},
		'eliminar': {
			'separator_before': false,
			'separator_after': false,
			'label': 'Eliminar',
			'id': node.original.extraData.id,
			'action': function(obj) {
				eliminaGrupo(obj.item.id);
			}
		}
	};
	for (var i = 0, len = _tipoGrupos.length; i < len; i++) {
		var item = _tipoGrupos[i];
		if ((node.type == 'principal' && _nivel3 == item.nivel) ||
			(node.type == 'familia' && _nivel2 == item.nivel) ||
			(node.type == 'subfamilia' && _nivel1 == item.nivel)) {
			return $.extend(true, options, {
				'ver': {
					'action': function(obj) {
						verDetalleGrupo(obj.item.idProdGrupo, obj.item.idGrupoTipo);
					}
				},
				'nuevo': {
					'label': 'Crear ' + item.descripcion,
					'idGrupoTipo': item.idGrupoTipo,
					'action': function(obj) {
						nuevoGrupo(obj.item.idProdGrupo, obj.item.idGrupoTipo);
					}
				},
			});
		}
	}
	if (node.type == 'categoria') {
		return $.extend(true, options, {
			'ver': {
				'action': function(obj) {
					verDetalleGrupo(obj.item.idProdGrupo, obj.item.idGrupoTipo);
				}
			},
			'nuevo': {
				'label': 'Crear Producto',
				'action': function(obj) {
					nuevoProducto(obj.item.idProdGrupo);
				}
			},
		});
	}
	if (node.type == 'producto') {
		var p = $.extend(true, options, {
			'ver': {
				'action': function(obj) {
					verDetalleProducto(obj.item.id);
				}
			},
			'eliminar': {
				'action': function(obj) {
					eliminaProducto(obj.item.id);
				}
			}
		});
		delete p.nuevo;
		return p;
	}
}

function verDetalleGrupo(idProdGrupo) {
	$.ajax({
		type: "GET",
		url: _PRODUCTO_cargaNuevoGrupo,
		data: {
			idProdGrupoPadre: idProdGrupo,
			idGrupoTipo: idGrupoTipo
		},
		success: function(resp, textStatus) {
			$("#mdlNuevoGrupo").html(resp);
			$('#mdlNuevoGrupo').modal();
			$("#btnNuevoPG").click(function() {
				crearGrupo();
			});
		},
	});
}

function verDetalleProducto(id) {
	
}

function arbolNivelMaximo() {
	_nivelTreeMaximo = 0;
	for (var i = 0, len = _tipoGrupos.length; i < len; i++) {
		var item = _tipoGrupos[i];
		if (_nivelTreeMaximo < item.nivel) {
			_nivelTreeMaximo = item.nivel;
		}
	}
}

function nuevoGrupo(idProdGrupo, idGrupoTipo) {
	$.ajax({
		type: "GET",
		url: _PRODUCTO_cargaNuevoGrupo,
		data: {
			idProdGrupoPadre: idProdGrupo,
			idGrupoTipo: idGrupoTipo
		},
		success: function(resp, textStatus) {
			$("#mdlNuevoGrupo").html(resp);
			$('#mdlNuevoGrupo').modal();
			$("#btnNuevoPG").click(function() {
				crearGrupo();
			});
		},
	});
}

function nuevoProducto(idProdGrupo) {
	$.ajax({
		type: "GET",
		url: _PRODUCTO_cargaNuevoProducto,
		data: {
			idProdGrupoPadre: idProdGrupo
		},
		success: function(resp, textStatus) {
			$("#mdlNuevoProducto").html(resp);
			$('#mdlNuevoProducto').modal();
			$("#btnNuevoProd").click(function() {
				crearProducto();
			});
		},
	});
}


function eliminaProducto(idProducto) {
	console.log("elimina: " + idProducto);
	swal({
        title: '\u00bfEst\u00e1 seguro?',
        text: "Se borrar\u00e1 lo seleccionado, esta acci\u00F3n no puede revertirse.",
        type: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Si',
        cancelButtonText: 'No',
        reverseButtons: true
    }).then(function(result){
        if (result.value) {
        	console.log("eliminando...");
        	var _data = {
        		idProducto: idProducto + ""
        	};
        	console.log(_data);
        	$.ajax({
        		type: "POST",
        		url: _PRODUCTO_eliminaProducto,
        		data: _data,
        		success: function(resp, textStatus) {
        			console.log("eliminado");
        			TreeViewProducto.refrescar();
        		},
        		dataType: "json"
        	});
        }
    });
}

function eliminaGrupo(idProdGrupo) {
	console.log("elimina");
	swal({
        title: '\u00bfEst\u00e1 seguro?',
        text: "Se borrar\u00e1 lo seleccionado y todo su contenido, esta acci\u00F3n no puede revertirse.",
        type: 'question',
        showCancelButton: true,
        confirmButtonText: 'Si',
        cancelButtonText: 'No',
        reverseButtons: true
    }).then(function(result){
    	if (result.value) {
        	console.log("eliminando...");
        	var _data = {
        		idProdGrupo: idProdGrupo
        	};
        	console.log(_data);
        	$.ajax({
        		type: "POST",
        		url: _PRODUCTO_eliminaGrupo,
        		data: _data,
        		success: function(resp, textStatus) {
        			TreeViewProducto.refrescar();
        		},
        		dataType: "json"
        	});
        }
    });
}



function crearGrupo() {
	$.ajax({
		type: "PUT",
		url: _PRODUCTO_GRUPO_guardar,
		data: JSON.stringify({
			descripcion: $("#npgtDescripcion").val(),
			esActivo: true,
			grupoTipo: {
				idGrupoTipo: $("#npgtIdGrupoTipo").val(),
			},
			padre: {
				idProdGrupo: $("#pgIdProdGrupoPadre").val(), 
			}
		}),
		success: function(resp, textStatus) {
			$('#mdlNuevoGrupo').modal('hide');
			TreeViewProducto.refrescar();
		},
		contentType: "application/json; charset=utf-8",
		dataType: "json"
	});
}

function crearProducto() {
	$.ajax({
		type: "POST",
		url: _PRODUCTO_crearProducto,
		data: JSON.stringify({
			nombreCorto: $("#npNomCorto").val(),
			nombreLargo: $("#npNomLargo").val(),
			descripcion: $("textarea#npDescripcion").val(),
			productoGrupo: {
				idProdGrupo: $("#npIdProdGrupo").val()
			},
			idPos: $("#idPos").val(),
			unidadCompra: { 
				idMetrica: $("#npUnidCompra").val(),
			},
			unidadVenta: { 
				idMetrica: $("#npUnidVenta").val(),
			},
			unidadAlmacenaje: { 
				idMetrica: $("#npUnidAlmacenaje").val(),
			},
			esComprable: $("npEsComprable").is(":checked"),
			esVendible: $("npEsVendible").is(":checked"),
			esInventariable: $("npEsInventariable").is(":checked"),
		}),
		success: function(resp, textStatus) {
			$('#mdlNuevoProducto').modal('hide');
			TreeViewProducto.refrescar();
		},
		contentType: "application/json; charset=utf-8",
		dataType: "json"
	});
}

$(function() {
	listarTipoGrupos(function() {
		if (_tipoGrupos) {
			arbolNivelMaximo();
			TreeViewProducto.init(treeContextMenu);
		}
	});
	
	$("#aRefresh").click(function() {
		TreeViewProducto.refrescar();
	});
});
