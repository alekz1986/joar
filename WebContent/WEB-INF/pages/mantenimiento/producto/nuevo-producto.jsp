<%@page import="com.joar.fact.db.beans.Metrica, 
				java.util.List,
				com.joar.fact.config.CtesAtr,
				com.joar.fact.db.beans.ProductoGrupo" %>
<%
ProductoGrupo pg = (ProductoGrupo)request.getAttribute(CtesAtr.PRODUCTO_GRUPO);
List<Metrica> metricas = (List<Metrica>)request.getAttribute(CtesAtr.PRODUCTO_METRICAS);
%>
<div class="modal-dialog modal-lg" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<h5 class="modal-title" id="exampleModalLabel">Nuevo Producto</h5>
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<form class="m-form m-form--fit m-form--label-align-right ">
			<input type="hidden" id="npIdProdGrupo" value="<%=pg.getIdProdGrupo()%>" />
			<div class="modal-body">
				<div class="form-group m-form__group row m-form-bottom-fix">
					<div class="col-lg-6">
						<label>Nombre Corto:</label>
						<input id="npNomCorto" type="text" class="form-control m-input m-input--air" placeholder="Como etiqueta del producto">
					</div>
					<div class="col-lg-6">
						<label>Nombre Largo:</label>
						<input id="npNomLargo" type="text" class="form-control m-input m-input--air" placeholder="Detalle adicional para identificar al producto">
					</div>					
				</div>
				<div class="m-form-bottom-fix form-group m-form__group row">
					<div class="col-lg-12">
						<label>Descripci&oacute;n:</label>
						<textarea id="npDescripcion" class="form-control m-input m-input--air" rows="3" style="margin-top: 0px; margin-bottom: 0px; height: 60px;"></textarea>
					</div>
				</div>				
				<div class="m-form-bottom-fix form-group m-form__group row">
					<div class="col-lg-4">
						<label>Unidad de Compra</label>
						<select id="npUnidCompra" class="form-control m-input m-input--air">
							<option value="-" selected="selected">Seleccione</option>
							<%for(Metrica m: metricas) {%>
							<option value="<%=m.getIdMetrica()%>"><%=m.getDescripcion()%></option>
							<%}%>
						</select>
					</div>
					<div class="col-lg-4">
						<label>Unidad de Venta</label>
						<select id="npUnidVenta" class="form-control m-input m-input--air">
							<option value="-" selected="selected">Seleccione</option>
							<%for(Metrica m: metricas) {%>
							<option value="<%=m.getIdMetrica()%>"><%=m.getDescripcion()%></option>
							<%}%>
						</select>
					</div>
					<div class="col-lg-4">
						<label>Unidad de Almacenaje</label>
						<select id="npUnidAlmacenaje" class="form-control m-input m-input--air">
							<option value="-" selected="selected">Seleccione</option>
							<%for(Metrica m: metricas) {%>
							<option value="<%=m.getIdMetrica()%>"><%=m.getDescripcion()%></option>
							<%}%>
						</select>
					</div>
				</div>
				<div class="m-form-bottom-fix form-group m-form__group row">
					<div class="col-lg-4">
						<label>¿Es Comprable?</label>
						<div>
							<span class="m-switch m-switch--sm m-switch--icon">
								<label>
									<input id="npEsComprable" type="checkbox" name="">
									<span></span>
								</label>
							</span>
						</div>
					</div>
					<div class="col-lg-4">
						<label>¿Es Vendible?</label>
						<div>
							<span class="m-switch m-switch--sm m-switch--icon">
								<label>
									<input id="npEsVendible" type="checkbox" name="">
									<span></span>
								</label>
							</span>
						</div>
					</div>
					<div class="col-lg-4">
						<label>¿Es Inventariable?</label>
						<div>
							<span class="m-switch m-switch--sm m-switch--icon">
								<label>
									<input id="npEsInventariable" type="checkbox" name="">
									<span></span>
								</label>
							</span>
						</div>
					</div>
				</div>
				
			</div>
		</form>
		<div class="modal-footer">
			<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
			<button id="btnNuevoProd" type="button" class="btn btn-primary">Crear</button>
		</div>
	</div>
</div>