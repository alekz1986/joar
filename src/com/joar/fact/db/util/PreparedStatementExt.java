package com.joar.fact.db.util;


import java.sql.SQLException;
import java.sql.Types;

import com.mysql.cj.ParseInfo;
import com.mysql.cj.jdbc.ClientPreparedStatement;
import com.mysql.cj.jdbc.JdbcConnection;

public class PreparedStatementExt extends ClientPreparedStatement {

	protected PreparedStatementExt(JdbcConnection conn, String catalog) throws SQLException {
		super(conn, catalog);
	}
	
	public PreparedStatementExt(JdbcConnection conn, String sql, String catalog) throws SQLException {
		super(conn, sql, catalog);
	}

	public PreparedStatementExt(JdbcConnection conn, String sql, String catalog, ParseInfo cachedParseInfo)
			throws SQLException {
		super(conn, sql, catalog, cachedParseInfo);
	}

	public void setIntOrNull(int parameterIndex, int x, int asNull) throws SQLException {
		if (x == asNull)
			super.setNull(parameterIndex, Types.INTEGER);
		super.setInt(parameterIndex, x);
	}
		

}
