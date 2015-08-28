package com.breakout.team1.main;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.breakout.team1.gameui.GameWindow;
import com.breakout.team1.observer.Observable;
import com.breakout.team1.observer.Observer;
import com.breakout.team1.ui.Ball;
import com.breakout.team1.ui.Block;
import com.breakout.team1.ui.Clock;

// This is the window that the UI is in
public class StartMain {

	private ArrayList<Observer> obsList = new ArrayList<Observer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameWindow game = new GameWindow();
		JFrame window = new JFrame("Breakout Game");
		window.add(game, BorderLayout.WEST);
		window.pack();
		window.setSize(550, 450);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		Clock clock = new Clock();

		window.add(clock, BorderLayout.CENTER);
		window.setVisible(true);

	}

}