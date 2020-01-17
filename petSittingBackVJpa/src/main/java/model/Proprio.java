package model;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import dao.DaoAnnonce;
import dao.DaoAnnonceFactory;

@Entity
@DiscriminatorValue("P")
public class Proprio extends Compte {

	@OneToMany(mappedBy = "proprio")
	@JoinColumn(name="proprio_annonce",foreignKey=@ForeignKey(name="proprio_annonce_fk"))
	private Set<Annonce> annonces;	
	
	public Proprio(Integer numC, Integer cp, String mdpC, String mail, String nom, String prenom) {
	}
	
	public Proprio() {	
	}

//-----------------------------METHODES--------------------------------------
	
	public List<Annonce> afficherAnnoncesPubliees(Integer numC) {
		DaoAnnonce daoAnnonce = DaoAnnonceFactory.getInstance(); 
		List<Annonce> list = new ArrayList();
		list =daoAnnonce.selectAnnonceByProprio(numC);
		System.out.println(list); // a enlever ?
		return list;
	}
	
	public static void publierAnnonce(String titre, String message, int numC, Set<Annonce_Service> annonce_service) {
		DaoAnnonce daoAnnonce = DaoAnnonceFactory.getInstance(); 
		Annonce a=new Annonce(titre, message, numC,	annonce_service);
		daoAnnonce.insert(a);
	}
	
	public static void modifierAnnonce(int numA, String titre, String message, Set<Annonce_Service> annonce_service) {
		DaoAnnonce daoAnnonce = DaoAnnonceFactory.getInstance(); 
		Annonce a=new Annonce(numA, titre, message, annonce_service);
		a.setTitre(titre);
		a.setMessage(message);
		a.setListService(annonce_service);
		daoAnnonce.update(a);
	} 
	

	public void validerSitter(Integer numC) {
		DaoAnnonce daoAnnonce = DaoAnnonceFactory.getInstance();
		List<Annonce> list=afficherAnnoncesPubliees(numC);
		
//		DaoReponse daoReponse = DaoReponseFactory.getInstance();
//		Annonce annSelec= new Annonce();
//		annSelec=//choix de l'utilisateur
//		selectReponseByNumA();
//		
//		annSelec.setStatut(1);
//		daoAnnonce.update(annSelec);

	}
	
	public void noterS() {
		
	}


	
	
}
