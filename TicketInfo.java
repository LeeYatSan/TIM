/**
 *@author
 *Hongbo Wang
 *ID: 16130120125
 *e-mail: hbwang_2016@stu.xidian.edu.cn
 */

package com;

public class TicketInfo {
    private String ID;
    private String SCity;
    private String TCity;
    private String Date;
    private int num;
    private String Price;

    TicketInfo()
    {
    	
    }
    TicketInfo(String m_ID,String m_SCity,String m_TCity,String m_Date,int m_num,String m_Price){
    	ID=m_ID;
    	SCity = m_SCity;
    	TCity = m_TCity;
    	Date  = m_Date;
    	num = m_num;
    	Price = m_Price;
    }
    public String getID() {
        return ID;
    }
    public String getSCity() {
        return SCity;
    }
    public String getTCity(){
        return TCity;
    }
    public String getDate(){
        return  Date;
    }
    public String getNum(){
        return String.valueOf(num);
    }
    public String getPrice(){
        return Price;
    }
}
