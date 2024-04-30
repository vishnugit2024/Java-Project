package com.TTM;

	import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.ResultSet;

	import javax.swing.*;

	public class UpdatePerdetails extends JFrame implements ActionListener{
		 
		JLabel lbusername , lbname;
		JComboBox comboid;
		JTextField tfnum, tfcountry, tfadd , tfemail , tfphone , tfgender;
		JRadioButton bmale , bfemale ;
		JButton Update , Back ; 
		
		
		UpdatePerdetails(String username)
		{
		setBounds(500,200,850,550);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		
		JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
		text.setBounds(50, 0, 300, 25);
		text.setFont(new Font("Tahoma",Font.PLAIN, 20));
		add(text);
		
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(30, 50, 150, 25);
		add(lblusername);	
		
		lbusername = new JLabel();
		lbusername.setBounds(220, 50, 150, 25);
		add(lbusername);
			
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
		
		
		lbname = new JLabel();
		lbname.setBounds(220, 170, 150, 25);
		add(lbname);
		
		 JLabel lblGen = new JLabel("Gender");
		lblGen.setBounds(30,210,150,25);
		add(lblGen);

		tfgender = new JTextField();
		tfgender.setBounds(220, 210, 150, 25);
		add(tfgender);
		
	
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
		
		
		Update = new JButton("Update");
		Update.setBackground(Color.BLACK);
		Update.setForeground(Color.WHITE);
		Update.setBounds(70,430,100,25);
		Update.addActionListener(this);
		add(Update);
		
		Back = new JButton("Back");
		Back.setBackground(Color.BLACK);
		Back.setForeground(Color.WHITE);
		Back.setBounds(220,430,100,25);
		Back.addActionListener(this);
		add(Back);
		
	    
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-20/icons/update.png"));
		Image i2 = i1.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(450, 100, 350, 250);
		add(image);
		
		try {
			Connect c = new Connect();
			ResultSet rs =  c.s.executeQuery("Select * from customers where username = '"+username+"'");
			while(rs.next())
			{
				lbusername.setText(rs.getString("username"));
				lbname.setText(rs.getString("name"));
				comboid.setSelectedItem(rs.getString("id"));
				tfnum.setText(rs.getString("number"));
				tfcountry.setText(rs.getString("country"));
				tfemail.setText(rs.getString("email"));
				tfphone.setText(rs.getString("phone"));
				tfgender.setText(rs.getString("gender"));
				tfadd.setText(rs.getString("address"));
			}
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		setVisible(true);
		}
		
		
		public static void main(String[] args) {
			 new UpdatePerdetails("Amit123");
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == Update)
			{
				String username = lbusername.getText();
				String id = (String) comboid.getSelectedItem();
				String  number = tfnum.getText();
				String name = lbname.getText();
				String gender = tfgender.getText();;
				String country = tfcountry.getText();
				String address = tfadd.getText();
				String Email = tfemail.getText();
				String Phone = tfphone.getText();
				
				try {
					Connect c = new Connect();
					String query = "update customers set username = '"+username+"' , id = '"+id+"' ,number = '"+number+"' ,name = '"+name+"' ,gender = '"+gender+"' ,country = '"+country+"' ,address = '"+address+"' ,Phone = '"+Phone+"' ,Email = '"+Email+"'";
					c.s.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null,"Customer Details Update Succesfully");
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


