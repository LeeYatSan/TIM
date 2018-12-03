/**
 *@author
 *Hongbo Wang
 *ID: 16130120125
 *e_mail: hbwang_2016@stu.xidian.edu.cn
 */


package com;

public class BackEnd {

    private DataTransmission dataTrans;
    BackEnd(){
        dataTrans = new DataTransmission();
    }
    public TicketCollection getTicketCollection(String SCity, String TCity, String date){
    	return dataTrans.getTickets(SCity, TCity, date);
    }
    public int checkPayment(String price, String pay){
        return Integer.parseInt(pay)-Integer.parseInt(price);
    }
    public int checkCity(String City){
    	TicketCollection List = dataTrans.getTicket(City);
        if (List.isEmpty()) {
        	return -1;
        }
        else
        	return List.size();
    }
    public void purchase(String ID, String date,String pay,String change){
    	dataTrans.updateTicketNum(ID);
    	dataTrans.purchaseRecord(ID, date, pay, change);
    }
    public boolean checkNum(String ID, String date){
    	TicketInfo ticket = dataTrans.getTicket(ID, date);
    	if (Integer.valueOf(ticket.getNum())>0)
    		return true;
    	else
    		return false;
    }
}
