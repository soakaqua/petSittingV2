package petSittingBackVJpa;

import dao.DaoService;
import dao.DaoServiceFactory;
import model.Service;


import java.util.ArrayList;
import java.util.List;


import util.JpaContext;

public class test {

	public static void main(String[] args) {
		JpaContext.getInstance(); 	//ne pas supprimer : sert à tester le fonctionnement de la liaison avec la base de donnée.

		// ------------------ Faite vos tests ici ! --------------------
//		/----- Test Insert --------
//        DaoCompte daoCompte = DaoCompteFactory.getInstance();
//        Compte c = new Compte();
//        c.setMail("1@1");
//        c.setMdpC("1");
//        daoCompte.insert(c);
//
//        //----- Test selectById --------
//        Compte c2 = new Compte();
//        c2 = daoCompte.selectById(100);
//        System.out.println(c2);
//
//        //----- Test update --------
//        c.setNom("toto");
//        daoCompte.update(c);
//
//        //----- Test selectAll --------
//        System.out.println(daoCompte.selectAll());

       
        //----- Test deleteById --------
//        daoCompte.delete(c2);;
		
		
		
		
		
		//----- Test Insert -------- c'est OKI!
//        DaoService daoService = DaoServiceFactory.getInstance();
//        Service s = new Service();
//        s.setNomSer("Garde chez proprio");
//        s.setPrix(10);
//        daoService.insert(s);

        //----- Test selectById --------PAS OKI! faut retester
//		DaoService daoService = DaoServiceFactory.getInstance();
//		Service s = new Service();
//        s =daoService.selectById(100); 
//        System.out.println(s);
	
        

        
//        ----- Test update -------- c'est OKI!
//		DaoService daoService = DaoServiceFactory.getInstance();
//		Service s = new Service();
//		s.setNomSer("Garde chez sitter");
//        s = daoService.update(s); 
		
		  //----- Test selectAll -------- c'est OKI!
      
//		DaoService daoService = DaoServiceFactory.getInstance();
//
//		System.out.println(daoService.selectAll());
		
		  //----- Test delete -------- oki!
      
//		DaoService daoService = DaoServiceFactory.getInstance();
//		Service s = new Service();
//		daoService.delete(s);
		//----- Test deleteById --------
     
		
		
//		daoService.deleteById(100);
		
        

		
        
        
       


		
		// ------------------------ Fin tests ! ------------------------
		JpaContext.destroy(); // ne pas supprimer !
	}

}
