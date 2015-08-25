package org.zoyi.po;

import java.util.Set;

public class Client extends Users{
    private Set journals;
    public Set getJournals() {
		return journals;
	}
	public void setJournals(Set journals) {
		this.journals = journals;
	}
	public Set getSignitures() {
		return signitures;
	}
	public void setSignitures(Set signitures) {
		this.signitures = signitures;
	}
	public Set getLetters() {
		return letters;
	}
	public void setLetters(Set letters) {
		this.letters = letters;
	}
	private Set signitures;
    private Set letters;
}
