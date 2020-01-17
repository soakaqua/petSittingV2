package dao;

public class DaoReponseFactory {

private static DaoReponse daoReponse= null;
	
	public static DaoReponse getInstance()
	{
		if(daoReponse == null)
		{
			daoReponse = new DaoReponseJpaImpl();
		}
		return new DaoReponseJpaImpl ();
	}

	
	
	
	
	
}
