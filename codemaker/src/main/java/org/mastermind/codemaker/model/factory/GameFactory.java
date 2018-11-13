package org.mastermind.codemaker.model.factory;

import org.mastermind.codemaker.model.Game;
import org.mastermind.codemaker.model.GameSpec;
import org.mastermind.codemaker.model.GameStatusEnum;

public class GameFactory {
	
	public static GameSpec getCurrentConfig() {
		return new GameSpec();
	}
	
	public static Game create() {
		Game result = new Game();
		
		result.setStatus(GameStatusEnum.CREATED);
		result.setPattern(PatternFactory.create());
		result.setMaxTurns(getCurrentConfig().getMaxTurns());
		
		return result;
	}
}
