package com.TTM;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class BookPackage extends JFrame implements ActionListener{
  
	Choice cPackage;
	JTextField tfperson; 
	String username;
	JLabel lbusername, lbid, lbnumber, lbPhone, lbprice;
	JButton Checkprice ,Book , Back;
	
	BookPackage(String username){
		this.username = username;
	  setBounds(350,200,1100,500);
	  setLayout(null);
	  getContentPane().setBackground(Color.white);
	  
	  JLabel text = new JLabel("Book Package");
	  text.setBounds(100, 10, 200, 30);
	  text.setFont(new Font("Tahoma",Font.BOLD,20));
	  add(text);
	  
	  JLabel lblusername = new JLabel("Username");
		 lblusername.setBounds(40, 70, 100, 20);
		 lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
		 add(lblusername);
		 
		 lbusername = new JLabel();
		 lbusername.setBounds(250, 70, 100, 25);
		 lbusername.setFont(new Font("Tahoma",Font.PLAIN,16));
		 add(lbusername);
		 
		 JLabel lblpac = new JLabel("Select Package");
		 lblpac.setBounds(40, 110, 150, 20);
		 lblpac.setFont(new Font("Tahoma",Font.PLAIN,16));
		 add(lblpac);
		 
		 cPackage = new Choice();
		 cPackage.add("Gold Package");
		 cPackage.add("Silver Package");
		 cPackage.add("Bronze Package");
		 cPackage.setBounds(250, 110, 180, 25);
		 add(cPackage);
		 
		 JLabel lblper = new JLabel("Total Person");
		 lblper.setBounds(40, 150, 150, 25);
		 lblper.setFont(new Font("Tahoma",Font.PLAIN,16));
		 add(lblper);
		 
	     tfperson = new JTextField();
	     tfperson.setBounds(250, 150, 180, 25);
	     add(tfperson);
	     
	     JLabel lblid = new JLabel("ID");
		 lblid.setBounds(40, 190, 150, 20);
		 lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
		 add(lblid);
		 
		 lbid = new JLabel();
		 lbid.setBounds(250, 190, 200, 25);
		 lbid.setFont(new Font("Tahoma",Font.PLAIN,16));
		 add(lbid);
		 
		 JLabel lblnumber = new JLabel("Number");
		 lblnumber.setBounds(40, 230, 150, 25);
		 lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
		 add(lblnumber);
		 
		  lbnumber = new JLabel();
		 lbnumber.setBounds(250, 230, 150, 25);
		 lbnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
		 add(lbnumber);
		 
		 JLabel lblPhone = new JLabel("Phone");
		 lblPhone.setBounds(40, 270, 150, 20);
		 lblPhone.setFont(new Font("Tahoma",Font.PLAIN,16));
		 add(lblPhone);
		 
		  lbPhone = new JLabel();
		 lbPhone.setBounds(250, 270, 200, 25);
		 lbPhone.setFont(new Font("Tahoma",Font.PLAIN,16));
		 add(lbPhone);
		 
		 JLabel lbltotal = new JLabel("Total Price");
		 lbltotal.setBounds(40, 310, 150, 20);
		 lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
		 add(lbltotal);
		 
		 lbprice = new JLabel();
		 lbprice.setBounds(250, 310, 200, 25);
		 lbprice.setFont(new Font("Tahoma",Font.PLAIN,16));		 
		 add(lbprice);
		 
		 
		 try {
			 Connect conn = new Connect();
			 String query = "Select * from Customers where username = '"+username+"'";
			 ResultSet rs = conn.s.executeQuery(query);
			 while(rs.next())
			 {
				 lbusername.setText(rs.getString("username"));
				 lbid.setText(rs.getString("id"));
				 lbnumber.setText(rs.getString("number"));
				 lbPhone.setText(rs.getString("phone"));
				 
				 
			 }
		 } catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 Checkprice = new JButton("Check");
		 Checkprice.setBounds(60, 380, 120, 25);
		 Checkprice.setBackground(Color.black);
		 Checkprice.setForeground(Color.white);
		 Checkprice.addActionListener(this);
		 add(Checkprice);
		 
		 
		 Book = new JButton("Book");
		 Book.setBounds(200, 380, 120, 25);
		 Book.setBackground(Color.black);
		 Book.setForeground(Color.white);
		 Book.addActionListener(this);
		 add(Book);
		 
		 Back = new JButton("Back");
		 Back.setBounds(340, 380, 120, 25);
		 Back.setBackground(Color.black);
		 Back.setForeground(Color.white);
		 Back.addActionListener(this);
		 add(Back);
		 
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-20/icons/bookpackage.jpg"));
		 Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel image = new JLabel(i3);
		 image.setBounds(500, 50, 550, 350);
		 add(image);
		
		 
	  setVisible(true);
  }
	
	public static void main(String[] args) {
		new BookPackage("Amit123");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    
		if (e.getSource() == Checkprice)
		{
			String pack = cPackage.getSelectedItem();
			int cost = 0;
			if(pack.equals("Gold Package"))
			{
				cost += 1200;
			} else if (pack.equals("Silver Package"))
			{
				cost += 9000;
			} else
			{
				cost += 7000;
			}
			
			int persons = Integer.parseInt(tfperson.getText());
			cost *= persons;
			lbprice.setText( "Rs" +cost);
			
		} else if (e.getSource() == Book)
		{
			try {
				Connect c = new Connect();
				c.s.executeUpdate("insert into BookPackage values('"+lbusername.getText()+"' , '"+cPackage.getSelectedItem()+"' , '"+tfperson.getText()+"' , '"+lbid.getText()+"' , '"+lbnumber.getText()+"' , '"+lbPhone.getText()+"' , '"+lbprice.getText()+"')");
				JOptionPane.showMessageDialog(null,"Package Booked Successfully");
				setVisible(false);
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
			
		} else
		{
			setVisible(false);
		}
		
	}
}
