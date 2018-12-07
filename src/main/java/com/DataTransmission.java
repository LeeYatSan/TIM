/**
 *@author
 *GeXiaodong
 *ID: 16130120194
 */

package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataTransmission{
	static Connection connect = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static TicketInfo TI = null;
	static TicketCollection Result = new TicketCollection();
	//JDBC连接数据库
	DataTransmission() {}
	//连接ip:port为ip_port的数据库
	DataTransmission(String ip_port,String user,String password) throws SQLException{
		try {
			// 注册 JDBC 驱动
			Class.forName("com.mysql.cj.jdbc.Driver");

			connect = DriverManager.getConnection(ip_port,user,password);
			stmt = connect.createStatement();
		}
		catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}
	}

	//断开连接
	public  void close() throws SQLException {
		if(stmt!= null)
			stmt.close();
		if(connect!= null)
			connect.close();
	}

	public  TicketCollection getTickets(String SCity,String TCity,String date) throws SQLException {
		Result.clear();
		String sql;
		if (SCity.equals("") || TCity.equals("") || date.equals("")) {
			sql = "select * from TicketInfo  ";
			PreparedStatement ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
		}

		else {
			sql = "select * from TicketInfo  where scity = ? AND tcity = ? AND date = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, SCity);
			ps.setString(2, TCity);
			ps.setString(3, date);
			rs = ps.executeQuery();
		}

		while(rs.next()) {
			TI = new TicketInfo(rs.getString("id"),rs.getString("scity"),
					rs.getString("tcity"),rs.getString("date"),rs.getInt("num"),rs.getInt("price"));
			Result.add(TI);
		}
		return Result;
	}

	//始发/终点站包含 City的车票
	public  TicketCollection getTicket(String City) throws SQLException {
		String sql = "select * from TicketInfo where scity = ? OR tcity = ?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1, City);
		ps.setString(2, City);
		rs = ps.executeQuery();
		while(rs.next()) {
			TI = new TicketInfo(rs.getString("id"),rs.getString("scity"),
					rs.getString("tcity"),rs.getString("date"),rs.getInt("num"),rs.getInt("price"));
			Result.add(TI);
		}
		return Result;
	}

	public  TicketInfo getTicket(String ID,String date) throws SQLException {
		String sql = "select * from TicketInfo where id = ? AND date = ?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1, ID);
		ps.setString(2, date);
		rs = ps.executeQuery();
		while(rs.next()) {
			TI = new TicketInfo(rs.getString("id"),rs.getString("scity"),
					rs.getString("tcity"),rs.getString("date"),rs.getInt("num"),rs.getInt("price"));
//			Result.add(TI);
		}
//		return new TicketInfo();
		return TI;
	}
	//余票-1
	public  void updateTicketNum(String ID) throws SQLException {
		String sql = "update TicketInfo set num = num-1 where id = ?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1, ID);
		ps.executeUpdate();
	}

	public  void purchaseRecord(String ID,String date,String pay,String money) throws SQLException {
		String sql = "insert into Purchase values (null,?,?,?,?)";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1, ID);
		ps.setString(2, date);
		ps.setString(3, pay);
		ps.setString(4, money);
		ps.executeUpdate();
	}

}
