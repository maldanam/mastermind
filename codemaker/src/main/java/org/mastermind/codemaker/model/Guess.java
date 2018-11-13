package org.mastermind.codemaker.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Guess {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="guess-seq")
    @SequenceGenerator(name="guess-seq", sequenceName="GUESS_SEQ")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private CodePegEnum color1;
    
    @Enumerated(EnumType.STRING)
	private CodePegEnum color2;
    
    @Enumerated(EnumType.STRING)
	private CodePegEnum color3;
    
    @Enumerated(EnumType.STRING)
	private CodePegEnum color4;
	
	public Guess() {
	}

	public Guess(CodePegEnum color1, CodePegEnum color2, CodePegEnum color3, CodePegEnum color4) {
		this.color1 = color1;
		this.color2 = color2;
		this.color3 = color3;
		this.color4 = color4;
	}

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "turn_id")
	private Turn turn;
	
	public CodePegEnum getColor1() {
		return color1;
	}
	public void setColor1(CodePegEnum color1) {
		this.color1 = color1;
	}
	public CodePegEnum getColor2() {
		return color2;
	}
	public void setColor2(CodePegEnum color2) {
		this.color2 = color2;
	}
	public CodePegEnum getColor3() {
		return color3;
	}
	public void setColor3(CodePegEnum color3) {
		this.color3 = color3;
	}
	public CodePegEnum getColor4() {
		return color4;
	}
	public void setColor4(CodePegEnum color4) {
		this.color4 = color4;
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
