<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>Metronic | Dashboard</title>
		<meta name="description" content="Latest updates and statistic charts">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
		
		<jsp:include page="/template/script-header-1"></jsp:include>
		<link href="<%=request.getContextPath()%>/recursos/vendors/jstree/dist/themes/default/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/recursos/vendors/sweetalert2/dist/sweetalert2.min.css" rel="stylesheet" type="text/css" />
		<jsp:include page="/template/script-header-2"></jsp:include>
		
	</head>
	<body class="m-page--fluid m--skin- m-content--skin-light2 m-header--fixed m-header--fixed-mobile m-aside-left--enabled m-aside-left--skin-dark m-aside-left--offcanvas m-footer--push m-aside--offcanvas-default">
		<div class="m-grid m-grid--hor m-grid--root m-page">
			<jsp:include page="/template/header"></jsp:include>
			<!--<div class="m-grid__item m-grid__item--fluid m-grid m-grid--ver-desktop m-grid--desktop m-body">-->
			<div class="m-grid__item m-grid__item--fluid m-grid m-grid--ver-desktop m-grid--desktop m-body">
				<jsp:include page="/template/aside-menu"></jsp:include>
				<div class="m-grid__item m-grid__item--fluid m-wrapper">
					<jsp:include page="/template/sub-header"></jsp:include>
					<div class="m-content">
						
						<div class="row">
							<div class="col-lg-12">
								<div class="m-portlet">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<span class="m-portlet__head-icon">
													<i class="fa flaticon-map m--font-brand"></i>
												</span>
												<h3 class="m-portlet__head-text m--font-brand">Productos</h3>
											</div>
										</div>
										<div class="m-portlet__head-tools">
											<ul class="m-portlet__nav">
												<li class="m-portlet__nav-item">
													<!-- <a href="#" class="m-portlet__nav-link btn btn-brand m-btn m-btn--icon m-btn--icon-only m-btn--pill">-->
													<a id="aRefresh" href="#" class="m-portlet__nav-link btn btn-success btn-sm m-btn m-btn-custom m-btn--icon m-btn--icon-only m-btn--pill" title="refrescar">
														<i class="la la-refresh"></i>
													</a>
												</li>
											</ul>
										</div>
									</div>
									<div id="pt-producto" class="m-portlet__body">
										<div id="tree_producto">
										</div>	
									</div>
								</div>
							</div>
						</div>
												
					</div>
				</div>
			</div>
			
			
			<div class="modal fade" id="mdlNuevoGrupo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			</div>
			
			<div class="modal fade" id="mdlNuevoProducto" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			</div>
			
			<div class="modal fade" id="mdlNuevoGrupo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			</div>
				
			<jsp:include page="/template/footer"></jsp:include>
		</div>
		<jsp:include page="/template/script-footer-1"></jsp:include>
		<script src="<%=request.getContextPath()%>/recursos/vendors/bootstrap-notify/bootstrap-notify.min.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/recursos/vendors/js/framework/components/plugins/base/bootstrap-notify.init.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/recursos/vendors/jstree/dist/jstree.js" type="text/javascript"></script>
				<script src="<%=request.getContextPath()%>/recursos/vendors/sweetalert2/dist/sweetalert2.min.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/recursos/vendors/js/framework/components/plugins/base/sweetalert2.init.js" type="text/javascript"></script>
		<jsp:include page="/template/script-footer-2"></jsp:include>
		<script type="text/javascript">
			var _PRODUCTO_getArbolProducto = "<%=request.getContextPath()%>/api/producto/arbol-productos";
			var _PRODUCTO_listarProductoGrupoTipo = "<%=request.getContextPath()%>/api/producto/listar-producto-grupo-tipo";
			var _PRODUCTO_cargaNuevoGrupo = "<%=request.getContextPath()%>/producto/nuevo-grupo";
			var _PRODUCTO_cargaNuevoProducto = "<%=request.getContextPath()%>/producto/carga-nuevo-producto";
			var _PRODUCTO_GRUPO_guardar = "<%=request.getContextPath()%>/api/producto-grupo/guardar";
			var _PRODUCTO_crearProducto = "<%=request.getContextPath()%>/api/producto/crea-producto";
			var _PRODUCTO_eliminaProducto = "<%=request.getContextPath()%>/api/producto/elimina-producto";
			var _PRODUCTO_eliminaGrupo = "<%=request.getContextPath()%>/api/producto-grupo/elimina-grupo";
			var _PRODUCTO_cargaVerDetalleGrupo = "<%=request.getContextPath()%>/producto/ver-detalle-grupo";
		</script>
		<script src="<%=request.getContextPath()%>/recursos/js/app/mantenimiento/producto.js" type="text/javascript"></script>
	</body>
</html>