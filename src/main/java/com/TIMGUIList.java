/**
 *@author
 *LI_Yichen
 *ID: 16130120145
 *e-mail: niuqiao2010@163.com
 */

package com;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class TIMGUIList extends JPanel {

    BackEnd Control;
    TicketCollection list;
    String SCity, TCity, Date;
    JPanel show_list = new JPanel();
    DefaultListModel info = new DefaultListModel();
    final JList item_list = new JList(info);

    TIMGUIList(BackEnd Control, String SCity, String TCity, String Date){
        //默认构造函数

        this.Control = Control;
        this.SCity = SCity;
        this.TCity = TCity;
        this.Date = Date;
        JTextField id = new JTextField();
        JTextField scity = new JTextField();
        JTextField tcity = new JTextField();
        JTextField num = new JTextField();
        JTextField date = new JTextField();
        JTextField price = new JTextField();
        JTextField buy = new JTextField();
        id.setText("ID");
        scity.setText("Departure");
        tcity.setText("Arrival");
        date.setText("Departure Date");
        num.setText("Remaining Tickets");
        price.setText("Price");
        buy.setText("Selection");
        //布局
        FlowLayout f=(FlowLayout)getLayout();
        f.setHgap(5);//水平间距
        //装饰
        id.setEnabled(false);
        scity.setEnabled(false);
        tcity.setEnabled(false);
        num.setEnabled(false);
        date.setEnabled(false);
        price.setEnabled(false);
        buy.setEnabled(false);
        id.setLayout(f);
        scity.setLayout(f);
        tcity.setLayout(f);
        date.setLayout(f);
        num.setLayout(f);
        price.setLayout(f);
        id.setPreferredSize(new Dimension(200, 60));
        id.setBackground(Color.WHITE);
        id.setForeground(Color.GRAY);
        id.setHorizontalAlignment(JTextField.CENTER);
        id.setFont(new Font("TimesRoman",Font.BOLD,20));
        scity.setPreferredSize(new Dimension(200, 60));
        scity.setBackground(Color.WHITE);
        scity.setForeground(Color.GRAY);
        scity.setHorizontalAlignment(JTextField.CENTER);
        scity.setFont(new Font("TimesRoman",Font.BOLD,20));
        tcity.setPreferredSize(new Dimension(200, 60));
        tcity.setBackground(Color.WHITE);
        tcity.setForeground(Color.GRAY);
        tcity.setHorizontalAlignment(JTextField.CENTER);
        tcity.setFont(new Font("TimesRoman",Font.BOLD,20));
        date.setPreferredSize(new Dimension(200, 60));
        date.setBackground(Color.WHITE);
        date.setForeground(Color.GRAY);
        date.setHorizontalAlignment(JTextField.CENTER);
        date.setFont(new Font("TimesRoman",Font.BOLD,20));
        num.setPreferredSize(new Dimension(200, 60));
        num.setBackground(Color.WHITE);
        num.setForeground(Color.GRAY);
        num.setHorizontalAlignment(JTextField.CENTER);
        num.setFont(new Font("TimesRoman",Font.BOLD,20));
        price.setPreferredSize(new Dimension(200, 60));
        price.setBackground(Color.WHITE);
        price.setForeground(Color.GRAY);
        price.setHorizontalAlignment(JTextField.CENTER);
        price.setFont(new Font("TimesRoman",Font.BOLD,20));
        buy.setPreferredSize(new Dimension(100, 60));
        buy.setBackground(Color.WHITE);
        buy.setForeground(Color.GRAY);
        buy.setHorizontalAlignment(JTextField.CENTER);
        buy.setFont(new Font("TimesRoman",Font.BOLD,20));
        //组装
        add(id);
        add(scity);
        add(tcity);
        add(date);
        add(num);
        add(price);
        add(buy);
        show_list.setLayout(new GridLayout(1, 1));
        info.removeAllElements();
        showList();
        item_list.setPreferredSize(new Dimension(1500, 70));
        add(item_list);
    }
    public void showList(/*, String type*/){
        //展示列表
        show_list.setLayout(new GridLayout(1, 1));
        list = Control.getTicketCollection(SCity, TCity, Date);
        info.removeAllElements();
        if(list.isEmpty())
        {
            info.addElement("[EMPTY]");
        }
        else
        {
            Iterator each_item = list.iterator();
            while(each_item.hasNext())
            {
                TicketInfo curr = (TicketInfo)each_item.next();
                info.addElement(curr);
            }
            ListCellRenderer renderer = new TIMGUIListItem(Control);
            item_list.setCellRenderer(renderer);
            add(item_list);
        }
        item_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        item_list.updateUI();
    }
    public TicketCollection getSearchResult(){return list;}//返回搜索结果集
}
