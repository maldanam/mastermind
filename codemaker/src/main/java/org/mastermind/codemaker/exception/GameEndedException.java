package org.mastermind.codemaker.exception;

public class GameEndedException extends Exception {

	public GameEndedException() {
		super("The game has already ended.");
	}
}
