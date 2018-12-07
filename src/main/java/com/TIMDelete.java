/**
 *@author
 *GeXiaodong
 *ID: 16130120194
 */

package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TIMDelete {
	public static void delete(int id) throws SQLException {
		Connection connect = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/tim?serverTimezone=UTC&&useSSL=false","root","1234");
			stmt = connect.createStatement();
			String sql1 = "delete from Purchase where id = ? ";
			PreparedStatement ps1=connect.prepareStatement(sql1);
			ps1.setInt(1, id);
			ps1.execute();
		}
		catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}
		finally {
			if(connect!=null)
				connect.close();
			if(stmt!=null)
				stmt.close();
		}	
	}
}
