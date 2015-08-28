package com.breakout.team1.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Timer;

public class Clock extends Shape implements ActionListener {

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"hh:mm:ss a");
	String currentTime = "";

	public Clock() {
		
		setBackground(Color.WHITE);
		Timer timer = new Timer(1000, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		stimulateClock();
	}

	public void stimulateClock() {

		currentTime = simpleDateFormat.format(new Date());
		repaint();

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.BLACK);
		setFont(new Font("sans-serif", Font.PLAIN, 12));

		g.drawString(currentTime, 50, 200);

		
	}
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.GREEN);
		setFont(new Font("sans-serif", Font.BOLD, 15));

		g.drawString(currentTime, 450, 100);

	}

}
