package com.casino.model;

public class Card {

	private String rango;
	private String seme;
	private int value;
	
	public Card(String rango, String seme, int value) {
		super();
		this.rango = rango;
		this.seme = seme;
		this.value = value;
	}

	public String getRango() {
		return rango;
	}

	public String getSeme() {
		return seme;
	}

	public int getValue() {
		return value;
	}
	
	
}
