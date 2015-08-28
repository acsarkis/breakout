package com.breakout.team1.gameui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.breakout.team1.observer.Observable;
import com.breakout.team1.observer.Observer;
import com.breakout.team1.ui.Ball;
import com.breakout.team1.ui.Shape;

// THis is the window that the game is actually played in
public class GameWindow extends JPanel implements KeyListener, Observable {
	private static final int MAP_WIDTH = 400;
	private static final int MAP_HEIGHT = 400;
	private ArrayList<Shape> activeShapes = new ArrayList<Shape>();
	private LevelStorage gameLevelStorage;
	private ArrayList<Observer> obsList = new ArrayList<Observer>();
	private Collisions collisionHandler;
	private ArrayList<Shape> colliders = new ArrayList<Shape>();
	
	public GameWindow() {
		collisionHandler = new Collisions();
		gameLevelStorage = new LevelStorage();
		this.setSize(MAP_WIDTH, MAP_HEIGHT);
		setPreferredSize(new Dimension(MAP_WIDTH,MAP_HEIGHT));
		setFocusable(true);
		setFocusable(true);
		addKeyListener(this);
		setBackground(Color.BLACK);
		activeShapes = gameLevelStorage.getLevel(1, MAP_WIDTH, MAP_HEIGHT);
		parseShapes();
		
	}
	
	public void parseShapes() {
		for(int i = 0; i < activeShapes.size(); i++) {
			if(activeShapes.get(i).getIsObserver()) {
				obsList.add((Observer) activeShapes.get(i));
			}
			collisionHandler.addCollider(activeShapes.get(i));
			activeShapes.get(i).setCollisionHandler(this.collisionHandler);
		}
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, MAP_WIDTH,  MAP_HEIGHT);
		
		for(int i = 0; i < activeShapes.size(); i++) {
			drawShape(g, activeShapes.get(i));
		}
		
		// Check for Collisions & handle them
		// 1. (If the ball hits a brick: Destroy the brick & bounce the ball)
		// 3. (Bounce the ball off of the panel's bounds)
		
		repaint();
	}
	
	public void drawShape(Graphics g, Shape shape) {
		g.setColor(shape.getColor());
		if(shape.getShape() == 1) {
			// Circle/Oval case
			g.fillOval(shape.getxCoordinate(), shape.getyCoordinate(), shape.getObjectWidth(), shape.getObjectHeight());
		} else if(shape.getShape() == 2) {
			// Rectangle/Cube case
			g.fillRect(shape.getxCoordinate(), shape.getyCoordinate(), shape.getObjectWidth(), shape.getObjectHeight());
		}
	}

	@Override
	public void NotifyObservers(KeyEvent keyEvent) {
		for(int i = 0; i < obsList.size(); i++) {
			obsList.get(i).updateObs(keyEvent);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println(obsList.size());
		NotifyObservers(e);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}