package petSittingBackVJpa;

<<<<<<< HEAD
import dao.DaoCompte;
import dao.DaoCompteFactory;
import model.Compte;
=======
import java.util.ArrayList;
import java.util.List;

import dao.DaoAnnonce;
import dao.DaoAnnonceFactory;
import model.Annonce;
>>>>>>> 2cd3bd3941226ae351a5191e9d412f6bfe39b013
import util.JpaContext;

public class test {

	public static void main(String[] args) {
		JpaContext.getInstance(); 	//ne pas supprimer : sert à tester le fonctionnement de la liaison avec la base de donnée.

		// ------------------ Faite vos tests ici ! --------------------
		
<<<<<<< HEAD
		
		//----- Test Insert --------
		DaoCompte daoCompte = DaoCompteFactory.getInstance();
		Compte c = new Compte();
		c.setMail("1@1");
		c.setMdpC("1");
		daoCompte.insert(c);
=======
		//----- Test Insert --------
        DaoAnnonce daoAnnonce = DaoAnnonceFactory.getInstance();
        Annonce c = new Annonce();
        c.setMsg("msg test");
        c.setTitre("titre test");
        c.setNumC(10);
        c.setStatut(0);

        daoAnnonce.insert(c);
        
        //----- Test selectAnnonceByProprio --------
       
//      List<Annonce> c2 = new ArrayList();
//      c2 =daoAnnonce.selectAnnonceByProprio(10);
//      System.out.println(c2);
        
        //----- Test afficherAnnoncesTerminees --------
        
      List<Annonce> c2 = new ArrayList();
      c2 =daoAnnonce.selectAnnonceByProprio(10);
      System.out.println(c2);       
        
        
        //----- Test selectAnnonceBySitter --------
        
        

        //----- Test selectById --------
//        Annonce c2 = new Annonce();
//        c2 = daoAnnonce.selectById(100);
//        System.out.println(c2.getTitre());

        //----- Test update --------
//        c.setTitre("toto");
//        c = daoAnnonce.update(c);
//        System.out.println(c.getTitre());

        //----- Test selectAll --------
//        System.out.println(daoAnnonce.selectAll());

        //----- Test deleteById --------
//        daoAnnonce.deleteById(100);

        //----- Test deleteById --------
//        daoCompte.delete(c2);;
>>>>>>> 2cd3bd3941226ae351a5191e9d412f6bfe39b013
		
		//----- Test selectById --------
		Compte c2 = new Compte();
		c2 = daoCompte.selectById(100);
		System.out.println(c2);
		
		//----- Test update --------
		c.setNom("toto");
		c = daoCompte.update(c);
		System.out.println(c.getNom());
		//----- Test selectAll --------
		System.out.println(daoCompte.selectAll());
		
		//----- Test deleteById --------
//		daoCompte.deleteById(100);
		
		//----- Test deleteById --------
		daoCompte.delete(c2);;
		
		
		// ------------------------ Fin tests ! ------------------------
		JpaContext.destroy(); // ne pas supprimer !
	}

}
