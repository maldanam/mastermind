package org.mastermind.codemaker.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="game-seq")
    @SequenceGenerator(name="game-seq", sequenceName="GAME_SEQ")
    private Integer id;

    private GameStatusEnum status;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pattern_id")
    private Pattern pattern;

//    private List<Turn> turns;

	public Game() {
//		this.turns = new ArrayList<>();
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
		this.pattern = pattern;
	}

//	public List<Turn> getTurns() {
//		return turns;
//	}
//
//	public void setTurns(List<Turn> turns) {
//		this.turns = turns;
//	}
    
}
