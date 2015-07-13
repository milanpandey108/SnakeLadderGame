package com.sankeladder.domain;

public class Player {
	
	protected String name;
	protected int curentPosition;
	boolean isRollingDice;
	
	
	public Player(String name, int curentPosition) {
		super();
		this.name = name;
		this.curentPosition = curentPosition;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurentPosition() {
		return curentPosition;
	}
	public void setCurentPosition(int curentPosition) {
		this.curentPosition = curentPosition;
	}

	public boolean isRollingDice() {
		return isRollingDice;
	}

	public void setRollingDice(boolean isRollingDice) {
		this.isRollingDice = isRollingDice;
	}
}
