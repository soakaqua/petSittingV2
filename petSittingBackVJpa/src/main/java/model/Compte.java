package model;

import java.sql.SQLException;
import java.util.InputMismatchException;

import model.*;
import dao.*;

public class Compte {
	protected Integer numC, cp;
	protected String mdpC, mail,statut;
	
	public Compte(Integer numC, String mail, String mdpC, Integer cp, String statut) {
		this.numC = numC;
		this.cp = cp;
		this.mdpC = mdpC;
		this.mail = mail;
		this.statut = statut;
		
	}
	public Compte(String mail, String mdpC, Integer cp) {
		
		this.cp = cp;
		this.mdpC = mdpC;
		this.mail = mail;
		this.statut = "non validé";
	}

	

	public Integer getNumC() {
		return numC;
	}
	public void setNumC(Integer numC) {
		this.numC = numC;
	}
	public Integer getCp() {
		return cp;
	}
	public void setCp(Integer cp) {
		this.cp = cp;
	}
	public String getMdpC() {
		return mdpC;
	}
	public void setMdpC(String mdpC) {
		this.mdpC = mdpC;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	

	@Override
	public String toString() {
		return "Compte [numC=" + numC + ", cp=" + cp + ", mdpC=" + mdpC + ", mail=" + mail + ", statut=" + statut + "]";
	}
	

//	public void gestCompte(Integer id) throws ClassNotFoundException, SQLException {
//		//Permet de modifier mdp, mail, adresses.
//		int choix = 0;
//		System.out.println("Bienvenue sur votre menu gestion de compte !");
//		System.out.println("Que voulez vous faire ?");
//		System.out.println("1 - Modifier votre mot de passe");
//		System.out.println("2 - Modifier votre mail");
//		System.out.println("3 - Modifier votre code postal");
//		
//		try {
//			choix = Main.saisieInt("Entrez le nombre correspondant à votre choix");
//		}catch(InputMismatchException e) {System.out.println("Merci de saisir un chiffre !");gestCompte(id);}
//		
//		DAOCompte daoC=new DAOCompte();
//		//try {
//		Compte c = daoC.selectById(id);
//
//		switch(choix)
//		{case 1: 
//			String str1 = Main.saisieString("Entrez votre nouveau mot de passe"); 
//			c.setMdpC(str1);
//			daoC.update(c);
//			break;
//		case 2: 
//			String str2 = Main.saisieString("Entrez votre nouveau mail"); 
//			c.setMail(str2);
//			daoC.update(c);
//			break;
//		case 3: 
//		int int1 = Main.saisieInt("Entrez votre nouveau code postal"); 
//		c.setCp(int1);
//		daoC.update(c);
//		break;
//		default : System.out.println("Choix invalide");gestCompte(id);
//		}
//		//}catch(Exception e) {System.out.println("PB gestion compte");}
//
//	}
	
	
}