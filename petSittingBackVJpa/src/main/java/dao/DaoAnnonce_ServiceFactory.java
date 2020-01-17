package dao;



public class DaoAnnonce_ServiceFactory {

	private static DaoAnnonce_Service daoAnnonce_Service=null;
	public static DaoAnnonce_Service getInstance() {
		if (daoAnnonce_Service==null) {
		daoAnnonce_Service = new DaoAnnonce_ServiceJpaImpl();}
		return daoAnnonce_Service;
	}
}
