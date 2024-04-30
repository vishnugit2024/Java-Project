package com.TTM;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Signup extends JFrame implements ActionListener{
	
	JButton create,Back;
	 JTextField tfuser,tfname,tfpass,tfanswer;
	 Choice security;
	
	Signup()
	{
		setBounds(350,200,900,360);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(133,193,233));
		p1.setBounds(0, 0, 500, 400);
		p1.setLayout(null);
		add(p1);
		
		JPanel p2 = new JPanel();
		p2.setBounds(400, 30, 450, 300);
		p2.setBounds(500, 0, 500, 400);
		p2.setLayout(null);
		add(p2);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
		lblusername.setBounds(50, 20, 125, 25);
		p1.add(lblusername);
		
		 tfuser = new JTextField();
		tfuser.setBounds(190, 20, 180, 25);
		tfuser.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfuser);
		
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma",Font.BOLD,14));
		lblname.setBounds(50, 60, 125, 25);
		p1.add(lblname);
		
		 tfname = new JTextField();
		tfname.setBounds(190, 60, 180, 25);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfname);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
		lblpassword.setBounds(50, 100, 125, 25);
		p1.add(lblpassword);
		
		 tfpass = new JTextField();
		tfpass.setBounds(190, 100, 180, 25);
		tfpass.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfpass);
		
		JLabel lblsecurity = new JLabel("Security Question");
		lblsecurity.setFont(new Font("Tahoma",Font.BOLD,14));
		lblsecurity.setBounds(50, 140, 125, 25);
		p1.add(lblsecurity);
		
		 security = new Choice();
		security.add("Fav Color");
		security.add("Fav Cartoon");
		security.add("MAngo vs Banana");
		security.add("GYM vs YOGA");
		security.setBounds(190, 140, 180, 25);
		p1.add(security);

		
		JLabel lblanswer = new JLabel("Answer");
		lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
		lblanswer.setBounds(50, 180, 125, 25);
		p1.add(lblanswer);
		
		 tfanswer = new JTextField();
		tfanswer.setBounds(190, 180, 180, 25);
		tfanswer.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfanswer);
		
	    create = new JButton("Create");
		create.setBackground(Color.WHITE);
		create.setForeground(new Color(133,193,233));
		create.setFont(new Font("Tahoma",Font.BOLD,14));
		create.setBounds(80, 250, 100, 30);
		create.setCursor(new Cursor(Cursor.HAND_CURSOR));
		create.addActionListener(this);
		p1.add(create);
		
	    Back = new JButton("Back");
		Back.setBackground(Color.WHITE);
		Back.setForeground(new Color(133,193,233));
		Back.setFont(new Font("Tahoma",Font.BOLD,14));
		Back.setBounds(200, 250, 100, 30);
		Back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Back.addActionListener(this);
		p1.add(Back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-20/icons/signup.png"));
		Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(100, 70, 210, 210);
		p2.add(image);
		
		
		
		setVisible(true);
	}
	
	
   public static void main(String[] args) {
	new Signup();
}


@Override
public void actionPerformed(ActionEvent e) {
        if(e.getSource() == create) {
        	String username = tfuser.getText();
        	String name = tfname.getText();
        	String password = tfpass.getText();
        	String question = security.getSelectedItem();
        	String answer = tfanswer.getText();
        	
        	String query = "insert into TTDATA values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
        	try {
        		Connect c = new Connect();
        		c.s.executeUpdate(query);
        		
        		JOptionPane.showMessageDialog(null,"Account created Succesfully");
        		
        		setVisible(false);
        		new Login();
        	} catch(Exception e1)
        	{
        		e1.printStackTrace();
        	}
        	
        	
        } else if (e.getSource() == Back)
        {
        	setVisible(false);
        	new Login();
        }
}
}
