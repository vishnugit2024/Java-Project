package com.TTM;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class ForgetPassword extends JFrame implements ActionListener {
     
	JTextField tfusername,tfname,tfquestion,tfanswer,tfpassword;
	JButton search,retrieve,back;
	
	
	ForgetPassword()
  {
	 setBounds(350,200,850,380);
	 getContentPane().setBackground(Color.WHITE);
	 setLayout(null);
	 
	 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-20/icons/forgotpassword.jpg"));
	 Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
	 ImageIcon i3 = new ImageIcon(i2);
	 JLabel image = new JLabel(i3);
	 image.setBounds(580, 70, 200, 200);
	 add(image);
	 
	 JPanel p1 = new JPanel();
	 p1.setLayout(null);
	 p1.setBounds(30, 30, 500, 280);
	 add(p1);
	 
	 JLabel lblusername = new JLabel("Username");
	 lblusername.setBounds(40, 20, 100, 25);
	 lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
	 p1.add(lblusername);
	 
	 tfusername = new JTextField();
	 tfusername.setBounds(220, 20, 150, 25);
	 tfusername.setBorder(BorderFactory.createEmptyBorder());
	 p1.add(tfusername);
	 
	 search = new JButton("Search");
	 search.setBackground(Color.GRAY);
	 search.setForeground(Color.WHITE);
	 search.setBounds(380, 20, 100, 25);
	 search.setCursor(new Cursor(Cursor.HAND_CURSOR));
	 search.addActionListener(this);
	 p1.add(search);
	 
	 JLabel lblname = new JLabel("Name");
	 lblname.setBounds(40,60, 100, 25);
	 lblname.setFont(new Font("Tahoma",Font.BOLD,14));
	 p1.add(lblname);
	 
	 tfname = new JTextField();
	 tfname.setBounds(220, 60, 150, 25);
	 tfname.setBorder(BorderFactory.createEmptyBorder());
	 p1.add(tfname);
	 
	 
	 JLabel lblquestion = new JLabel("Security Question");
	 lblquestion.setBounds(40, 100, 150, 25);
	 lblquestion.setFont(new Font("Tahoma",Font.BOLD,14));
	 p1.add(lblquestion);
	 
	 tfquestion = new JTextField();
	 tfquestion.setBounds(220, 100, 150, 25);
	 tfquestion.setBorder(BorderFactory.createEmptyBorder());
	 p1.add(tfquestion);
	 
	 JLabel lblanswer = new JLabel("Answer");
	 lblanswer.setBounds(40, 140, 150, 25);
	 lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
	 p1.add(lblanswer);
	 
	 tfanswer = new JTextField();
	 tfanswer.setBounds(220, 140, 150, 25);
	 tfanswer.setBorder(BorderFactory.createEmptyBorder());
	 p1.add(tfanswer);
	 
	 retrieve = new JButton("Retrieve");
	 retrieve.setBackground(Color.GRAY);
	 retrieve.setForeground(Color.WHITE);
	 retrieve.setBounds(380, 140, 100, 25);
	 retrieve.setCursor(new Cursor(Cursor.HAND_CURSOR));
	 retrieve.addActionListener(this);
	 p1.add(retrieve);
	 
	 JLabel lblpassword = new JLabel("Password");
	 lblpassword.setBounds(40, 180, 150, 25);
	 lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
	 p1.add(lblpassword);
	 
	 tfpassword = new JTextField();
	 tfpassword.setBounds(220, 180, 150, 25);
	 tfpassword.setBorder(BorderFactory.createEmptyBorder());
	 p1.add(tfpassword);
	 
	 back = new JButton("Back");
	 back.setBackground(Color.GRAY);
	 back.setForeground(Color.WHITE);
	 back.setBounds(150, 230, 100, 25);
		back.setCursor(new Cursor(Cursor.HAND_CURSOR));
	 back.addActionListener(this);
	 p1.add(back);

	 
	 setVisible(true);
  }
  
  public static void main(String[] args) 
  {
	new ForgetPassword();
    
  }

@Override
public void actionPerformed(ActionEvent e)
 {
	if(e.getSource() == search) {
		try {
			String query = "select * from TTDATA where username = '"+tfusername.getText()+"'";
			Connect c = new Connect();
			
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next())
			{
				tfname.setText(rs.getString("name"));
				tfquestion.setText(rs.getString("security"));
			}
			
		}catch(Exception es)
		{
			es.printStackTrace();
		}
	}
	else if(e.getSource() == retrieve) {
		try {
			String query = "select * from TTDATA where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"'";
			Connect c = new Connect();
			
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next())
			{
				tfpassword.setText(rs.getString("password"));
			}
			
		}catch(Exception es)
		{
			es.printStackTrace();
		}
	}
	else { setVisible(false);
           new Login();    	
	}
		
	
	
   }
}
