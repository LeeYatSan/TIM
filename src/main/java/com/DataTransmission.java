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
	private TicketCollection Result;
	private static String ip_port = "jdbc:mysql://localhost:3306/TIM";
	private static String user = "root";
	private static String password = "gexiaodong123";
	//JDBC连接数据库
	DataTransmission() {		
	}
	//连接ip:port为ip_port的数据库
	DataTransmission(String ip_port,String user,String password) throws SQLException{		
    	try {
			connect = DriverManager.getConnection(ip_port,user,password);
			stmt = connect.createStatement();
    	}
    	catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}    	
	}
	
	//断开连接
	public static void close() throws SQLException {
		if(stmt!= null) 
			stmt.close(); 		
		if(connect!= null) 
			connect.close(); 
	}
	
	public TicketCollection getTickets(String SCity,String TCity,String date) throws SQLException {
		new DataTransmission(ip_port,user,password);
		String sql = "select * from TicketInfo where scity = ? AND tcity = ? AND date = ?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1, SCity);
		ps.setString(2, TCity);
		ps.setString(3, date);
		rs = ps.executeQuery();
		while(rs.next()) {
			TicketInfo TI = new TicketInfo();
			if (rs.getString("scity").equals(TI.getSCity()) 
					&& rs.getString("tcity").equals(TI.getTCity()) && rs.getString("date").equals(TI.getDate()))
				Result.add(TI);
		}
		close();
		return Result;
	}
	
	//始发/终点站包含 City的车票
	public TicketCollection getTicket(String City) throws SQLException {
		new DataTransmission(ip_port,user,password);
		String sql = "select * from TicketInfo where scity = ? OR tcity = ?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1, City);
		ps.setString(2, City);
		rs = ps.executeQuery();
		while(rs.next()) {
			TicketInfo TI = new TicketInfo();
			if (rs.getString("scity").equals(TI.getSCity()) || rs.getString("tcity").equals(TI.getTCity()))
				Result.add(TI);
		}
		close();
		return Result;
	}
	
	public TicketInfo getTicket(String ID,String date) throws SQLException {
		new DataTransmission(ip_port,user,password);
		String sql = "select * from TicketInfo where id = ? AND date = ?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1, ID);
		ps.setString(2, date);
		rs = ps.executeQuery();
		while(rs.next()) {
			TicketInfo TI = new TicketInfo();
			if (rs.getString("id").equals(TI.getID()) || rs.getString("date").equals(TI.getDate()))
				Result.add(TI);
		}
		close();
		return new TicketInfo();
	}
	//余票-1
	public static void updateTicketNum(String ID) throws SQLException {
		new DataTransmission(ip_port,user,password);
		String sql = "update TicketInfo set num = num-1 where id = ?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1, ID);
		ps.executeUpdate();
		close();
	}
	
	public static void purchaseRecord(String ID,String date,String pay,String money) throws SQLException {
		new DataTransmission(ip_port,user,password);
		String sql = "insert into Purchase values (?,?,?,?)";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1, ID);
		ps.setString(2, date);
		ps.setString(3, pay);
		ps.setString(4, money);
		ps.executeUpdate();
		close();
	}
	
	public static void main(String[] args) throws SQLException {
		purchaseRecord("3","2018-12-3","500","35");
		updateTicketNum("1");
	}
}
