package com.breakout.team1.service.impl;

import com.breakout.team1.service.intf.ObjectMovementService;
import com.breakout.team1.ui.Ball;
import com.breakout.team1.ui.Shape;

public class BallMovementServiceImpl implements ObjectMovementService {

	@Override
	public void move(Shape shape) {
		// TODO Auto-generated method stub
		int xVelocity = shape.getSpeedX();
		int yVelocity = shape.getSpeedY();
		int xCoordinate = shape.getxCoordinate();
		int yCoordinate = shape.getyCoordinate();
		
		int nextBallLeft = xCoordinate + xVelocity;
        int nextBallRight = xCoordinate + shape.getObjectWidth() + xVelocity;
        int nextBallTop = yCoordinate + shape.getSpeedY();
        int nextBallBottom = yCoordinate + shape.getObjectHeight() + yVelocity;
        
        shape.getCollisionHandler().checkCollisions(shape);
        
        if (nextBallTop < 0 || nextBallBottom > shape.getMapHeight()) { 	
        	//shape.setSpeedY(shape.getSpeedY()*(-1));
        } else {
        	shape.setyCoordinate(yCoordinate + yVelocity);
        }
        
        if (nextBallLeft < 0 || nextBallRight > shape.getMapWidth()) { 
        	//shape.setSpeedX(shape.getSpeedX() * (-1));
        } else {
        	shape.setxCoordinate(xCoordinate + xVelocity);
        }
	}

}
