package com.sankeladder.domain;

import java.util.HashMap;
import java.util.Map;

import com.sankeladder.enums.SurpriseType;

public class GameBoard {
	
	public static final int BOARD_LENGTH = 10;
	public static final int BOARD_WIDTH = 12;
	public static final int START = 0;
	public static final int END = BOARD_LENGTH * BOARD_WIDTH;
	
	private Map<Integer, Surprise> positions = null;
	
	private void populateGameBoard(){
		positions = new HashMap<Integer, Surprise>();
		
		positions.put(119, new Surprise(SurpriseType.SNAKE, 78));
		positions.put(115, new Surprise(SurpriseType.SNAKE, 65));
		positions.put(113, new Surprise(SurpriseType.SNAKE, 73));
		positions.put(87, new Surprise(SurpriseType.SNAKE, 24));
		positions.put(64, new Surprise(SurpriseType.SNAKE, 60));
		positions.put(62, new Surprise(SurpriseType.SNAKE, 19));
		positions.put(54, new Surprise(SurpriseType.SNAKE, 34));
		
		positions.put(4, new Surprise(SurpriseType.LADDER, 14));
		positions.put(9, new Surprise(SurpriseType.LADDER, 31));
		positions.put(20, new Surprise(SurpriseType.LADDER, 38));
		positions.put(28, new Surprise(SurpriseType.LADDER, 94));
		positions.put(51, new Surprise(SurpriseType.LADDER, 67));
		positions.put(63, new Surprise(SurpriseType.LADDER, 91));
		positions.put(71, new Surprise(SurpriseType.LADDER, 111));
	}

	public Map<Integer, Surprise> getPositions() {
		if(positions == null){
			populateGameBoard();
		}
		return positions;
	}
	
}
