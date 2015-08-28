package com.breakout.team1.ui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.breakout.team1.gameui.Collisions;
import com.breakout.team1.observer.Observer;


// needs to be converted to an abstract class according to the style guide.
public class Shape extends JPanel implements Observer {

	protected int speedX = 0;
	protected int speedY = 0;
	protected boolean isMobile = false;
	protected int xCoordinate;
	protected int yCoordinate;
	protected int objectHeight;
	protected int objectWidth;
	protected Color color = Color.CYAN;
	protected int shapeNum = 0;
	protected boolean isObserver = false;
	protected int mapWidth = 0;
	protected int mapHeight = 0;
	protected Collisions collisionHandler = new Collisions();
	protected int pid;
	protected boolean isCollided = false;

	public Shape() {
		// Added by Andrew (Can be removed)
		this.color = Color.GREEN;
		this.shapeNum = 1;
		this.setxCoordinate(200);
		this.setyCoordinate(200);
		this.setObjectHeight(20);
		this.setObjectWidth(20);
	}
	
	public Shape(int xCoordinate, int yCoordinate, int objectWidth, int objectHeight, int mapWidth, int mapHeight, int pid) {
		this.pid = pid;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.objectWidth = objectWidth;
		this.objectHeight = objectHeight;
		this.mapHeight = mapHeight;
		this.mapWidth = mapWidth;
	}
	
	public Collisions getCollisionHandler() {
		return collisionHandler;
	}
	
	public void setCollisionHandler(Collisions newHandler) {
		this.collisionHandler = newHandler;
	}
	
	public int getSpeedX() {

		return speedX;
	}
	
	public void setCollided(boolean isCollidedHorizontal, boolean isCollidedvertical) {
		this.isCollided = isCollidedHorizontal || isCollidedvertical;
	}

	public void setSpeedX(int speedX) {
		if(isMobile) {
			this.speedX = speedX;
		}
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		if(isMobile) {
			this.speedY = speedY;
		}
	}
	
	public int getRight() {
		return this.xCoordinate + this.objectWidth + this.speedX;
	}
	
	public int getLeft() {
		return this.xCoordinate + this.speedX;
	}
	
	public int getTop() {
		return this.yCoordinate + this.speedY;
	}
	
	public int getBottom() {
		return this.yCoordinate + this.objectHeight + this.speedY;
	}
	
	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public int getObjectHeight() {
		return objectHeight;
	}

	public void setObjectHeight(int objectHeight) {
		this.objectHeight = objectHeight;
	}
	
	public void setObjectWidth(int objectWidth) {
		this.objectWidth = objectWidth;
	}

	public int getObjectWidth() {
		return this.objectWidth;
	}
	
	public int getMapWidth() {
		return this.mapWidth;
	}
	
	public int getMapHeight() {
		return this.mapHeight;
	}
	
	public int getShape() {
		return this.shapeNum;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public boolean getIsObserver() {
		return this.isObserver;
	}
	
	public void setIsObserver(boolean isObserver) {
		this.isObserver = isObserver;
	}
	
	public boolean getMobility() {
		return this.isMobile;
	}

	@Override
	public void updateObs(KeyEvent keyEvent) {
		
	}

}
