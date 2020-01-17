package model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ReponsePK implements Serializable {
	
	@ManyToOne
	@JoinColumn(name = "compte_numc", foreignKey =@ForeignKey(name="reponse_compte_numc_fk"))
	private Compte compte;
	
	@ManyToOne
	@JoinColumn(name ="annonce_numa", foreignKey = @ForeignKey(name ="reponse_annonce_numa_fk"))
	private Annonce annonce;
	
	public ReponsePK() {
		
	}

	public ReponsePK(Compte compte, Annonce annonce) {
		super();
		this.compte = compte;
		this.annonce = annonce;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annonce == null) ? 0 : annonce.hashCode());
		result = prime * result + ((compte == null) ? 0 : compte.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReponsePK other = (ReponsePK) obj;
		if (annonce == null) {
			if (other.annonce != null)
				return false;
		} else if (!annonce.equals(other.annonce))
			return false;
		if (compte == null) {
			if (other.compte != null)
				return false;
		} else if (!compte.equals(other.compte))
			return false;
		return true;
	}
	
	
	
	
	
	
}
