package com.sankeladder.runner;

import com.sankeladder.domain.Dice;
import com.sankeladder.domain.GameBoard;
import com.sankeladder.domain.Player;
import com.sankeladder.domain.Surprise;
import com.sankeladder.enums.SurpriseType;

public class GameSnakeLadder {
	
	GameBoard gameBoard;
	Dice dice;
	
	
	
	public GameSnakeLadder(GameBoard board, Dice dice) {
		this.gameBoard = board;
		this.dice = dice;
	}


	public void playGame(Player p1, Player p2){
		int tossResult = toss();
	
		if(tossResult % 2 == 0){
			p1.setRollingDice(true);
		} else {
			p2.setRollingDice(true);
		}
		
		while(!isFinished(p1, p2)){
			if(p1.isRollingDice()){
				moveCoins(p1, dice.roll());
			} else {
				moveCoins(p2, dice.roll());
			}
			toggleChance(p1, p2);
			
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		showGameResult(p1, p2);
	}
	
	private void showGameResult(Player p1, Player p2) {
		Player winner = null;
		if(p1.getCurentPosition() >= GameBoard.END){
			winner = p1;
		} else {
			winner = p2;
		}
		System.out.println(winner.getName() + " won the game!! ");
	}


	private void toggleChance(Player p1, Player p2) {
		if(p1.isRollingDice()){
			p2.setRollingDice(true);
			p1.setRollingDice(false);
		} else{
			p1.setRollingDice(true);
			p2.setRollingDice(false);
		}
	}

	private void moveCoins(Player p, int diceOutput){
		int newPosition = p.getCurentPosition() + diceOutput;
		Surprise surprise = gameBoard.getPositions().get(newPosition);
		if (surprise != null){
			newPosition = surprise.getDestination();			
		}
		informUpOrDown(p, surprise, diceOutput);
		p.setCurentPosition(newPosition);
	}
	

	private void informUpOrDown(Player p, Surprise surprise, int diceOutput) {
		System.out.println(p.getName() + " is at: " +p.getCurentPosition() +" and got " + diceOutput);
		if(surprise == null){
			return;
		}
		int nextPosition = diceOutput + p.getCurentPosition();
		if(surprise.getSurpriseType().equals(SurpriseType.SNAKE)){
			System.out.println("Oops! " + p.getName() + " bitten by Snake at " + nextPosition  + ", and is now at: " 
							+ surprise.getDestination() + " <<----");
		} else {
			System.out.println("Yaay! " + p.getName() + " climbed Ladder  at " + nextPosition + ", and is now at: " 
							+ surprise.getDestination() + " ----->>");
		}
	}

	private int toss(){
		return dice.roll();
	}
	
	private boolean isFinished(Player p1, Player p2){
		if(p1.getCurentPosition() >= GameBoard.END || 
				p2.getCurentPosition() >= GameBoard.END){
			return true;
		}
		return false;
	}
}
