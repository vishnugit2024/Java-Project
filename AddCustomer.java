package com.TTM;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener{
	 
	JLabel lbusername , lbname;
	JComboBox comboid;
	JTextField tfnum, tfcountry, tfadd , tfemail , tfphone , tfusername , tfname;
	JRadioButton bmale , bfemale ;
	JButton add , Back ; 
	
	
	AddCustomer(String username)
	{
	setBounds(450,200,850,550);
	setLayout(null);
	getContentPane().setBackground(Color.WHITE);
	
	
	JLabel lblusername = new JLabel("Username");
	lblusername.setBounds(30, 50, 150, 25);
	add(lblusername);
	
	
	tfusername = new JTextField();
	tfusername.setBounds(220, 50, 150, 25);
	add(tfusername);
		
	JLabel lblid = new JLabel("ID");
	lblid.setBounds(30, 90, 150, 25);
	add(lblid);	
	
	
	comboid = new JComboBox(new String[] {"Passport" , "Aadhar Card" , "Pan Card" , "Driving Licence"});
	comboid.setBounds(220, 90, 150, 25);
	comboid.setBackground(Color.WHITE);
	add(comboid);
	
	
	JLabel lblnum = new JLabel("Number");
	lblnum.setBounds(30, 130, 150, 25);
	add(lblnum);
	
	tfnum = new JTextField();
	tfnum.setBounds(220, 130, 150, 25);
	add(tfnum);
	
	
	JLabel lblname = new JLabel("Name");
	lblname.setBounds(30, 170, 150, 25);
	add(lblname);
	
	
	tfname = new JTextField();
	tfname.setBounds(220, 170, 150, 25);
	add(tfname);
	
	 JLabel lblGen = new JLabel("Gender");
	lblGen.setBounds(30,210,150,25);
	add(lblGen);

	
	bmale = new JRadioButton("Male");
	bmale.setBounds(220, 210, 70, 25);
	bmale.setBackground(Color.WHITE);
	add(bmale);
	
	bfemale = new JRadioButton("Female");
	bfemale.setBounds(300, 210, 70, 25);
	bmale.setBackground(Color.WHITE);
	add(bfemale);
	
	ButtonGroup bg = new ButtonGroup();
	bg.add(bmale);
	bg.add(bfemale);
	
	
	JLabel lblCountry = new JLabel("Country");
	lblCountry.setBounds(30, 250, 150, 25);
	add(lblCountry);
	
	tfcountry = new JTextField();
	tfcountry.setBounds(220, 250, 150, 25);
	add(tfcountry);
	
	
	JLabel lblAddress = new JLabel("Address");
	lblAddress.setBounds(30, 290, 150, 25);
	add(lblAddress);
	
	tfadd = new JTextField();
	tfadd.setBounds(220, 290, 150, 25);
	add(tfadd);
	
	
	JLabel lblphone = new JLabel("Phone");
	lblphone.setBounds(30, 330, 150, 25);
	add(lblphone);
	
	tfphone = new JTextField();
	tfphone.setBounds(220, 330, 150, 25);
	add(tfphone);
	
	
	JLabel lblemail = new JLabel("Email");
	lblemail.setBounds(30, 370, 150, 25);
	add(lblemail);
	
	tfemail = new JTextField();
	tfemail.setBounds(220, 370, 150, 25);
	add(tfemail);
	
	
	add = new JButton("Add");
	add.setBackground(Color.BLACK);
	add.setForeground(Color.WHITE);
	add.setBounds(70,430,100,25);
	add.addActionListener(this);
	add(add);
	
	Back = new JButton("Back");
	Back.setBackground(Color.BLACK);
	Back.setForeground(Color.WHITE);
	Back.setBounds(220,430,100,25);
	Back.addActionListener(this);
	add(Back);
	
    
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-20/icons/newcustomer.jpg"));
	Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);
	JLabel image = new JLabel(i3);
	image.setBounds(400, 40, 450, 420);
	add(image);
	

	setVisible(true);
	}
	
	
	public static void main(String[] args) {
		 new AddCustomer(" ");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add)
		{
			String username = tfusername.getText();
			String id = (String) comboid.getSelectedItem();
			String  number = tfnum.getText();
			String name = tfname.getText();
			String gender = null;
			
			if(bmale.isSelected())
			{
				gender = "Male";
			}else {
				gender = "Female";
			}
			
			String country = tfcountry.getText();
			String address = tfadd.getText();
			String Email = tfemail.getText();
			String Phone = tfphone.getText();
			
			try {
				Connect c = new Connect();
				String query = "insert into customers values('"+username+"' , '"+id+"' , '"+number+"' , '"+name+"' , '"+gender+"' , '"+country+"' , '"+address+"' , '"+Phone+"' , '"+Email+"')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null,"Customer Details Added Succesfully");
				setVisible(false);
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
			
		} else {
			setVisible(false);
		}
		
	}

}
