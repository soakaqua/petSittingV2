package petSittingBackVJpa;


import dao.DaoCompte;
import dao.DaoCompteFactory;
import model.Compte;
import java.util.ArrayList;
import java.util.List;

import dao.DaoAnnonce;
import dao.DaoAnnonceFactory;
import model.Annonce;
import util.JpaContext;

public class test {

	public static void main(String[] args) {
		JpaContext.getInstance(); 	//ne pas supprimer : sert à tester le fonctionnement de la liaison avec la base de donnée.

		// ------------------ Faite vos tests ici ! --------------------
		
		DaoCompte daoCompte = DaoCompteFactory.getInstance();
		
		Compte c = new Compte();
		c.setMail("1@1");
		c.setMdpC("1");
		daoCompte.insert(c);
		
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
		c2 = daoCompte.selectById(100);
		daoCompte.delete(c2);;

		
		
		// ------------------------ Fin tests ! ------------------------
		JpaContext.destroy(); // ne pas supprimer !
	}

}
