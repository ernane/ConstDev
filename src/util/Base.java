/*
 * Created on 01/02/2005
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Base {

/* *** Base Valendo!!!!! */

	private final String JDBC_URL = "jdbc:mysql://67.205.95.237:3306/mcenge_principal";
	private final String JDBC_USR = "mcenge_main";
	private final String JDBC_PWD = "nrouXHWk&g@";
	
	
	private boolean usarDataSourceTomcat = false;

	private Connection con;

	public Connection getConnection() throws SQLException {
		reconectarCasoSejaNecessario();
		return con;
	}

	private void reconectarCasoSejaNecessario() throws SQLException {
		if ((con == null) || (con.isClosed())) {
			try {
				connect();
			} catch (SQLException sqle) {
				throw sqle;
			}
		}
	}

	private void conectarDataSource() throws SQLException {
		con = null;
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/fisio");
			con = ds.getConnection();
		} catch (NamingException e) {
			throw new SQLException(e);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
	}

	private void conectarJDBC() throws SQLException {
		con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USR, JDBC_PWD);
		} catch (ClassNotFoundException cnfe) {
			throw new SQLException(cnfe);
		} catch (SQLException sqle) {
			throw sqle;
		}
	}

	public void connect() throws SQLException {
		if (usarDataSourceTomcat) {
			conectarDataSource();
		} else {
			conectarJDBC();
		}

	}

	public void disconnect() {
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		reconectarCasoSejaNecessario();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

	@Override
	protected void finalize() throws Throwable {
		try {
			disconnect();
		} catch (Exception e) { }
		super.finalize();
	}

}