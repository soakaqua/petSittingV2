package dao;



public class DaoAnnonceFactory {

	private static DaoAnnonce daoAnnonce=null;
	public static DaoAnnonce getInstance() {
		if (daoAnnonce==null) {
		daoAnnonce = new DaoAnnonceJpaImpl();}
		return daoAnnonce;
	}
}
