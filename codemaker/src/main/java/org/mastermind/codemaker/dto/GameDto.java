package org.mastermind.codemaker.dto;

import org.mastermind.model.Game;
import org.mastermind.model.GameSpec;
import org.mastermind.model.GameStatusEnum;

public class GameDto {

    private Integer id;

    private GameStatusEnum status;
    
    private GameSpec configuration;

    public GameDto(Game aGame) {
    	this.id = aGame.getId();
    	this.status = aGame.getStatus();
	}
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GameStatusEnum getStatus() {
		return status;
	}

	public void setStatus(GameStatusEnum status) {
		this.status = status;
	}

	public GameSpec getConfiguration() {
		return configuration;
	}

	public void setConfiguration(GameSpec configuration) {
		this.configuration = configuration;
	}
    
}
