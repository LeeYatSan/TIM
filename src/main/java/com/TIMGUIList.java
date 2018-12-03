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

    private BackEnd Control;
    private TicketCollection list;
    private String SCity, TCity, Date;
    private JPanel show_list = new JPanel();
    private DefaultListModel info = new DefaultListModel();
    private final JList item_list = new JList(info);
    private static final int col_width = 200;
    private static final int row_height = 60;
    private static final int selection_flag_width = 100;
    private static final int title_font_size = 20;

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
        id.setPreferredSize(new Dimension(col_width, row_height));
        id.setBackground(Color.WHITE);
        id.setForeground(Color.GRAY);
        id.setHorizontalAlignment(JTextField.CENTER);
        id.setFont(new Font("TimesRoman",Font.BOLD,title_font_size));
        scity.setPreferredSize(new Dimension(col_width, row_height));
        scity.setBackground(Color.WHITE);
        scity.setForeground(Color.GRAY);
        scity.setHorizontalAlignment(JTextField.CENTER);
        scity.setFont(new Font("TimesRoman",Font.BOLD,title_font_size));
        tcity.setPreferredSize(new Dimension(col_width, row_height));
        tcity.setBackground(Color.WHITE);
        tcity.setForeground(Color.GRAY);
        tcity.setHorizontalAlignment(JTextField.CENTER);
        tcity.setFont(new Font("TimesRoman",Font.BOLD,title_font_size));
        date.setPreferredSize(new Dimension(col_width, row_height));
        date.setBackground(Color.WHITE);
        date.setForeground(Color.GRAY);
        date.setHorizontalAlignment(JTextField.CENTER);
        date.setFont(new Font("TimesRoman",Font.BOLD,title_font_size));
        num.setPreferredSize(new Dimension(col_width, row_height));
        num.setBackground(Color.WHITE);
        num.setForeground(Color.GRAY);
        num.setHorizontalAlignment(JTextField.CENTER);
        num.setFont(new Font("TimesRoman",Font.BOLD,title_font_size));
        price.setPreferredSize(new Dimension(col_width, row_height));
        price.setBackground(Color.WHITE);
        price.setForeground(Color.GRAY);
        price.setHorizontalAlignment(JTextField.CENTER);
        price.setFont(new Font("TimesRoman",Font.BOLD,title_font_size));
        buy.setPreferredSize(new Dimension(selection_flag_width, row_height));
        buy.setBackground(Color.WHITE);
        buy.setForeground(Color.GRAY);
        buy.setHorizontalAlignment(JTextField.CENTER);
        buy.setFont(new Font("TimesRoman",Font.BOLD,title_font_size));
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
//        if(list.isEmpty())
        if(list == null)
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
    public JList getList(){return item_list;}//返回搜索列表
}
