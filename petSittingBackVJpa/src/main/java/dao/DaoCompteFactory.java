package dao;

public class DaoCompteFactory { //singleton car variable en static et getInstance prend en cmpte l'existance de daoPersonne

	private static DaoCompte daoCompte = null;


	public static DaoCompte getInstance() {
		if(daoCompte ==null) {
			return new DaoCompteJpaImpl();
		}
		return daoCompte;
	}

}
