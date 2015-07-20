package com.snakeladder.domain;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.sankeladder.domain.GameBoard;
import com.sankeladder.domain.Surprise;
import com.sankeladder.enums.SurpriseType;

public class TestGameBoard {
	GameBoard board = new GameBoard();
	Map<Integer, Surprise> positions = board.getPositions();
	
	
	@Test
	public void test_gameboard_should_have_defined_no_of_surprises(){
		Assert.assertEquals(GameBoard.NO_OF_LADDERS + GameBoard.NO_OF_SNAKES, positions.size());
	}
	
	@Test
	public void test_gameboard_should_have_defined_no_of_snakes(){
		int snakes = 0;
		for(Map.Entry<Integer, Surprise> entry : positions.entrySet()){
			if(entry.getValue().getSurpriseType().equals(SurpriseType.SNAKE)){
				snakes++;
			}
		}
		Assert.assertEquals(GameBoard.NO_OF_SNAKES, snakes);
	}
	
	@Test
	public void test_gameboard_should_have_defined_no_of_ladders(){
		int ladders = 0;
		for(Map.Entry<Integer, Surprise> entry : positions.entrySet()){
			if(entry.getValue().getSurpriseType().equals(SurpriseType.LADDER)){
				ladders++;
			}
		}
		Assert.assertEquals(GameBoard.NO_OF_SNAKES, ladders);
	}
	
	@Test
	public void test_gameboard_should_have_snakes_placed_ok(){
		for(Map.Entry<Integer, Surprise> entry : positions.entrySet()){
			if(entry.getValue().getSurpriseType().equals(SurpriseType.SNAKE) 
					&& entry.getKey() < entry.getValue().getDestination()){
				Assert.fail("Snake head should be greater than tail");
			}
		}
	}

	@Test
	public void test_gameboard_should_have_ladders_placed_ok(){
		for(Map.Entry<Integer, Surprise> entry : positions.entrySet()){
			if(entry.getValue().getSurpriseType().equals(SurpriseType.LADDER) 
					&& entry.getKey() > entry.getValue().getDestination()){
				Assert.fail("Ladder climb position should be lower than its last step");
			}
		}
	}
}
