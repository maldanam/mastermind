package org.mastermind.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "guess_result")
public class GuessResult {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="guess-result-seq")
    @SequenceGenerator(name="guess-result-seq", sequenceName="GUESS_RESULT_SEQ")
    private Integer id;

	private Integer numBlacks;
	private Integer numWhites;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "turn_id")
	private Turn turn;

    public GuessResult() {
		this.numBlacks = 0;
		this.numWhites = 0;
	}
	public GuessResult(KeyPegEnum[] keys) {
		this();
		for(KeyPegEnum aKey : keys) {
			if (aKey != null) {
				switch(aKey) {
				case BLACK:
					this.numBlacks++;
					break;
				case WHITE:
					this.numWhites++;
					break;
				}
			}
		}
	}
	public Integer getNumBlacks() {
		return numBlacks;
	}
	public void setNumBlacks(Integer numBlacks) {
		this.numBlacks = numBlacks;
	}
	public Integer getNumWhites() {
		return numWhites;
	}
	public void setNumWhites(Integer numWhites) {
		this.numWhites = numWhites;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Turn getTurn() {
		return turn;
	}
	public void setTurn(Turn turn) {
		this.turn = turn;
	}

}
