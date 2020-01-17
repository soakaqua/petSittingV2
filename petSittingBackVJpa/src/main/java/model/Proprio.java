package model;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Query;

import dao.DaoAnnonce;
import dao.DaoAnnonceFactory;
import util.JpaContext;

@Entity
@DiscriminatorValue("P")
public class Proprio extends Compte {

	@OneToMany
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
	
	public static void publierAnnonce(String titre, String message, int numC, Set<Annonce_Service> annonce_service) { //probleme avec services
		DaoAnnonce daoAnnonce = DaoAnnonceFactory.getInstance(); 
		Annonce a=new Annonce(titre, message, numC,	annonce_service);
		daoAnnonce.insert(a);
	}
	
	public static void modifierContenuAnnonce(int numA, String titre, String message) { 
		DaoAnnonce daoAnnonce = DaoAnnonceFactory.getInstance(); 
		Annonce a=new Annonce();
		a.setNumA(a.getNumA());
		a.setTitre(titre);
		a.setMessage(message);
		a.setNoteP(a.getNoteP());
		a.setNoteS(a.getNoteS());
		a.setStatut(a.getStatut());
		a.setNumC(a.getNumC());
		a.setListService(a.getListService());
		daoAnnonce.update(a);
	} 
	
	public static void modifierServicesAnnonce(int numA, Set<Annonce_Service> annonce_service) { //probleme avec les services
		DaoAnnonce daoAnnonce = DaoAnnonceFactory.getInstance(); 
		Annonce a=new Annonce();
		a.setNumA(a.getNumA());
		a.setTitre(a.getTitre());
		a.setMessage(a.getMessage());
		a.setNoteP(a.getNoteP());
		a.setNoteS(a.getNoteS());
		a.setStatut(a.getStatut());
		a.setNumC(a.getNumC());
		a.setListService(annonce_service);
		daoAnnonce.update(a);
	} 
	
	
//	public void supprReponsesRefusees(Annonce a) {
//		DaoReponse daoReponse = DaoReponseFactory.getInstance();
//		EntityManager em = JpaContext.getInstance().createEntityManager();
//		int bonNumA=a.getNumA();
//		List<Reponse> reponses = null;
//		Query query = em.createQuery("from Reponse r where r.numA!=bonNumA");
//		reponses = query.getResultList();
//		doaReponse.delete(query);
//		em.close();
//	}
//	
//	public void validerSitter(Annonce a) {
//		DaoAnnonce daoAnnonce = DaoAnnonceFactory.getInstance();
//		DaoReponse daoReponse = DaoReponseFactory.getInstance();
//
//		a.setStatut(1);
//		daoAnnonce.update(a);
//		supprReponsesRefusees(a);
//
//	}
	
	

	
	
	
	public void noterS() {
		
	}


	
	
}
