package com.joar.fact.db.util;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class PreparedStatementExtend {

	private PreparedStatement ps;
	
	public PreparedStatementExtend(PreparedStatement ps) {
		this.ps = ps;
	}
	
	public void setInt(int parameterIndex, int x, int asNull) throws SQLException {
		if (x == asNull) {
			ps.setNull(parameterIndex, Types.INTEGER);
			return;
		}
		ps.setInt(parameterIndex, x);
	}
	
	public void setString(int parameterIndex, String x) throws SQLException {
		if (x == null) {
			ps.setNull(parameterIndex, Types.VARCHAR);
			return;
		}
		ps.setString(parameterIndex, x);
	}
	
	public void setBoolean(int parameterIndex, Boolean x) throws SQLException {
		if (x == null)
			x = false;
		ps.setBoolean(parameterIndex, x);
	}
	
	public void setDate(int parameterIndex, Date x) throws SQLException {
		if (x == null) {
			ps.setNull(parameterIndex, Types.DATE);
			return;
		}
		ps.setDate(parameterIndex, x);
	}	

}
