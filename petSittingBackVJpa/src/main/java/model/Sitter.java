package model;





import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.OneToMany;
import javax.persistence.Query;

import dao.DaoAnnonce;
import dao.DaoAnnonceFactory;
import util.JpaContext;



@Entity
@DiscriminatorValue("S")
public class Sitter extends Compte {

	@OneToMany(mappedBy = "key.sitter") //erreur bidon ici
	private Set<Reponse> réponses;
	
	public Sitter(Integer numC, Integer cp, String mdpC, String mail, String nom, String prenom) {
	}

	public Sitter() {

	}

	
	

	
	
	
//	public List<Annonce> selectAnnonceBySitter(Integer numC)  { // afficherAnnoncesPostulees(); Consulter mes annonces SITTER
//		EntityManager em=JpaContext.getInstance().createEntityManager();
//		List<Annonce> annonces=null;
//		Query query=em.createQuery("select distinct a from Annonce a left join fetch a.Reponse rep where rep.numC=:numC");  
//		query.setParameter("numC", numC);
//		annonces=query.getResultList();
//		em.close();
//		return annonces;
//	}
//	

	
	//----- Test selectAnnonceBySitter --------
	
//	
//	public void afficherAnnoncesPostulees() {
//	DaoAnnonce daoAnnonce = DaoAnnonceFactory.getInstance(); //appeller methode selectAnnonceBySitter
//	List<Annonce> a = (List<Annonce>) new Annonce();
//    a =daoAnnonce.selectAnnonceBySitter(100); //class.methode
//   System.out.println(a);
//	}
//	
	
	
    //----- Test selectById --------c'est OKI!
//	DaoService daoService = DaoServiceFactory.getInstance();
//	Service s = new Service();
//    s =daoService.selectById(100); //class.methode
//    System.out.println(s);
	
	
	
	
	
	//----- Test Insert -------- c'est OKI!
//    DaoService daoService = DaoServiceFactory.getInstance();
//    Service s = new Service();
//    s.setNomSer("Garde chez proprio");
//    s.setPrix(10);
//    daoService.insert(s);
//    Service s2 = new Service();
//    s2.setNomSer("Garde chez sitter");
//    s2.setPrix(15);
//    daoService.insert(s2);

	
}
