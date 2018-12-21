package com.joar.fact.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.joar.fact.db.beans.Usuario;

@Configuration
@Component
public class MySqlUsuario {

	@Autowired
	@Qualifier("dbDataSource")
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public Usuario getUsuario(String strUsu, String clave) throws SQLException {
		Usuario usuario = null;
		try(Connection con = dataSource.getConnection()) {
			String sql = "{call sp_usuario_obtienePorUsuClave(?, ?)}";
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, strUsu);
				ps.setString(2, clave);
				try (ResultSet rs = ps.executeQuery()) {
					usuario = new Usuario();
					if(rs.next()) {
						usuario.setIdUsuario(rs.getInt("idUsuario"));
						usuario.setUsuario(rs.getString("usuario"));
						usuario.setClave(rs.getString("clave"));
						usuario.setEstado(rs.getString("estado"));
					}
				}
			}
		}
		return usuario;
	}
	
}
