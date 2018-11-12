package org.mastermind.codemaker.dto;

import org.mastermind.codemaker.model.GuessResult;

public class GuessResultDto {

	private Integer numBlacks;
	private Integer numWhites;

	public GuessResultDto(GuessResult entity) {
		this.numBlacks = entity.getNumBlacks();
		this.numWhites = entity.getNumWhites();
	}
	
	public Integer getNumBlacks() {
		return numBlacks;
	}
	public void setNumBlacks(Integer numBlacks) {
		this.numBlacks = numBlacks;
	}
	public Integer getNumWhites() {
		return numWhites;
	}
	public void setNumWhites(Integer numWhites) {
		this.numWhites = numWhites;
	}

}
