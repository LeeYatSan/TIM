/**
 *@author
 *LI_Yichen
 *ID: 16130120145
 *e-mail: niuqiao2010@163.com
 */

package com;

public class TicketInfo {
    String ID;
    String SCity;
    String TCity;
    String Date;
    String num;
    String Price;

    TicketInfo()
    {
        ID = "G233";
        SCity = "北京";
        TCity = "上海";
        Date = "2018/11/11";
        num = "133";
        Price = "233";
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
        return num;
    }

    public String getPrice(){
        return Price;
    }
}
