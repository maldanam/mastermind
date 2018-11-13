package org.mastermind.codemaker.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Turn {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="turn-seq")
    @SequenceGenerator(name="turn-seq", sequenceName="TURN_SEQ")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guess_id")
	private Guess turnGuess;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id")
	private GuessResult turnGuessResult;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;

    public Turn() {
	}
	public Turn(Guess guess, GuessResult guessResult) {
		guess.setTurn(this);
		guessResult.setTurn(this);
		this.turnGuess = guess;
		this.turnGuessResult = guessResult;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	
}
