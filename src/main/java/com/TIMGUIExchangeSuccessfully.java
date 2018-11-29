/**
 *@author
 *LI_Yichen
 *ID: 16130120145
 *e-mail: niuqiao2010@163.com
 */

package com;

import javax.swing.*;
import java.awt.*;

public class TIMGUIExchangeSuccessfully extends JPanel {

    TicketInfo currTicket;
    JLabel msg = new JLabel("Purchase successfully! Please take your change!");
    JLabel info = new JLabel("Your ticket information:");
    private JTextField ID;
    private JTextField SCity;
    private JTextField TCity;
    private JTextField date;
    private JTextField price;
    private JTextField payment;
    private JTextField change;

    TIMGUIExchangeSuccessfully(TicketInfo selected_ticket, String payment, int change){
        //默认构造函数

        //初始化
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        ID = new JTextField();
        SCity = new JTextField();
        TCity = new JTextField();
        date = new JTextField();
        price = new JTextField();
        this.payment = new JTextField();
        this.change = new JTextField();
        currTicket = selected_ticket;
        ID.setText(currTicket.getID());
        SCity.setText(currTicket.getSCity());
        TCity.setText(currTicket.getTCity());
        date.setText(currTicket.getDate());
        price.setText(currTicket.getPrice());
        this.payment.setText(payment);
        this.change.setText(Integer.toString(change));
        ID.setEnabled(false);
        SCity.setEnabled(false);
        TCity.setEnabled(false);
        date.setEnabled(false);
        price.setEnabled(false);
        this.payment.setEnabled(false);
        this.change.setEnabled(false);
        //装饰
        ID.setHorizontalAlignment(JTextField.CENTER);
        SCity.setHorizontalAlignment(JTextField.CENTER);
        TCity.setHorizontalAlignment(JTextField.CENTER);
        date.setHorizontalAlignment(JTextField.CENTER);
        price.setHorizontalAlignment(JTextField.CENTER);
        this.payment.setHorizontalAlignment(JTextField.CENTER);
        this.change.setHorizontalAlignment(JTextField.CENTER);
        this.change.setPreferredSize(new Dimension(100, 50));
        this.change.setForeground(Color.RED);
        this.change.setFont(new Font("TimesRoman",Font.BOLD,20));
        //组装
        add(msg);
        add(Box.createVerticalStrut(15));
        add(info);
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
        add(this.payment);
        add(Box.createVerticalStrut(15)); // a spacer
        add(new JLabel("Change"));
        add(this.change);
    }
}
