package org.mastermind.board.dto;

import org.mastermind.model.CodePegEnum;
import org.mastermind.model.Guess;

public class GuessDto {

    private CodePegEnum color1;
    
	private CodePegEnum color2;
    
	private CodePegEnum color3;
    
	private CodePegEnum color4;
	
	public GuessDto(Guess guess) {
		this.color1 = guess.getColor1();
		this.color2 = guess.getColor2();
		this.color3 = guess.getColor3();
		this.color4 = guess.getColor4();
	}

	public CodePegEnum getColor1() {
		return color1;
	}

	public CodePegEnum getColor2() {
		return color2;
	}

	public CodePegEnum getColor3() {
		return color3;
	}

	public CodePegEnum getColor4() {
		return color4;
	}

}
