package org.mastermind.board.dto;

import org.mastermind.model.GuessResult;

public class GuessResultDto {

	private Integer numBlacks;
	
	private Integer numWhites;

	public GuessResultDto(GuessResult result) {
		this.numBlacks = result.getNumBlacks();
		this.numWhites = result.getNumWhites();
	}

	public Integer getNumBlacks() {
		return numBlacks;
	}

	public Integer getNumWhites() {
		return numWhites;
	}
}
