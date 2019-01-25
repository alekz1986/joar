var TreeViewGrupo = function() {
	var _tvGrupo = null;
	var _data_default = [{
		'text': '[Cree un grupo]',
		'type': 'empty',
		'ex-id-value': 0
	}];
	var treeGrupo = function(data) {
		if(!data) {
			data = _data_default;
		}			
		_tvGrupo = $('#tree_grupo').jstree({
			'core': {
				'themes' : {
					'responsive': false
				},
				'check_callback': true,
				'data': data,
			},
			'types': {
				'default': {
					'icon': 'fa fa-folder m--front-brand'
				},
				'empty': {
					'icon': 'la la-circle-thin'
				},
				'grupo': {
					'icon': 'la-circle-thin m--front-brand'
				}
			},
			'state': {
				'key': 'temporal1'
			},
			'contextmenu': {
				'items': function(node) {
					if(node.type == 'empty') {
						return null;
					}
					var items = {
						'agregar_producto': {
							'separator_before': false,
							'separator_after': false,
							'label': 'Crear Grupo',
							'action': function(obj) {
								console.log("Creando grupo...");
								console.log(obj);
							}
						}
					}
					return items;
				}
			},
			'plugins': ['contextmenu', 'state', 'types'],
		});
		_tvGrupo.on('select_node.jstree', function(e,data) {
			console.log("click");
			console.log(data);
        });
	}
	
	return {
		init: treeGrupo
	};
}();


$(function() {
	TreeViewGrupo.init(null);
});
