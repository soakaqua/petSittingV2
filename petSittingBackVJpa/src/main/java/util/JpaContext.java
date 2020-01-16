package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaContext { //On construit la factory pour l'emf. pour qu'il n'y en ai qu'un à tout instant. l'emf est en static pour etre dispo partout dans le projet.

		private static EntityManagerFactory emf = null;
		
		public static EntityManagerFactory getInstance() {
			if(emf==null) {
			emf = Persistence.createEntityManagerFactory("petSittingBackVJpa");
			}
				return emf;
			
		}
		
		public static void destroy() {
			if(emf!=null) {
				emf.close();
				emf = null;
			}
		}
		
}
