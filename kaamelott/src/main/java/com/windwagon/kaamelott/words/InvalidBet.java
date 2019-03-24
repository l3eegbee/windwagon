package com.windwagon.kaamelott.words;

public class InvalidBet extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidBet(String message) {
		super("Invalid bet: " + message);
	}

}
