package com.joar.fact.bussines;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joar.fact.db.MySqlMetrica;
import com.joar.fact.db.MySqlProductoGrupoTipo;
import com.joar.fact.db.beans.Metrica;

@Service
public class NMetrica {

	@Autowired
	private MySqlMetrica mySqlMetrica;
	
	
	public List<Metrica> listarTodo() throws Exception {
		return mySqlMetrica.listarTodo(true);
	}
	
	public List<Metrica> listarActivos() throws Exception {
		return mySqlMetrica.listarTodo(false);
	}
	
}
