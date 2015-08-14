package org.phani.scheduler.dao;

import java.sql.*;

public class TestDb {

	public Connection getConnection(){
		// TODO Auto-generated method stub
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:C:/test/scheduler.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return c;
	}
	
	public void closeConnection(ResultSet rs, PreparedStatement ps, Connection c){
		// TODO Auto-generated method stub
		try {
			
			System.out.println("Close Connection");
			rs.close();
			ps.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
	}
	
	public void closeConnection(PreparedStatement ps, Connection c){
		// TODO Auto-generated method stub
		try {
			ps.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
	}

}
