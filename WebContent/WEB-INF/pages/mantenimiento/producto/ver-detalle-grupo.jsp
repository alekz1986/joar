<div class="modal-dialog" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<h5 class="modal-title" id="exampleModalLabel"><%=titulo%></h5>
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<div class="modal-body">
			<form>
				<input type="hidden" id="npgtIdGrupoTipo" value="<%=pgt.getIdGrupoTipo()%>"/>
				<input type="hidden" id="pgIdProdGrupoPadre" value="<%=pg.getIdProdGrupo()%>"/>
				<div class="form-group">
					<label for="recipient-name" class="form-control-label">Descripci&oacute;n:</label>
					<input type="text" class="form-control" id="npgtDescripcion">
				</div>
				<div class="form-group m-form__group m--margin-top-10">
					<div class="alert m-alert m-alert--default" role="alert">
						Se crear� dentro de "<%=dentroDe%>"
					</div>
				</div>
			</form>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
			<button id="btnNuevoPG" type="button" class="btn btn-primary">Crear</button>
		</div>
	</div>
</div>