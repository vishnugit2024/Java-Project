package com.TTM;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DashBoard extends JFrame implements ActionListener {
   
	String username;
	JButton addPerdetails , CheckPerdetails , UpdatePerdetails, Checkpackages ,
	        Bookpackages , Viewpackages , CheckHotels , Destination , BookHotels ,
	        CheckbookHotels , DeletePerdetails , Calculators , notepad , about;
	DashBoard(String username)
	{
		this.username = username;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(0,0,102));
		p1.setBounds(0,0,1600,65);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-20/icons/dashboard.png"));
		Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel icon = new JLabel(i3);
		icon.setBounds(5, 0, 70, 70);
		p1.add(icon);
		
		
		JLabel heading = new JLabel("DashBoard");
		heading.setBounds(80, 10, 300, 40);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Tahoma",Font.BOLD,30));
		p1.add(heading);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(new Color(0,0,102));
		p2.setBounds(0,65,300,750);
		add(p2);
		
		 addPerdetails = new JButton("Add Personal Details");
		addPerdetails.setBounds(0, 0, 300, 42);
		addPerdetails.setBackground(Color.ORANGE);
		addPerdetails.setBorder(null);
		addPerdetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		addPerdetails.setForeground(Color.WHITE);
		addPerdetails.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addPerdetails.addActionListener(this);
		//addPerdetails.setMargin(new Insets(0,0,0,50));
		p2.add(addPerdetails);
		
		
		UpdatePerdetails = new JButton("Update Personal Details");
		UpdatePerdetails.setBounds(0, 45, 300, 41);
		UpdatePerdetails.setBackground(Color.ORANGE);
		UpdatePerdetails.setBorder(null);
		UpdatePerdetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		UpdatePerdetails.setForeground(Color.WHITE);
		UpdatePerdetails.setCursor(new Cursor(Cursor.HAND_CURSOR));
		UpdatePerdetails.addActionListener(this);
		//UpdatePerdetails.setMargin(new Insets(0,0,0,50));
		p2.add(UpdatePerdetails);
		
	    CheckPerdetails = new JButton("Check Personal Details");
		CheckPerdetails.setBounds(0, 90, 300, 41);
		CheckPerdetails.setBackground(Color.ORANGE);
		CheckPerdetails.setBorder(null);
		CheckPerdetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		CheckPerdetails.setForeground(Color.WHITE);
		CheckPerdetails.setCursor(new Cursor(Cursor.HAND_CURSOR));
		CheckPerdetails.addActionListener(this);
		//CheckPerdetails.setMargin(new Insets(0,0,0,130));
		p2.add(CheckPerdetails);


		 DeletePerdetails = new JButton("Delete Personal Details");
		DeletePerdetails.setBounds(0, 135, 300, 42);
		DeletePerdetails.setBackground(Color.ORANGE);
		DeletePerdetails.setBorder(null);
		DeletePerdetails.setFont(new Font("Tahoma",Font.PLAIN,20));
		DeletePerdetails.setForeground(Color.WHITE);
		DeletePerdetails.setCursor(new Cursor(Cursor.HAND_CURSOR));
		DeletePerdetails.addActionListener(this);
		//DeletePerdetails.setMargin(new Insets(0,0,0,80));
		p2.add(DeletePerdetails);
		
		
		Checkpackages = new JButton("Check Packages");
		Checkpackages.setBounds(0, 180, 300, 42);
		Checkpackages.setBackground(Color.ORANGE);
		Checkpackages.setBorder(null);
		Checkpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
		Checkpackages.setForeground(Color.WHITE);
		Checkpackages.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Checkpackages.addActionListener(this);
		//DeletePerdetails.setMargin(new Insets(0,0,0,80));
		p2.add(Checkpackages);
		
		
	    Bookpackages = new JButton("Book Packages");
		Bookpackages.setBounds(0, 225, 300, 42);
		Bookpackages.setBackground(Color.ORANGE);
		Bookpackages.setBorder(null);
		Bookpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
		Bookpackages.setForeground(Color.WHITE);
		Bookpackages.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Bookpackages.addActionListener(this);
		//DeletePerdetails.setMargin(new Insets(0,0,0,80));
		p2.add(Bookpackages);
		
	    Viewpackages = new JButton("View Packages");
		Viewpackages.setBounds(0, 270, 300, 41);
		Viewpackages.setBackground(Color.ORANGE);
		Viewpackages.setBorder(null);
		Viewpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
		Viewpackages.setForeground(Color.WHITE);
		Viewpackages.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Viewpackages.addActionListener(this);
		//DeletePerdetails.setMargin(new Insets(0,0,0,80));
		p2.add(Viewpackages);
		
		
		CheckHotels = new JButton("Check Hotels");
		CheckHotels.setBounds(0, 315, 300, 42);
		CheckHotels.setBackground(Color.ORANGE);
		CheckHotels.setBorder(null);
		CheckHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
		CheckHotels.setForeground(Color.WHITE);
		CheckHotels.setCursor(new Cursor(Cursor.HAND_CURSOR));
		CheckHotels.addActionListener(this);
		//DeletePerdetails.setMargin(new Insets(0,0,0,80));
		p2.add(CheckHotels);
	
		
		
	    BookHotels = new JButton("Book Hotel");
		BookHotels.setBounds(0, 360, 300, 42);
		BookHotels.setBackground(Color.ORANGE);
		BookHotels.setBorder(null);
		BookHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
		BookHotels.setForeground(Color.WHITE);
		BookHotels.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BookHotels.addActionListener(this);
		//DeletePerdetails.setMargin(new Insets(0,0,0,80));
		p2.add(BookHotels);
		
		
		 CheckbookHotels = new JButton("Check Booked Hotel");
		CheckbookHotels.setBounds(0, 405, 300, 42);
		CheckbookHotels.setBackground(Color.ORANGE);
		CheckbookHotels.setBorder(null);
		CheckbookHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
		CheckbookHotels.setForeground(Color.WHITE);
		CheckbookHotels.setCursor(new Cursor(Cursor.HAND_CURSOR));
		CheckbookHotels.addActionListener(this);
		//DeletePerdetails.setMargin(new Insets(0,0,0,80));
		p2.add(CheckbookHotels);
		
		
		 Destination = new JButton("Destinations");
		Destination.setBounds(0, 450, 300, 41);
		Destination.setBackground(Color.ORANGE);
		Destination.setBorder(null);
		Destination.setFont(new Font("Tahoma",Font.PLAIN,20));
		Destination.setForeground(Color.WHITE);
		Destination.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Destination.addActionListener(this);
		//DeletePerdetails.setMargin(new Insets(0,0,0,80));
		p2.add(Destination);
		
		
		JButton Payments = new JButton("Payment");
		Payments.setBounds(0, 495, 300, 42);
		Payments.setBackground(Color.ORANGE);
		Payments.setBorder(null);
		Payments.setFont(new Font("Tahoma",Font.PLAIN,20));
		Payments.setForeground(Color.WHITE);
		Payments.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//DeletePerdetails.setMargin(new Insets(0,0,0,80));
		p2.add(Payments);
		
		
		Calculators = new JButton("Calculator");
		Calculators.setBounds(0, 540, 300, 42);
		Calculators.setBackground(Color.ORANGE);
		Calculators.setBorder(null);
		Calculators.setFont(new Font("Tahoma",Font.PLAIN,20));
		Calculators.setForeground(Color.WHITE);
		Calculators.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Calculators.addActionListener(this);
		//DeletePerdetails.setMargin(new Insets(0,0,0,80));
		p2.add(Calculators);
		
		
	    notepad = new JButton("Notepad");
		notepad.setBounds(0, 585, 300, 42);
		notepad.setBackground(Color.ORANGE);
		notepad.setBorder(null);
		notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
		notepad.setForeground(Color.WHITE);
		notepad.setCursor(new Cursor(Cursor.HAND_CURSOR));
		notepad.addActionListener(this);
		//DeletePerdetails.setMargin(new Insets(0,0,0,80));
		p2.add(notepad);
		
		
		 about = new JButton("About");
		about.setBounds(0, 630, 300, 46);
		about.setBackground(Color.ORANGE);
		about.setBorder(null);
		about.setFont(new Font("Tahoma",Font.PLAIN,20));
		about.setForeground(Color.WHITE);
		about.setCursor(new Cursor(Cursor.HAND_CURSOR));
		about.addActionListener(this);
		//DeletePerdetails.setMargin(new Insets(0,0,0,80));
		p2.add(about);
		
		
		JButton Feedback = new JButton("Feedback");
		Feedback.setBounds(0, 680, 300, 50);
		Feedback.setBackground(Color.ORANGE);
		Feedback.setBorder(null);
		Feedback.setFont(new Font("Tahoma",Font.PLAIN,20));
		Feedback.setForeground(Color.WHITE);
		Feedback.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//DeletePerdetails.setMargin(new Insets(0,0,0,80));
		p2.add(Feedback);
		
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons-20/icons/home.jpg"));
		Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image = new JLabel(i6);
		image.setBounds(0, 0, 1650, 1000);
		add(image);
		
		
		JLabel text = new JLabel("Travel and Tourism Management System");
		text.setBounds(400, 70, 1200, 70);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway",Font.BOLD, 50));
		image.add(text);
		
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addPerdetails)
		{
			new AddCustomer(username);
			
		} else if (e.getSource() == CheckPerdetails )
		{
			new CheckPerdetails("Amit123");
			
		} else if (e.getSource() == UpdatePerdetails)
		{
			 new UpdatePerdetails(username);
			 
		} else if (e.getSource() == Checkpackages)
		{
			 new CheckPackage();
			 
		} else if (e.getSource() == Bookpackages)
		{
			new BookPackage("Amit123");
		} else if (e.getSource() == Viewpackages)
		{
			new ViewPackage("Amit123");
		} else if (e.getSource() == CheckHotels)
		{
			new CheckHotels().setVisible(true);
		} else if (e.getSource() == Destination)
		{
			new Destination().setVisible(true);
		} else if (e.getSource() == BookHotels)
		{
			BookHotel frame = new BookHotel("Amit123");
			frame.setVisible(true);
		} else if (e.getSource() == CheckbookHotels )
		{
			ViewBookedHotel frame = new ViewBookedHotel("Amit123");
			frame.setVisible(true);
		} else if (e.getSource() == DeletePerdetails )
		{
			try {
				DeleteCustomer frame = new DeleteCustomer();
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == Calculators )
		{
			try {
				Runtime.getRuntime().exec("calc.exe");
			} catch (Exception e2)
			{
				e2.printStackTrace();
			}
		} else if (e.getSource() == notepad)
		{
			try {
				Runtime.getRuntime().exec("notepad.exe");
			} catch (Exception e3){
				e3.printStackTrace();
			}
		} else if (e.getSource() == about)
		{
			 new About().setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new DashBoard("");
	}

}
