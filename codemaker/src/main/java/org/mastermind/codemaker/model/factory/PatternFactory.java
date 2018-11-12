package org.mastermind.codemaker.model.factory;

import java.util.Random;

import org.mastermind.codemaker.model.Pattern;
import org.mastermind.codemaker.model.CodePegEnum;

public class PatternFactory {
	
	public static Pattern create() {
		Pattern result;
		
		result = new Pattern();
		result.setColor1(randomColor());
		result.setColor2(randomColor());
		result.setColor3(randomColor());
		result.setColor4(randomColor());
		
		return result;
	}

	private static CodePegEnum randomColor() {
		return CodePegEnum.values()[new Random().nextInt(CodePegEnum.values().length)];
	}
}
