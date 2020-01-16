package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
//@DiscriminatorValue("P")
public class Proprio extends Compte {

	public Proprio(Integer numC, String mail, String mdpC, Integer cp, String statut) {
		super(numC, mail, mdpC, cp, statut);
	}
	
//	public Proprio() {
//		
//	}


	
	
	
	
}
