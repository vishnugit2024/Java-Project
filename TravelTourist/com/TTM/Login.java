package com.TTM;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	
	JButton login, signup, password;
	JTextField tfusername , tfpassword ;
	
	Login()
	{
		setSize(900,400);
		setLocation(350,200);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(131,193,233));
		p1.setBounds(0, 0, 400, 400);
		p1.setLayout(null);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-20/icons/login.png"));
		Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(100, 120, 200, 200);
		p1.add(image);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(400, 30, 450, 300);
		add(p2);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(60, 20, 100, 25);
		lblusername.setFont(new Font("SAN SERIF",Font.BOLD,20));
		p2.add(lblusername);
		
		 tfusername = new JTextField();
		tfusername.setBounds(60, 60, 300, 30);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tfusername);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(60,110, 300, 30);
		lblpassword.setFont(new Font("SAN SERIF",Font.BOLD,20));
		p2.add(lblpassword);
		
		 tfpassword = new JTextField();
		tfpassword.setBounds(60, 150, 300, 30);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tfpassword);
		
		 login = new JButton("Login");
		login.setBounds(60, 200, 130, 30);
		login.setBackground(new Color(133,193,233));
		login.setForeground(Color.WHITE);
		login.setBorder(null);
		login.setCursor(new Cursor(Cursor.HAND_CURSOR));
		login.addActionListener(this);
		p2.add(login);
		
		 signup = new JButton("Signup");
		signup.setBounds(220, 200, 130, 30);
		signup.setBackground(new Color(133,193,233));
		signup.setForeground(Color.WHITE);
		signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		signup.setBorder(null);
		signup.addActionListener(this);
		p2.add(signup);
		
		 password = new JButton("Forget Password");
		password.setBounds(135, 240, 130, 30);
		password.setBackground(new Color(133,193,233));
		password.setForeground(Color.WHITE);
		password.setBorder(null);
		password.setCursor(new Cursor(Cursor.HAND_CURSOR));
		password.addActionListener(this);
		p2.add(password);
		
		JLabel text = new JLabel("Trouble in login...");
		text.setBounds(300, 250, 150, 20);
		text.setForeground(Color.RED);
		p2.add(text);
		
		setVisible(true);
	}
	
  public static void main(String[] args) {
	new Login();
	
	
}

@Override
public void actionPerformed(ActionEvent e) {

	if (e.getSource() == login) {
		try {
			String username = tfusername.getText();
			String password = tfpassword.getText();
			
			String query = "select * from TTDATA where username = '"+username+"' and password = '"+password+"' ";
			Connect c = new Connect();
			ResultSet rs =  c.s.executeQuery(query);
			
			if(rs.next())
			{
				setVisible(false);
				new Loading(username);
			}else {
				JOptionPane.showMessageDialog(null, "Incorrect username or password");
			}
			
		} catch (Exception es)
		{
			es.printStackTrace();
		}
	}
	else if (e.getSource() == signup) {
		setVisible(false);
		new Signup();
	}
	else {
		setVisible(false);
		new ForgetPassword();
	}
  }
    }
