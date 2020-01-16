package petSittingBackVJpa;

import dao.DaoService;
import dao.DaoServiceFactory;
import model.Service;
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

		
		
		
		
		
		
		
		
		// ------------------------ Fin tests ! ------------------------
		JpaContext.destroy(); // ne pas supprimer !
	}

}
