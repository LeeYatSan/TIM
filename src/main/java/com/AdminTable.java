package com;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminTable {
	static int[] array = new int[100];
	public static int getrow(String user) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connect = null;
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/tim?serverTimezone=UTC","root","1234");
		ResultSet rs1;
		String sql1 = "select * from Purchase";
		PreparedStatement ps = connect.prepareStatement(sql1);
		rs1 = ps.executeQuery();	
		rs1.last();	
		return rs1.getRow();
	}
	
	public static void table(String user) throws SQLException{
    	final JFrame jf = new JFrame("购票记录");
        jf.setLocationRelativeTo(null);
        JPanel panel = new JPanel(new BorderLayout());
        final Object[] columnNames = {"ID", "Route_ID", "Date", "Pay","Money"};
        if (getrow(user)==0) {
        	try {
				Admin.showNewWindow(jf, 7);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return;
        }        	
        String[][] rowData = new String[getrow(user)][5];
        Connection connect = null;
		Statement stmt = null;
		try {	
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/tim?serverTimezone=UTC&&useSSL=false","root","1234");
			stmt = connect.createStatement();
			stmt = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1 = stmt.executeQuery("select * from Purchase");
			int i = 0;
			while (rs1.next()) {				
					rowData[i][0] = String.valueOf(i+1);
					rowData[i][1] = rs1.getString("route_id");
					rowData[i][2] = rs1.getString("date");
					rowData[i][3] = rs1.getString("pay");
					rowData[i][4] = rs1.getString("back_money");
					array[i]=rs1.getInt("purchase_id");
					i++;
				
			}	
		}
		catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}
		finally {
			if(stmt!= null) 
				stmt.close(); 		
			if(connect!= null) 
				connect.close(); 
		}
        final DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);
        final JTable table = new JTable(tableModel);
        table.updateUI(); 
        final JButton button1 = new JButton("保存");
        final JButton button2 = new JButton("删除");
        button1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int i=table.getSelectedRow();
        		if (i<0) 
            		return;
            	try {
            		String s = (String) tableModel.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
            		TIMUpdate.update(table.getSelectedColumn(), s, array[i]);
        			Admin.showNewWindow(jf, 5);
        		} catch (SQLException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	table.updateUI();
        	}
        });
        button2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int i=table.getSelectedRow();
        		if (i<0) 
            		return;
            	try {
            		tableModel.removeRow(i);
        			TIMDelete.delete(array[i]);
        			Admin.showNewWindow(jf, 6);
        		} catch (SQLException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	table.updateUI();
        	}
        });   
        button1.setBounds(50, 30, 50, 30);
        button1.setBounds(50, 30, 50, 30);
        JPanel p = new JPanel();
        p.add(button1);
        p.add(button2);
        panel.add(p,BorderLayout.SOUTH);
        table.getModel();     
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);
        jf.setContentPane(panel);
        jf.pack();
        jf.setVisible(true);
    }
}
