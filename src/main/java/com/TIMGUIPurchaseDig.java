/**
 *@author
 *LI_Yichen
 *ID: 16130120145
 *e-mail: niuqiao2010@163.com
 */

package com;

import org.w3c.dom.events.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TIMGUIPurchaseDig extends JPanel{

    TicketInfo currTicket;
    JLabel msg = new JLabel("Please check your ticket info:");
    private JTextField ID;
    private JTextField SCity;
    private JTextField TCity;
    private JTextField date;
    private JTextField price;
    private JTextField payment;

    TIMGUIPurchaseDig(TicketInfo selected_ticket){
        //默认构造函数

        //初始化
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        ID = new JTextField();
        SCity = new JTextField();
        TCity = new JTextField();
        date = new JTextField();
        price = new JTextField();
        payment = new JTextField();
        currTicket = selected_ticket;
        ID.setText(currTicket.getID());
        SCity.setText(currTicket.getSCity());
        TCity.setText(currTicket.getTCity());
        date.setText(currTicket.getDate());
        price.setText(currTicket.getPrice());
        payment.setText("");
        ID.setEnabled(false);
        SCity.setEnabled(false);
        TCity.setEnabled(false);
        date.setEnabled(false);
        price.setEnabled(false);
        //装饰
        ID.setHorizontalAlignment(JTextField.CENTER);
        SCity.setHorizontalAlignment(JTextField.CENTER);
        TCity.setHorizontalAlignment(JTextField.CENTER);
        date.setHorizontalAlignment(JTextField.CENTER);
        price.setHorizontalAlignment(JTextField.CENTER);
        price.setPreferredSize(new Dimension(100, 50));
        price.setForeground(Color.RED);
        price.setFont(new Font("TimesRoman",Font.BOLD,20));
        payment.setHorizontalAlignment(JTextField.CENTER);
        payment.setPreferredSize(new Dimension(100, 50));
        payment.setForeground(Color.GREEN);
        payment.setFont(new Font("TimesRoman",Font.BOLD,20));
        //侦听
        payment.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int temp = e.getKeyChar();
                if(temp == KeyEvent.VK_BACK_SPACE){}
                else if(temp >= KeyEvent.VK_0 && temp <= KeyEvent.VK_9){}
                else{e.consume();}
            }
            @Override
            public void keyPressed(KeyEvent e) { }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        //组装
        add(msg);
        add(Box.createVerticalStrut(15));
        add(new JLabel("ID:"));
        add(ID);
        add(Box.createVerticalStrut(15)); // a spacer
        add(new JLabel("Departure"));
        add(SCity);
        add(Box.createVerticalStrut(15)); // a spacer
        add(new JLabel("Arrival"));
        add(TCity);
        add(Box.createVerticalStrut(15)); // a spacer
        add(new JLabel("Departure Date"));
        add(date);
        add(Box.createVerticalStrut(15)); // a spacer
        add(new JLabel("Price"));
        add(price);
        add(Box.createVerticalStrut(15)); // a spacer
        add(new JLabel("Payment"));
        add(payment);
    }
    public String getPayment(){return payment.getText();}//获取支付款项
}
