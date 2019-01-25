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
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.joar.fact.db.beans.ProductoGrupo;
import com.joar.fact.db.beans.ProductoGrupoTipo;

@Component
public class MySqlProductoGrupoTipo {

	@Autowired
	@Qualifier("dbDataSource")
	private DataSource dataSource;
		
	public List<ProductoGrupoTipo> listarTodo() throws SQLException {
		List<ProductoGrupoTipo> lista = new ArrayList<ProductoGrupoTipo>();
		String sql = "{call sp_productoGrupoTipo_listaTodo()}";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductoGrupoTipo pgt = new ProductoGrupoTipo();
				pgt.setIdGrupoTipo(rs.getInt("idGrupoTipo"));
				pgt.setDescripcion(rs.getString("descripcion"));
				pgt.setEsActivo(rs.getBoolean("esActivo"));
				pgt.setNivel(rs.getInt("nivel"));
				lista.add(pgt);
			}
		} finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
		return lista;
	}
	
	public ProductoGrupoTipo obtenerPorId(int idGrupoTipo) throws SQLException {
		ProductoGrupoTipo pgt = null;
		String sql = "{call sp_productoGrupoTipo_obtenerPorId(?)}";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, idGrupoTipo);
			rs = ps.executeQuery();
			if (rs.next()) {
				pgt = new ProductoGrupoTipo();
				pgt.setIdGrupoTipo(rs.getInt("idGrupoTipo"));
				pgt.setDescripcion(rs.getString("descripcion"));
				pgt.setEsActivo(rs.getBoolean("esActivo"));
				pgt.setNivel(rs.getInt("nivel"));
			}
		} finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
		return pgt;
	}
	
	
}
