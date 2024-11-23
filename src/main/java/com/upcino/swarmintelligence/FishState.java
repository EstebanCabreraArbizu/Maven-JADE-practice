package com.upcino.swarmintelligence;

import java.awt.Color;

public class FishState {
	public int x;
	public int y;
	public int status;
	public Color color;
	public int size;
	
	public FishState(int x, int y, int status, Color color, int size) {
		this.x = x;
		this.y = y;
		this.status = status;
		this.color = color;
		this.size = size;
	}
}