package org.mastermind.model;

import java.util.ArrayList;
import java.util.List;

public class GameSpec {

	private final Integer holes = 4;
	private final Integer maxTurns = 12;
	private List<CodePegEnum> colors;
	
	public GameSpec() {
		this.colors = new ArrayList<>();
		for (CodePegEnum aCodePeg : CodePegEnum.values()) {
			this.colors.add(aCodePeg);
		}
	}
	
	public Integer getHoles() {
		return holes;
	}

	public Integer getMaxTurns() {
		return maxTurns;
	}

	public List<CodePegEnum> getColors() {
		return colors;
	}
	
}
