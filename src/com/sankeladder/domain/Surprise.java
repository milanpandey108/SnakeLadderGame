package com.sankeladder.domain;

import com.sankeladder.enums.SurpriseType;

public class Surprise {

	protected SurpriseType surpriseType;
	protected int destination;
	
	public Surprise(SurpriseType surpriseType, int destination) {
		this.surpriseType = surpriseType;
		this.destination = destination;
	}
	
	public SurpriseType getSurpriseType() {
		return surpriseType;
	}
	public void setSurpriseType(SurpriseType surpriseType) {
		this.surpriseType = surpriseType;
	}
	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
	
}
