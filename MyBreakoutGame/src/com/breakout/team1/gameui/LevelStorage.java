package com.breakout.team1.gameui;

import java.util.ArrayList;

import com.breakout.team1.ui.Ball;
import com.breakout.team1.ui.Block;
import com.breakout.team1.ui.Paddle;
import com.breakout.team1.ui.Shape;

public class LevelStorage {
	private int mapHeight = 0;
	private int mapWidth = 0;
	private int currPid = 0;
	
	public ArrayList<Shape> getLevel(final int levelNum, int mapWidth,int mapHeight) {
		this.mapHeight = mapWidth;
		this.mapWidth = mapHeight;
		ArrayList<Shape> returnShapes = new ArrayList<Shape>();
		int[][] tempLevel = null;
		
		if(levelNum == 1) {
			tempLevel = getIntRepresentationLevel(levelNum);
		}
		
		returnShapes = parseShapes(tempLevel, calcBlockLen(mapWidth, tempLevel[0].length), calcBlockLen(mapHeight, tempLevel.length));
		
		return returnShapes;
	}
	
	public int calcBlockLen(int axisLength, int mapArrayLength) {
		return axisLength / mapArrayLength;
	}
	
	public ArrayList<Shape> parseShapes(int[][] intLevel, int gridCellHeight, int gridCellWidth) {
		ArrayList<Shape> returnShapes = new ArrayList<Shape>();
		
		for(int x = 0; x < intLevel[0].length; x++) {
			for(int y = 0; y < intLevel.length; y++) {
				if(intLevel[y][x] == 1) {
					Ball newBall = 
							new Ball(x * gridCellWidth, y * gridCellHeight, gridCellWidth, gridCellHeight, mapWidth, mapHeight, assignPid(), -1, 3);
					returnShapes.add(newBall);
				} else if(intLevel[y][x] == 2) {
					Block newBlock = 
							new Block(x * gridCellWidth, y * gridCellHeight, gridCellWidth, gridCellHeight, mapWidth, mapHeight, assignPid());
					returnShapes.add(newBlock);
				} else if(intLevel[y][x] == 3) {
					Paddle newPaddle = 
							new Paddle(x * gridCellWidth, y * gridCellHeight, gridCellWidth, gridCellHeight, mapWidth, mapHeight, assignPid());
					returnShapes.add(newPaddle);
				}
			}
		}
		
		return returnShapes;
	}
	
	private int assignPid() {
		currPid++;
		return currPid;
	}
	
	
	// 1 - represents the Ball class
	// 2 - represents the Block class
	// 3 - represents the Paddle class
	public int[][] getIntRepresentationLevel(final int levelNum) {
		int[][] outputLevel = null;
		
		if(levelNum == 1) {
			outputLevel = new int[][] {
				{0,2,2,2,2,2,2,2,2,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,2,0,0,0,2},
				{0,0,0,3,0,2,0,0,2,0},
				{0,0,0,1,0,0,0,0,2,0},
				{0,0,0,0,0,0,0,0,2,0},
				{0,0,0,2,0,0,0,2,0,0},
				{0,2,2,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
			};
		}
		
		return outputLevel;
		
	}
	
}
