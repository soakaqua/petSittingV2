package model;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import dao.DaoAnnonce;
import dao.DaoAnnonceFactory;


@Entity
@Table(name="annonce")
@SequenceGenerator(name="seqAnnonce",sequenceName="seq_annonce",initialValue=100,allocationSize=1) 
public class Annonce {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqAnnonce") 
	private int numA ;
	@Column(length=500,nullable=false)
	private String titre;
	@Column(length=1000,nullable=false, name="message")
	private String message;
	@Column
	private Double noteP;
	@Column
	private Double noteS;
	@Column
	private int statut;
	@Column
	private int numC;
	@Column(name="key")
	@OneToMany(mappedBy="key.annonce") //fausse erreur. Coonexion virtuelle, ne modifie pas la table
	private Set<Annonce_Service> annonce_service;
	@Column(name="key")
	@OneToMany(mappedBy="key.annonce") //fausse erreur. Coonexion virtuelle, ne modifie pas la table
	private Set<Reponse> reponse;
	
	@ManyToOne
	private Proprio proprio;

	@Version
	private int version;
	
	public Annonce() {
		
	}
	
	public Annonce(String titre, String message, int numC, Set<Annonce_Service> listService) {
		this.titre = titre;
		this.message = message;
		this.statut = 0;
		this.numC = numC;
		this.annonce_service = null;
	}
	
	public Annonce(int numA, String titre, String message, Set<Annonce_Service> listService) {
		this.numA = numA;
		this.titre = titre;
		this.message = message;
		this.statut = 0;
		this.annonce_service = null;
	} 

	public Annonce(int numA, String titre, String message, Double noteP, Double noteS, int statut, int numC,
			Set<Annonce_Service>  annonce_service) {
		this.numA = numA;
		this.titre = titre;
		this.message = message;
		this.noteP = noteP;
		this.noteS = noteS;
		this.statut = 0;
		this.numC = numC;
		this.annonce_service = null;
	}

	public int getNumA() {
		return numA;
	}

	public void setNumA(int numA) {
		this.numA = numA;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Double getNoteP() {
		return noteP;
	}

	public void setNoteP(Double noteP) {
		this.noteP = noteP;
	}

	public Double getNoteS() {
		return noteS;
	}

	public void setNoteS(Double noteS) {
		this.noteS = noteS;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public int getNumC() {
		return numC;
	}

	public void setNumC(int numC) {
		this.numC = numC;
	}

	public Set<Annonce_Service>  getListService() {
		return annonce_service;
	}

	public void setListService(Set<Annonce_Service>  annonce_service) {
		this.annonce_service = annonce_service;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numA;
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
		Annonce other = (Annonce) obj;
		if (numA != other.numA)
			return false;
		return true;
	}
	
	
	
}
