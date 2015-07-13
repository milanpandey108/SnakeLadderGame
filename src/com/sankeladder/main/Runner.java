package com.sankeladder.main;

import com.sankeladder.domain.Dice;
import com.sankeladder.domain.GameBoard;
import com.sankeladder.domain.Player;
import com.sankeladder.runner.GameSnakeLadder;

public class Runner {

	public static void main(String[] args) {
		GameBoard board = new GameBoard();
		Dice dice = new Dice();
		GameSnakeLadder   game = new GameSnakeLadder(board, dice);
		
		Player p1 = new Player("Player_1", GameBoard.START);
		Player p2 = new Player("Player_2", GameBoard.START);
		
		game.playGame(p1, p2);
	}
	
}
