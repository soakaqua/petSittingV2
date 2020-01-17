package model;

<<<<<<< HEAD
=======



import java.util.Set;

>>>>>>> master
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;



@Entity
@DiscriminatorValue("S")
public class Sitter extends Compte {

	@OneToMany(mappedBy = "key.sitter") //erreur bidon ici
	private Set<Reponse> réponses;
	
	public Sitter(Integer numC, Integer cp, String mdpC, String mail, String nom, String prenom) {
	}

	public Sitter() {

	}

	
}
