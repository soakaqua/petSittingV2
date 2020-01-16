package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("P")
public class Proprio extends Compte {

	public Proprio(Integer numC, Integer cp, String mdpC, String mail, String nom, String prenom) {
	}
	
	public Proprio() {
		
	}


	//Consulter mes annonces
	//afficherAnnoncesPubliees(numC)
	

	
	
	
	
}
