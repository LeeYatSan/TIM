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

public class TIMUpdate {
	public static void update(int num,String value,int id) throws SQLException {
		Connection connect = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String[] type = {"","route_id","date","pay","money"};
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/tim?serverTimezone=UTC&&useSSL=false","root","1234");
			stmt = connect.createStatement();
			String sql1 = null;
			if (num == 1)
				sql1 = "update Purchase set route_id = ? where id = ?";
			else if (num == 2)
				sql1 = "update Purchase set date = ? where id = ?";
			else if (num == 3)
				sql1 = "update Purchase set pay = ? where id = ?";
			else if (num == 4)
				sql1 = "update Purchase set money = ? where id = ?";
			PreparedStatement ps1=connect.prepareStatement(sql1);
			ps1.setString(1, value);
			ps1.setInt(2, id);
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
