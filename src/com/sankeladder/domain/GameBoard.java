package com.sankeladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sankeladder.enums.SurpriseType;

public class GameBoard {
	
	public static final int BOARD_LENGTH = 10;
	public static final int BOARD_WIDTH = 12;
	public static final int START = 0;
	public static final int END = BOARD_LENGTH * BOARD_WIDTH;
	public static final int NO_OF_SNAKES = 7;
	public static final int NO_OF_LADDERS = 7;
	
	private Map<Integer, Surprise> positions = null;
	private Random random = new Random();
	
	private void populateGameBoard(){
		positions = new HashMap<Integer, Surprise>();
		
		fillSnakesPositions();
		fillLadderPositions();
		
	}
	
	private void fillSnakesPositions(){
		int boardSize = BOARD_LENGTH * BOARD_WIDTH;
		int head = 0;
		int tail = 0;
		
		for(int i = 0; i < NO_OF_SNAKES; i++){
			head = generateRandomPosition(boardSize/2, boardSize);
			tail = generateRandomPosition(1, boardSize);
			if(head > tail && positions.get(head) == null){
				positions.put(head, new Surprise(SurpriseType.SNAKE, tail));
			}else{
				i--;
			}
		}
	}
	private void fillLadderPositions(){
		int boardSize = BOARD_LENGTH * BOARD_WIDTH;
		int firstStep = 0;
		int lastStep = 0;
		for(int i = 0; i < NO_OF_LADDERS; i++){
			firstStep = generateRandomPosition(1, boardSize);
			lastStep = generateRandomPosition(boardSize/2, boardSize);
			if(lastStep > firstStep && positions.get(firstStep) == null){
				positions.put(firstStep, new Surprise(SurpriseType.LADDER, lastStep));
			}else{
				i--;
			}
		}
	}
	
	
	
	private int generateRandomPosition(int min, int max){
		return random.nextInt((max - min) + 1) + min;
	}

	public Map<Integer, Surprise> getPositions() {
		if(positions == null){
			populateGameBoard();
			printSnakeLadderPositions();
		}
		return positions;
	}
	
	public void printSnakeLadderPositions(){
		Map<Integer, Integer> snakes = new HashMap<>();
		Map<Integer, Integer> ladder = new HashMap<>();
		for(Map.Entry<Integer, Surprise> entry : positions.entrySet()){
			Integer key = entry.getKey();
			Surprise surprise = entry.getValue();
			if(surprise.getSurpriseType().equals(SurpriseType.LADDER)){
				ladder.put(key, surprise.getDestination());
			}else{
				snakes.put(key, surprise.getDestination());
			}
		}
		System.out.print("Snakes positions: ");
		for(Map.Entry<Integer, Integer> entry : snakes.entrySet()){
			System.out.print("[" + entry.getKey() + " --> " + entry.getValue() + "] ");
		}
		System.out.println();
		System.out.print("Ladder positions: ");
		for(Map.Entry<Integer, Integer> entry : ladder.entrySet()){
			System.out.print("[" + entry.getKey() + " --> " + entry.getValue() + "] ");
		}
		System.out.println();
	}
	
}
