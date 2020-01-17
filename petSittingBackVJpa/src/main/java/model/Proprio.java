package model;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import dao.DaoAnnonce;
import dao.DaoAnnonceFactory;

@Entity
@DiscriminatorValue("P")
public class Proprio extends Compte {

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
	
	public void publierAnnonce(String titre, String msg, int numC, List<Service> listService) {
		DaoAnnonce daoAnnonce = DaoAnnonceFactory.getInstance(); 
		Annonce a=new Annonce(titre, msg, numC,	listService);
		daoAnnonce.insert(a);
	} //numA à entrer ?
	
	public void modifierAnnonce(int numA, String titre, String msg, int numC, List<Service> listService) {
		DaoAnnonce daoAnnonce = DaoAnnonceFactory.getInstance(); 
		Annonce a=new Annonce(numA, titre, msg, numC, listService);
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
