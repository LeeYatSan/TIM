package com;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Admin {
	static JFrame newJFrame = new JFrame();
	static String Myuser = null;
	public static void start() {
		final JFrame jframe = new JFrame("admin");
		jframe.setLocation(800, 400);
        jframe.setSize(300, 300);
    	JPanel panel = new JPanel(new GridLayout(5,3,3,3));
        JLabel user = new JLabel("username");
        JLabel password = new JLabel("password");
        final JTextField user1 = new JTextField(20);
        final JPasswordField password1 = new JPasswordField(20);
        JButton btn1 = new JButton("sign up");
        JButton btn2 = new JButton("sign in"); 
        btn1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	try {
            		String Pwd = new String(password1.getPassword()).trim(); 
					if (TIMDB.logup(user1.getText())) {
						TIMDB.save(user1.getText(),Pwd);
						showNewWindow(jframe,3);
						jframe.setVisible(false);
						Myuser = user1.getText();
						if (AdminTable.getrow(Myuser)<=0) {
							showNewWindow(jframe,7);
							return;
						}	
						AdminTable.table(Myuser);
						newJFrame.setVisible(false);
					}				
					else
						showNewWindow(jframe,4);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        btn2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	try {
            		String Pwd = new String(password1.getPassword()).trim(); 
					if (TIMDB.login(user1.getText(),Pwd)) {
						showNewWindow(jframe,1);
						jframe.setVisible(false);
						Myuser = user1.getText();
						if (AdminTable.getrow(Myuser)<=0) {
							showNewWindow(jframe,7);
							return;
						}	
						AdminTable.table(Myuser);
						newJFrame.setVisible(false);
					}				
					else
						showNewWindow(jframe,2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });  
        panel.add(user);
        panel.add(user1);
        panel.add(password);
        panel.add(password1);
        JPanel p = new JPanel();
        p.add(btn1);
        p.add(btn2);
        panel.add(p,BorderLayout.SOUTH);
        jframe.setContentPane(panel);
        jframe.setVisible(true);  
	}
	
	public static void showNewWindow(JFrame relativeWindow,int type) throws InterruptedException {
        
        newJFrame.setSize(100, 100);
        newJFrame.setLocationRelativeTo(relativeWindow);
        newJFrame.setResizable(false);
        JPanel panel = new JPanel(new GridLayout(1, 1));
        JLabel label = null;
        if (type == 1)
        	label = new JLabel("sign in successfully!");
        else if (type == 2)
        	label = new JLabel("default");
        else if (type == 3)
        	label = new JLabel("sign up successfully");
        else if (type == 4)
        	label = new JLabel("username has been signed up");
        else if (type == 5)
        	label = new JLabel("modify successfully");
        else if (type == 6)
        	label = new JLabel("delete successfully");
        else if (type == 7)
        	label = new JLabel("null");
        label.setFont(new Font(null, Font.PLAIN, 15));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(label);
        newJFrame.setContentPane(panel);
        newJFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		start();
	}
}
