package com.breakout.team1.ui;
import java.awt.Color;
import java.awt.event.KeyEvent;

import com.breakout.team1.service.impl.BallMovementServiceImpl;
import com.breakout.team1.service.intf.ObjectMovementService;

public class Paddle extends Shape {
	
	private ObjectMovementService objectMovementService = new BallMovementServiceImpl();
	
	public Paddle() {
		initStaticFeats();
		// Added by Andrew (Can be removed)
		this.setxCoordinate(50);
		this.setyCoordinate(100);
		this.setObjectHeight(20);
		this.setObjectWidth(20);
		
		setBackground(Color.BLACK);
	}
	
	public void updateObs(KeyEvent keyEvent) {
		int c = keyEvent.getKeyCode();
		if(c == KeyEvent.VK_W) {
			handlePaddleMovement(-10);
		} else if(c == KeyEvent.VK_S) {
			handlePaddleMovement(10);
		}
	}
	
	public void handlePaddleMovement(int velocity) {
		this.speedY = velocity;
		objectMovementService.move(this);
		this.speedY = 0;
	}
	
	public Paddle(int xCoordinate, int yCoordinate, int objectWidth, int objectHeight, int mapWidth, int mapHeight, int pid) {
		super(xCoordinate, yCoordinate, objectWidth, objectHeight, mapWidth, mapHeight, pid);
		initStaticFeats();
		this.objectWidth /= 3;
		
		setBackground(Color.BLACK);
	}
	
	public void initStaticFeats() {
		this.isObserver = true;
		this.color = Color.WHITE;
		this.shapeNum = 2;
		this.isMobile = true;
	}
	
}
