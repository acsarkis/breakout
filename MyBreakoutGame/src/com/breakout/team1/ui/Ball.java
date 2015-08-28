package com.breakout.team1.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.breakout.team1.service.impl.BallMovementServiceImpl;
import com.breakout.team1.service.intf.ObjectMovementService;

public class Ball extends Shape implements ActionListener {

	private ObjectMovementService objectMovementService = new BallMovementServiceImpl();

	private int full_bounce_cd = 5;
	private int horizontalBounceCD = 0;
	private int verticalBounceCD = 0;
	
	public Ball() {
		initStaticFeats();
		// Added by Andrew (Can be removed)
		this.setxCoordinate(200);
		this.setyCoordinate(200);
		this.setObjectHeight(20);
		this.setObjectWidth(20);
		this.setSpeedX(-1);
		this.setSpeedY(3);
		
		setBackground(Color.BLACK);
		Timer timer = new Timer(1000 / 60, this);
		timer.start();
	}
	
	public Ball(int xCoordinate, int yCoordinate, int objectWidth, int objectHeight, int mapWidth, int mapHeight, int pid, int speedX, int speedY) {
		super(xCoordinate, yCoordinate, objectWidth, objectHeight, mapWidth, mapHeight, pid);
		initStaticFeats();
		this.speedX = speedX;
		this.speedY = speedY;
		
		setBackground(Color.BLACK);
		Timer timer = new Timer(1000 / 60, this);
		timer.start();
	}
	
	public void initStaticFeats() {
		this.color = Color.GREEN;
		this.shapeNum = 1;
		this.isMobile = true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		objectMovementService.move(this);
		
	}
	
	public void setCollided(boolean isCollidedHorizontal, boolean isCollidedvertical) {
		this.isCollided = isCollidedHorizontal || isCollidedvertical;
		
		if(isCollidedHorizontal){ //&& horizontalBounceCD < 1) {
			speedX *= -1;
			this.horizontalBounceCD = this.full_bounce_cd;
		}
		if(isCollidedvertical){ //&& verticalBounceCD < 1) {
			speedY *= -1;
			this.verticalBounceCD = this.full_bounce_cd;
		}
		this.isCollided = false;
	}

	

}
