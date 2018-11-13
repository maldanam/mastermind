package org.mastermind.board.dto;

import java.util.ArrayList;
import java.util.List;

import org.mastermind.model.Game;
import org.mastermind.model.GameStatusEnum;
import org.mastermind.model.Turn;

public class GameDto {

    private Integer id;

    private GameStatusEnum status;
    
    private Integer maxTurns;
    
    private List<TurnDto> turns;
    
    public GameDto(Game aGame) {
    	this.id = aGame.getId();
    	this.status = aGame.getStatus();
    	this.maxTurns = aGame.getMaxTurns();
    	this.turns = new ArrayList<>();
    	for (Turn aTurn : aGame.getTurns()) {
    		this.turns.add(new TurnDto(aTurn));
    	}
	}
    
	public Integer getId() {
		return id;
	}

	public GameStatusEnum getStatus() {
		return status;
	}

	public Integer getMaxTurns() {
		return maxTurns;
	}

	public List<TurnDto> getTurns() {
		return turns;
	}

}
