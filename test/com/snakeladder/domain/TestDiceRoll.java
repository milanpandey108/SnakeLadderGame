package com.snakeladder.domain;

import org.junit.Assert;
import org.junit.Test;

import com.sankeladder.domain.Dice;

public class TestDiceRoll {
	
	
	@Test
	public void test_dice_should_return_one_to_six_only(){
		Dice dice = new Dice();
		for(int i = 0; i < 100000; i++){
			if(dice.roll() > 6 || dice.roll() < 1){
				Assert.fail("Wrong Dice output");
			}
		}
	}

}
