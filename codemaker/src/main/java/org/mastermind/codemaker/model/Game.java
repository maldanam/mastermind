package org.mastermind.codemaker.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="game-seq")
    @SequenceGenerator(name="game-seq", sequenceName="GAME_SEQ")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private GameStatusEnum status;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pattern_id")
    private Pattern pattern;

    @OneToMany(
            mappedBy = "game", 
            cascade = CascadeType.ALL, 
            orphanRemoval = true
        )
    private List<Turn> turns;

	public Game() {
		this.turns = new ArrayList<>();
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

	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		pattern.setGame(this);
		this.pattern = pattern;
	}

	public List<Turn> getTurns() {
		return turns;
	}

	public void setTurns(List<Turn> turns) {
		this.turns = turns;
	}
    
	public void addTurn(Turn aTurn) {
		this.turns.add(aTurn);
		aTurn.setGame(this);
	}
    
}
