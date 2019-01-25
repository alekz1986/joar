package com.joar.fact.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.joar.fact.db.beans.ProductoGrupo;
import com.joar.fact.db.beans.ProductoGrupoTipo;

@Component
public class MySqlProductoGrupo {

	@Autowired
	@Qualifier("dbDataSource")
	private DataSource dataSource;
	
	public ProductoGrupo obtenerPorId(int idProdGrupo) throws SQLException {
		String sql = "{call sp_productoGrupo_obtenerPorId(?)}";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductoGrupo pg = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, idProdGrupo);
			rs = ps.executeQuery();
			if (rs.next()) {
				pg = new ProductoGrupo();
				pg.setIdProdGrupo(rs.getInt("idProdGrupo"));
				pg.setDescripcion(rs.getString("descripcion"));
				pg.setEsActivo(rs.getBoolean("esActivo"));
				
				int idPadreProdGrupo = rs.getInt("idPadreProdGrupo");
				int idGrupoTipo = rs.getInt("idGrupoTipo");
			}
			return pg;
		} finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int insertar(ProductoGrupo pg) throws SQLException {
		String sql = "{call sp_productoGrupo_insertar(?,?,?,?)}";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, pg.getDescripcion());
			ps.setBoolean(2, pg.isEsActivo());
			if(pg.getPadre()!=null && pg.getPadre().getIdProdGrupo()!=0)
				ps.setInt(3, pg.getPadre().getIdProdGrupo());
			else 
				ps.setNull(3, Types.INTEGER);
			ps.setInt(4, pg.getGrupoTipo().getIdGrupoTipo());
			return ps.executeUpdate();
		} finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public List<ProductoGrupo> listaActivos() throws SQLException {
		List<ProductoGrupo> lista = new ArrayList<ProductoGrupo>();
		String sql = "{call sp_productoGrupo_listaActivos}";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ProductoGrupo pg = new ProductoGrupo();
				ProductoGrupo padre = new ProductoGrupo();
				ProductoGrupoTipo pgt = new ProductoGrupoTipo();
				pg.setIdProdGrupo(rs.getInt("idProdGrupo"));
				pg.setDescripcion(rs.getString("descripcion"));
				pg.setEsActivo(rs.getBoolean("esActivo"));
				padre.setIdProdGrupo(rs.getInt("idPadreProdGrupo"));
				pg.setPadre(padre);
				pgt.setIdGrupoTipo(rs.getInt("idGrupoTipo"));
				pgt.setNivel(rs.getInt("nivel"));
				pgt.setDescripcion(rs.getString("tipo_descripcion"));
				pg.setGrupoTipo(pgt);
				lista.add(pg);
			}
		} finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
		return lista;
	}
	
	public void eliminaGrupoEnCascada(int idProdGrupo) throws SQLException {
		String sql = "{call sp_productoGrupo_inactivaEnCascada(?)}";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, idProdGrupo);
			ps.executeUpdate();
		} finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
}
