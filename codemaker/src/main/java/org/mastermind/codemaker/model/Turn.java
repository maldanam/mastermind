package org.mastermind.codemaker.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Turn {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guess_id")
	private Guess turnGuess;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id")
	private GuessResult turnGuessResult;
	
	public Guess getTurnGuess() {
		return turnGuess;
	}
	public void setTurnGuess(Guess turnGuess) {
		this.turnGuess = turnGuess;
	}
	public GuessResult getTurnGuessResult() {
		return turnGuessResult;
	}
	public void setTurnGuessResult(GuessResult turnGuessResult) {
		this.turnGuessResult = turnGuessResult;
	}
	
}
