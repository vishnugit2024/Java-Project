package com.TTM;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Loading extends JFrame implements Runnable{
     Thread t;
     JProgressBar bar;
	String username;
    
	
	Loading(String username){
		t = new Thread(this);
		this.username = username;
		
		setBounds(500,200,650,400);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Travel and Tourism Application");
		text.setBounds(50, 20, 600, 40);
		text.setForeground(Color.BLUE);
		text.setFont(new Font("Raleway", Font.BOLD,35));
		add(text);
		
		 bar = new JProgressBar();
		bar.setBounds(150, 100, 300, 35);
		bar.setStringPainted(true);
		add(bar);
		
		JLabel Loading = new JLabel("Loading...");
		Loading.setBounds(260, 130, 150, 30);
		Loading.setForeground(Color.RED);
		Loading.setFont(new Font("Raleway", Font.BOLD,16));
		add(Loading);
		
		JLabel username1 = new JLabel("Welcome "+username);
		username1.setBounds(20, 310, 400, 40);
		username1.setForeground(Color.MAGENTA);
		username1.setFont(new Font("Raleway", Font.BOLD,16));
		add(username1);
		
		
		t.start();
		setVisible(true);
	}
	
	public static void main(String[] args) {
	
		new Loading("");	
	}

	@Override
	public void run() {
		try {
			for(int i = 1; i<=101; i++)
			{
				int max = bar.getMaximum();
				int value = bar.getValue();
				
				if(value < max)
				{
					bar.setValue(bar.getValue() + 1);
				} else {
					
					setVisible(false);
					new DashBoard(username);
				}
				Thread.sleep(10);
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
  }
