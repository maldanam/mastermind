package org.mastermind.codemaker.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Guess {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private CodePegEnum color1;
	private CodePegEnum color2;
	private CodePegEnum color3;
	private CodePegEnum color4;

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
	
}
