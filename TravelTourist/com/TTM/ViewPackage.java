package com.TTM;

	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;

	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.*;

	public class ViewPackage extends JFrame implements ActionListener{
	  
		JButton back;
		
		ViewPackage(String username)
	 {
		 setBounds(450,200,900,450);
		 getContentPane().setBackground(Color.WHITE);
		 setLayout(null);
		 
		 JLabel text = new JLabel("VIEW PACKAGE DETAILS");
		 text.setFont(new Font("Tahoma", Font.BOLD, 20));
		 text.setBounds(60, 0, 300, 30);
		 add(text);
		 
		 JLabel lblusername = new JLabel("Username");
		 lblusername.setBounds(30, 50, 150, 25);
		 add(lblusername);
		 
		 JLabel lbusername = new JLabel();
		 lbusername.setBounds(220, 50, 150, 25);
		 add(lbusername);
		 
		 JLabel lblpackage = new JLabel("Package Name");
		 lblpackage.setBounds(30, 90, 150, 25);
		 add(lblpackage);
		 
		 JLabel lbpackage = new JLabel();
		 lbpackage.setBounds(220, 90, 150, 25);
		 add(lbpackage);
		 
		 JLabel lblNumber = new JLabel("Total Persons");
		 lblNumber.setBounds(30, 130, 150, 25);
		 add(lblNumber);
		 
		 JLabel lbpersons = new JLabel();
		 lbpersons.setBounds(220, 130, 150, 25);
		 add(lbpersons);
		 
		 JLabel lblid = new JLabel("ID");
		 lblid.setBounds(30, 170, 150, 25);
		 add(lblid);
		 
		 JLabel lbid = new JLabel();
		 lbid.setBounds(220, 170, 150, 25);
		 add(lbid);
		 
		 JLabel lblnumber = new JLabel("Number");
		 lblnumber.setBounds(30, 210, 150, 25);
		 add(lblnumber);
		 
		 JLabel lbnumber = new JLabel();
		 lbnumber.setBounds(220, 210, 150, 25);
		 add(lbnumber);
		 
	 
		 JLabel lblPhone = new JLabel("Phone");
		 lblPhone.setBounds(30, 250, 150, 25);
		 add(lblPhone);
		 
		 JLabel lbPhone = new JLabel();
		 lbPhone.setBounds(220, 250, 150, 25);
		 add(lbPhone);
		 
		 JLabel lblPrice = new JLabel("Price");
		 lblPrice.setBounds(30, 290, 150, 25);
		 add(lblPrice);
		 
		 JLabel lbPrice = new JLabel();
		 lbPrice.setBounds(220, 290, 150, 25);
		 add(lbPrice);
		 
		 back = new JButton("Back");
		 back.setBackground(Color.BLACK);
		 back.setForeground(Color.WHITE );
		 back.setBounds(220, 350, 100, 25);
		 back.addActionListener(this);
		 add(back);
		 
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-20/icons/bookedDetails.jpg"));
		 Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel image = new JLabel(i3);
		 image.setBounds(350, 20, 500, 350);
		 add(image);
		 
		 try {
			 Connect conn = new Connect();
			 String query = "Select * from BOOKPACKAGE where username = '"+username+"'";
			 ResultSet rs = conn.s.executeQuery(query);
			 while(rs.next())
			 {
				 lbusername.setText(rs.getString("Username"));
				 lbpackage.setText(rs.getString("Package"));
				 lbid.setText(rs.getString("ID"));
				 lbnumber.setText(rs.getString("Number"));
				 lbPhone.setText(rs.getString("Phone"));
				 lbPrice.setText(rs.getString("Price"));
				 lbpersons.setText(rs.getString("Persons"));
				 
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
		new ViewPackage("Amit123");
	}

	}

