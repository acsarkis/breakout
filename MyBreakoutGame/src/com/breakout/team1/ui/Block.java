package com.breakout.team1.ui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Timer;

public class Block extends Shape {
	
	public Block() {
		initStaticFeats();
		this.isMobile = true;
		this.setxCoordinate(200);
		this.setyCoordinate(200);
		this.setObjectHeight(20);
		this.setObjectWidth(20);
		setBackground(Color.BLACK);
	}
	
	public Block(int xCoordinate, int yCoordinate, int objectWidth, int objectHeight, int mapWidth, int mapHeight, int pid) {
		super(xCoordinate, yCoordinate, objectWidth, objectHeight, mapWidth, mapHeight, pid);
		initStaticFeats();
	}
	
	public void initStaticFeats() {
		this.color = Color.RED;
		this.shapeNum = 2;
	}
	
	public void setCollided(boolean isCollidedHorizontal, boolean isCollidedvertical) {
		this.isCollided = isCollidedHorizontal || isCollidedvertical;
		if(isCollided) {
			this.collisionHandler.removerCollider(this);
			this.shapeNum = 0;
		}
	}
	
}
