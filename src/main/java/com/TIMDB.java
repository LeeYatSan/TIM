package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TIMDB {
	public static void save(String user,String password) throws SQLException {
		Connection connect = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(user);
			System.out.println(password);
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/tim?serverTimezone=UTC&&useSSL=false","root","1234");
			stmt = connect.createStatement();
			String sql = "insert into start values(?,?)";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, password);
			ps.executeUpdate();
		}
		catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}
		finally {
			if(stmt!= null) 
				stmt.close(); 		
			if(connect!= null) 
				connect.close(); 
	    }		
	}
	
	public static boolean logup(String userName) throws SQLException {
		Connection connect = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/tim?serverTimezone=UTC&&useSSL=false","root","1234");
			stmt = connect.createStatement();
			String sql = "select * from start";
			PreparedStatement ps=connect.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String u = rs.getString("user1");
				if (u.equals(userName))
					return false;
			}	
			return true;
		}
		catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}
		finally {
			if(stmt!= null) 
				stmt.close(); 		
			if(connect!= null) 
				connect.close(); 
	    }
		return false;	
	}
	
	public static boolean login(String user,String password) throws SQLException {
		Connection connect = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/tim?serverTimezone=UTC&&useSSL=false","root","1234");
			String sql = "select * from start where user1 = ?";
			PreparedStatement ps=connect.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if (rs.getRow()==0)
					return false;
				else {
					if (password.equals(rs.getString("password1")))
						return true;
					else {
						
						return false;
					}		
				}
			}			
		}
		catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}
		finally { 		
			if(connect!= null) 
				connect.close(); 
	    }
		return false;	
	}
}
