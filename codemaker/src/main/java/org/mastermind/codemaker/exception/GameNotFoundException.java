package org.mastermind.codemaker.exception;

public class GameNotFoundException extends Exception {
	
	public GameNotFoundException() {
		super("The game does not exist.");
	}

}
