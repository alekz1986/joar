<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>Joar | Mantenimiento Grupo de Productos</title>
		<meta name="description" content="Latest updates and statistic charts">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
		
		<jsp:include page="/template/script-header-1"></jsp:include>
		<link href="<%=request.getContextPath()%>/recursos/vendors/jstree/dist/themes/default/style.css" rel="stylesheet" type="text/css" />
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
							<div class="col-lg-6">
								<div class="m-portlet">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<span class="m-portlet__head-icon">
													<i class="fa flaticon-map m--font-brand"></i>
												</span>
												<h3 class="m-portlet__head-text m--font-brand">Grupos</h3>
											</div>
										</div>
										<div class="m-portlet__head-tools">
											<ul class="m-portlet__nav">
												<li class="m-portlet__nav-item">
													<!-- <a href="#" class="m-portlet__nav-link btn btn-brand m-btn m-btn--icon m-btn--icon-only m-btn--pill">-->
													<a href="#" class="m-portlet__nav-link btn btn-success btn-sm m-btn m-btn-custom m-btn--icon m-btn--icon-only m-btn--pill" title="refrescar">
														<i class="la la-refresh"></i>
													</a>
												</li>
											</ul>
										</div>
									</div>
									<div id="pt-grupo" class="m-portlet__body">
										<div id="tree_grupo">
										</div>	
									</div>
								</div>
							</div>
							<div id="pt-grupo" class="col-lg-6">
								<div class="m-portlet">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<span class="m-portlet__head-icon">
													<i class="fa flaticon-edit m--font-brand"></i>
												</span>
												<h3 class="m-portlet__head-text m--font-brand">Detalle</h3>
											</div>
										</div>
										<div class="m-portlet__head-tools">
											<ul class="m-portlet__nav">
												<li class="m-portlet__nav-item">
													<!-- <a href="#" class="m-portlet__nav-link btn btn-brand m-btn m-btn--icon m-btn--icon-only m-btn--pill">-->
													<a href="#" class="m-portlet__nav-link btn btn-success btn-sm m-btn m-btn-custom m-btn--icon m-btn--icon-only m-btn--pill" title="refrescar">
														<i class="la la-refresh"></i>
													</a>
												</li>
											</ul>
										</div>
									</div>
									<!-- <form class="m-form m-form--fit m-form--label-align-right"> -->
										<div id="portlet-grupo" class="m-portlet__body">
											<div class="form-group m-form__group row">
												<label for="txtGrupoNombre" class="col-2 col-form-label">Nombre</label>
												<div class="col-10">
													<input type="text" class="form-control form-control-sm m-input" id="txtGrupoNombre" />
												</div>
											</div>
											<div class="form-group m-form__group row">
												<label for="txtGrupoDescripcion" class="col-2 col-form-label">Descripci&oacute;n</label>
												<div class="col-10">
													<input type="text" class="form-control form-control-sm m-input" id="txtGrupoDescripcion" />
												</div>
											</div>
											<div class="form-group m-form__group row">
												<label class="col-2 col-form-label">Cantidad</label>
												<div class="col-10">
													<p class="form-control-static" style="margin-top:9px;"">0</p>
												</div>
											</div>
										</div>										
									<!-- </form> -->		
									<div class="m-portlet__foot">
										<button type="submit" class="btn btn-primary btn-sm">Grabar</button>
										<span class="m--margin-left-10">or <a href="#" class="m-link m--font-bold">Cancel</a></span>
									</div>							
								</div>
							</div>
						</div>
												
					</div>
				</div>
			</div>
			<jsp:include page="/template/footer"></jsp:include>
		</div>
		<jsp:include page="/template/script-footer-1"></jsp:include>
		<script src="<%=request.getContextPath()%>/recursos/vendors/jstree/dist/jstree.js" type="text/javascript"></script>
		<jsp:include page="/template/script-footer-2"></jsp:include>
		<script type="text/javascript">
			var _GRUPO_PRODUCTO_getArbolProducto = "<%=request.getContextPath()%>/api/producto/arbol-productos"
		</script>
		<script src="<%=request.getContextPath()%>/recursos/js/app/mantenimiento/producto.js" type="text/javascript"></script>
	</body>
</html>