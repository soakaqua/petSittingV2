package petSittingBackVJpa;

<<<<<<< HEAD
import dao.DaoService;
import dao.DaoServiceFactory;
import model.Service;
=======

import dao.DaoCompte;
import dao.DaoCompteFactory;
import model.Compte;
import java.util.ArrayList;
import java.util.List;

import dao.DaoAnnonce;
import dao.DaoAnnonceFactory;
import model.Annonce;
>>>>>>> master
import util.JpaContext;

public class test {

	public static void main(String[] args) {
		JpaContext.getInstance(); 	//ne pas supprimer : sert à tester le fonctionnement de la liaison avec la base de donnée.

		// ------------------ Faite vos tests ici ! --------------------
		
		//----- Test Insert --------
//        DaoService daoService = DaoServiceFactory.getInstance();
//        Service s = new Service();
//        s.setNomSer("Garde chez propriétaire");
//        s.setPrix(10);
//        daoService.insert(s);

        //----- Test selectById --------
//        Service s2 = new Service();
//        s2 =DaoService.selectById(100);
//        System.out.println(s2);

//        ----- Test update --------
//		DaoService daoService = DaoServiceFactory.getInstance();
//		Service s = new Service();
//		s.setNomSer("Garde chez sitter");
//        DaoService.update(s);

		
		//----- Test Insert --------
		DaoCompte daoCompte = DaoCompteFactory.getInstance();
		Compte c = new Compte();
		c.setMail("1@1");
		c.setMdpC("1");
		daoCompte.insert(c);

		
<<<<<<< HEAD
		DaoService daoService = DaoServiceFactory.getInstance();
		Service s = new Service();
		s.setNomSer("Garde chez sitter");
        daoService.update(s); 
        

		
        
        
        //----- Test selectAll --------
       // System.out.println(daoCompte.selectAll());

        //----- Test deleteById --------
//        daoCompte.deleteById(100);

        //----- Test deleteById --------
//        daoCompte.delete(c2);;

		
=======
		//----- Test selectById --------
		Compte c2 = new Compte();
		c2 = daoCompte.selectById(100);
		System.out.println(c2);
>>>>>>> master
		
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
