package com.TTM;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CheckPerdetails extends JFrame implements ActionListener{
  
	JButton back;
	
	CheckPerdetails(String username)
 {
	 setBounds(450,180,870,625);
	 getContentPane().setBackground(Color.WHITE);
	 setLayout(null);
	 
	 
	 JLabel lblusername = new JLabel("Username");
	 lblusername.setBounds(30, 50, 150, 25);
	 add(lblusername);
	 
	 JLabel lbusername = new JLabel();
	 lbusername.setBounds(220, 50, 150, 25);
	 add(lbusername);
	 
	 JLabel lblid = new JLabel("id");
	 lblid.setBounds(30, 110, 150, 25);
	 add(lblid);
	 
	 JLabel lbid = new JLabel();
	 lbid.setBounds(220, 110, 150, 25);
	 add(lbid);
	 
	 JLabel lblNumber = new JLabel("Number");
	 lblNumber.setBounds(30, 170, 150, 25);
	 add(lblNumber);
	 
	 JLabel lbNumber = new JLabel();
	 lbNumber.setBounds(220, 170, 150, 25);
	 add(lbNumber);
	 
	 JLabel lblName = new JLabel("Name");
	 lblName.setBounds(30, 230, 150, 25);
	 add(lblName);
	 
	 JLabel lbName = new JLabel();
	 lbName.setBounds(220, 230, 150, 25);
	 add(lbName);
	 
	 JLabel lblGender = new JLabel("Gender");
	 lblGender.setBounds(30, 290, 150, 25);
	 add(lblGender);
	 
	 JLabel lbGender = new JLabel();
	 lbGender.setBounds(220, 290, 150, 25);
	 add(lbGender);
	 
	 JLabel lblCountry = new JLabel("Country");
	 lblCountry.setBounds(500, 50, 150, 25);
	 add(lblCountry);
	 
	 JLabel lbCountry = new JLabel();
	 lbCountry.setBounds(690, 50, 150, 25);
	 add(lbCountry);
	 
	 JLabel lblAddress = new JLabel("Address");
	 lblAddress.setBounds(500, 110, 150, 25);
	 add(lblAddress);
	 
	 JLabel lbAddress = new JLabel();
	 lbAddress.setBounds(690, 100, 150, 25);
	 add(lbAddress);
	 
	 JLabel lblPhone = new JLabel("Phone");
	 lblPhone.setBounds(500, 170, 150, 25);
	 add(lblPhone);
	 
	 JLabel lbPhone = new JLabel();
	 lbPhone.setBounds(690, 170, 150, 25);
	 add(lbPhone);
	 
	 JLabel lblEmail = new JLabel("Email");
	 lblEmail.setBounds(500, 230, 150, 25);
	 add(lblEmail);
	 
	 JLabel lbEmail = new JLabel();
	 lbEmail.setBounds(690, 230, 150, 25);
	 add(lbEmail);
	 
	 back = new JButton("Back");
	 back.setBackground(Color.BLACK);
	 back.setForeground(Color.WHITE );
	 back.setBounds(350, 350, 100, 25);
	 back.addActionListener(this);
	 add(back);
	 
	 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-20/icons/viewall.jpg"));
	 Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
	 ImageIcon i3 = new ImageIcon(i2);
	 JLabel image = new JLabel(i3);
	 image.setBounds(100, 400, 600, 200);
	 add(image);
	 
	 try {
		 Connect conn = new Connect();
		 String query = "Select * from Customers where username = '"+username+"'";
		 ResultSet rs = conn.s.executeQuery(query);
		 while(rs.next())
		 {
			 lbusername.setText(rs.getString("username"));
			 lbid.setText(rs.getString("id"));
			 lbNumber.setText(rs.getString("number"));
			 lbName.setText(rs.getString("name"));
			 lbGender.setText(rs.getString("gender"));
			 lbCountry.setText(rs.getString("country"));
			 lbAddress.setText(rs.getString("address"));
			 lbPhone.setText(rs.getString("phone"));
			 lbEmail.setText(rs.getString("email"));
			 
		 }
	 } catch(Exception e)
	 {
		 
	 }
	 
	 
	 setVisible(true);
 }
	public void actionPerformed(ActionEvent e) {
		 setVisible(false);
		
	}
   
   public static void main(String[] args) {
	new CheckPerdetails("Amit123");
}

}
