package com.breakout.team1.gameui;

import java.util.ArrayList;

import com.breakout.team1.ui.Shape;

public class Collisions {
	private ArrayList<Shape> colliders = new ArrayList<Shape>();
	private boolean collHorizontal = false;
	private boolean collVertical = false;
	
	public ArrayList<Shape> getColliders() {
		return colliders;
	}
	
	public void addCollider(Shape newCollider) {
		colliders.add(newCollider);
	}
	
	public void removerCollider(Shape remCollider) {
		colliders.remove(remCollider);
	}
	
	public int getNumColliders() {
		return colliders.size();
	}
	
	public void checkCollisions(Shape checkObj) {
		if(boundCheck(checkObj)) {
			checkObj.setCollided(collHorizontal, collVertical);
		}
		for(int i = 0 ; i < colliders.size(); i++) {
			if(isCollision(checkObj, colliders.get(i))) {
				colliders.get(i).setCollided(collHorizontal, collVertical);
				checkObj.setCollided(collHorizontal, collVertical);
			}
		}
	}
	
	public boolean boundCheck(Shape shape) {
		boolean boundsColl = false;
		
		if (shape.getTop() < 0 || shape.getBottom() > shape.getMapHeight()) { 	
			this.collVertical = true;
			boundsColl = true;
		}
		if (shape.getLeft() < 0 || shape.getRight() > shape.getMapWidth()) { 
			this.collHorizontal = true;
			boundsColl = true;
		}
		return boundsColl;
	}
	
	public boolean isCollision(Shape shape1, Shape shape2) {
		// Collision checking resource: http://www.owenpellegrin.com/articles/vb-net/simple-collision-detection/
		boolean horizontalCollision = false;
		boolean verticalCollision = false;
		
		if(shape1.getLeft() < shape2.getLeft() && shape2.getLeft() < shape1.getRight()) {
			horizontalCollision = true;
		}
		
		if(shape1.getLeft() < shape2.getRight() && shape2.getRight() < shape1.getRight()) {
			horizontalCollision = true;
		}
		
		if(shape1.getTop() < shape2.getTop() && shape2.getTop() < shape1.getBottom()) {
			verticalCollision = true;
		}
		
		if(shape1.getTop() < shape2.getBottom() && shape2.getBottom() < shape1.getBottom()) {
			verticalCollision = true;
		}
		this.collHorizontal = horizontalCollision;
		this.collVertical = verticalCollision;
		
		return horizontalCollision && verticalCollision;
	}
}
