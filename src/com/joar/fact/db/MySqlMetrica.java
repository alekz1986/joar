package com.joar.fact.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.joar.fact.db.beans.Metrica;

@Component
public class MySqlMetrica {

	@Autowired
	@Qualifier("dbDataSource")
	private DataSource dataSource;
	
	public List<Metrica> listarTodo(boolean incluyeInactivos) throws SQLException {
		String sql = "{call sp_metrica_listarTodo(?)}";
		List<Metrica> lista = new ArrayList<Metrica>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setBoolean(1, incluyeInactivos);
			rs = ps.executeQuery();
			while (rs.next()) {
				Metrica metrica = new Metrica();
				metrica.setIdMetrica(rs.getInt("idMetrica"));
				metrica.setDescripcion(rs.getString("descripcion"));
				metrica.setSimbolo(rs.getString("simbolo"));
				metrica.setEsActivo(rs.getBoolean("esActivo"));
				lista.add(metrica);
			}
		} finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
		return lista;
	}
}
