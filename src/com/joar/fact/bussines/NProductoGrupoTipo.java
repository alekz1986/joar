package com.joar.fact.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joar.fact.bussines.exception.AppException;
import com.joar.fact.bussines.tools.AppAlert;
import com.joar.fact.bussines.tools.AppAlertType;
import com.joar.fact.config.Ctes;
import com.joar.fact.db.MySqlProductoGrupoTipo;
import com.joar.fact.db.beans.ProductoGrupoTipo;

@Service
public class NProductoGrupoTipo {

	@Autowired
	private MySqlProductoGrupoTipo mySqlProductoGrupoTipo;
	
	
	public List<ProductoGrupoTipo> obtenerListaCompleta() throws Exception {
		List<ProductoGrupoTipo> lista;
		lista = mySqlProductoGrupoTipo.listarTodo();
		if (lista == null || lista.size() == 0) {
			throw new AppException(new AppAlert(
					"Error De Configuración", 
					"No se encuentran configurados los grupos", 
					AppAlertType.ERROR.getValue(), 
					Ctes.AppAlert.DEFAULT_CONFIRM_BUTTON,
					Ctes.AppAlert.DEFAULT_CANCEL_BUTTON));
		}
		return lista;
	}

	public ProductoGrupoTipo obtenerPorId(int idGrupoTipo) throws Exception {
		return mySqlProductoGrupoTipo.obtenerPorId(idGrupoTipo);
	}
}
