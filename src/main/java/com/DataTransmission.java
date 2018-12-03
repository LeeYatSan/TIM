package com;

public class DataTransmission {
	
	private TicketCollection Result;
	
	//JDBC连接数据库
	DataTransmission() {
		
	}
	//连接ip:port为ip_port的数据库
	DataTransmission(String ip_port,String user,String password){
		
	}
	//断开连接
	public void close() {
		
	}
	public TicketCollection getTickets(String SCity,String TCity,String date) {
		return Result;
	}
	//始发/终点站包含 City的车票
	public TicketCollection getTicket(String City) {
		return Result;
	}
	public TicketInfo getTicket(String ID,String date) {
		return new TicketInfo();
	}
	//余票-1
	public void updateTicketNum(String ID) {
		
	}
	public void purchaseRecord(String ID,String date,String pay,String change) {
		
	}
}
