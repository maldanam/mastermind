package org.mastermind.board.dto;

import org.mastermind.model.Turn;

public class TurnDto {
	
	private GuessDto guess;
	
	private GuessResultDto result;

	public TurnDto(Turn turn) {
		this.guess = new GuessDto(turn.getTurnGuess());
		this.result = new GuessResultDto(turn.getTurnGuessResult());
	}
	
	public GuessDto getGuess() {
		return guess;
	}

	public GuessResultDto getResult() {
		return result;
	}

}
