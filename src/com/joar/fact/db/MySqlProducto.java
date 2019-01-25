package com.joar.fact.db;

import java.math.BigInteger;
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

import com.joar.fact.db.beans.Metrica;
import com.joar.fact.db.beans.Producto;
import com.joar.fact.db.beans.ProductoGrupo;
import com.joar.fact.db.beans.Usuario;
import com.joar.fact.db.util.PreparedStatementExt;
import com.joar.fact.db.util.PreparedStatementExtend;
import com.mysql.cj.x.protobuf.MysqlxResultset;

@Component
public class MySqlProducto {

	@Autowired
	@Qualifier("dbDataSource")
	private DataSource dataSource;
	
	public int insertar(Producto producto) throws SQLException {
		String sql = "{call sp_producto_insertar(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatementExtend psx = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			psx = new PreparedStatementExtend(ps);
			psx.setString(1, producto.getNombreCorto());
			psx.setString(2, producto.getNombreLargo());
			psx.setString(3, producto.getDescripcion());
			psx.setBoolean(4, producto.isActivo());
			psx.setInt(5, producto.getProductoGrupo().getIdProdGrupo(), 0);
			psx.setInt(6, producto.getUsuCreacion().getIdUsuario(), 0);
			psx.setInt(7, producto.getUsuModificacion().getIdUsuario(), 0);
			psx.setString(8, producto.getIdPos());
			psx.setInt(9, producto.getUnidadCompra().getIdMetrica(), 0);
			psx.setInt(10, producto.getUnidadVenta().getIdMetrica(), 0);
			psx.setInt(11, producto.getUnidadAlmacenaje().getIdMetrica(), 0);
			psx.setBoolean(12, producto.isEsComprable());
			psx.setBoolean(13, producto.isEsVendible());
			psx.setBoolean(14, producto.isEsInventariable());
			return ps.executeUpdate();
		} finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public List<Producto> listaTodo(boolean incluyeInactivos) throws SQLException {
		String sql = "{call sp_producto_listaTodo(?)}";
		List<Producto> lista = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatementExtend psx = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			psx = new PreparedStatementExtend(ps);
			psx.setBoolean(1, incluyeInactivos);
			rs = ps.executeQuery();
			while (rs.next()) {
				Producto producto = new Producto();
				ProductoGrupo pg = new ProductoGrupo();
				Usuario usuCreacion = new Usuario();
				Usuario usuModifica = new Usuario();
				Metrica uniCompra = new Metrica();
				Metrica uniVenta = new Metrica();
				Metrica uniAlmacenaje = new Metrica();
				
				producto.setIdProducto(new BigInteger(String.valueOf(rs.getLong("idProducto"))));
				producto.setNombreCorto(rs.getString("nombreCorto"));
				producto.setNombreLargo(rs.getString("nombreLargo"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setActivo(rs.getBoolean("esActivo"));
				pg.setIdProdGrupo(rs.getInt("idProdGrupo"));
				producto.setFechaCreacion(rs.getDate("fechaCreacion"));
				producto.setFechaModificacion(rs.getDate("fechaModificacion"));
				usuCreacion.setIdUsuario(rs.getInt("idUsuCreacion"));
				usuModifica.setIdUsuario(rs.getInt("idUsuModifica"));
				producto.setIdPos(rs.getString("idPos"));
				uniCompra.setIdMetrica(rs.getInt("unidadCompra"));
				uniVenta.setIdMetrica(rs.getInt("unidadVenta"));
				uniAlmacenaje.setIdMetrica(rs.getInt("unidadAlmacenaje"));
				producto.setEsComprable(rs.getBoolean("esComprable"));
				producto.setEsVendible(rs.getBoolean("esVendible"));
				producto.setEsInventariable(rs.getBoolean("esInventariable"));
				
				producto.setProductoGrupo(pg);
				producto.setUsuCreacion(usuCreacion);
				producto.setUsuModificacion(usuModifica);
				producto.setUnidadCompra(uniCompra);
				producto.setUnidadVenta(uniVenta);
				producto.setUnidadAlmacenaje(uniAlmacenaje);
				lista.add(producto);
			}
		} finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
		return lista;
	}
	
	
	public int actualizaActivo(BigInteger idProducto, boolean estado) throws SQLException {
		String sql = "{call sp_producto_actualizaActivo(?,?)}";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setObject(1, idProducto);
			ps.setBoolean(2, estado);
			return ps.executeUpdate();
		} finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
}
