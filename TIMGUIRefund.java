/**
 *@author
 *LI_Yichen
 *ID: 16130120145
 *e-mail: niuqiao2010@163.com
 */

package com;

import javax.swing.*;
import java.awt.*;

abstract public class TIMGUIRefund extends JPanel {

    protected JLabel msg;
    protected JTextField payment;

    TIMGUIRefund(){}
    protected void init()
    {
        //初始化
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        msg = new JLabel();
        this.payment = new JTextField();
        this.payment.setEnabled(false);
        //装饰
        this.payment.setHorizontalAlignment(JTextField.CENTER);
        this.payment.setPreferredSize(new Dimension(100, 200));
        this.payment.setForeground(Color.RED);
        this.payment.setFont(new Font("TimesRoman",Font.BOLD,20));
    }
    protected void addComponment()
    {
        //组装
        add(msg);
        add(Box.createVerticalStrut(15));
        add(new JLabel("Payment"));
        add(this.payment);
    }
}

class TIMGUIInsufficientPayment extends TIMGUIRefund {

    private JTextField price;

    TIMGUIInsufficientPayment(String price, String payment){
        //默认构造函数

        //初始化
        init();
        this.price = new JTextField();
        this.price.setText(price);
        this.payment.setText(payment);
        msg = new JLabel("Insufficient payment! Please take your refund!");
        //装饰
        this.price.setHorizontalAlignment(JTextField.CENTER);
        this.price.setPreferredSize(new Dimension(100, 50));
        this.price.setForeground(Color.RED);
        this.price.setFont(new Font("TimesRoman",Font.BOLD,20));
        //组装
        addComponment();
        add(Box.createVerticalStrut(15));
        add(new JLabel("Price"));
        add(this.price);
    }
}

class TIMGUIExchangeCancel extends TIMGUIRefund {

    TIMGUIExchangeCancel(String payment){
        //默认构造函数

        //初始化
        init();
        this.payment.setText(payment);
        msg = new JLabel("Exchange cancel successfully! Please take your refund!");
        addComponment();
    }
}
