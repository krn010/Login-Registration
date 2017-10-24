package com.d;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public abstract class Dbutil {

	

	static ComboPooledDataSource ds = null;

	private static ComboPooledDataSource initDs() {
		if (ds == null) {
			ds = new ComboPooledDataSource();
			try {
				ds.setDriverClass("com.mysql.jdbc.Driver");
				ds.setJdbcUrl("JDBC:mysql://localhost:3306/Reg");
				ds.setUser("root");
				ds.setPassword("root");
				ds.setMinPoolSize(5);
				ds.setAcquireIncrement(5);
				ds.setMaxPoolSize(20);

			} catch (PropertyVetoException e) {
				
				e.printStackTrace();
			} 

		}
		
		return ds;
	}

	public static Connection getConnection() throws SQLException {
		initDs();
		return ds.getConnection();
	}

	public static void closeConnection()
		{
			ds.close();
		}
}
