package org.mastermind.codemaker.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class GuessResult {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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

}
