package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Compte;
import util.JpaContext;

class DaoCompteJpaImpl implements DaoCompte{ //pas de public : class visible uniquement dans le package (visibilit� par d�faut) (classe peut �tre public ou package)

	@Override
	public Compte selectById(Integer key) {
		EntityManager em = JpaContext.getInstance().createEntityManager();
		Compte c = null;
		c = em.find(Compte.class, key); //.class parce qu'il faut lui dire que c'est la classe qui nous int�resse.
		em.close();
		return c;
	}

	@Override
	public List<Compte> selectAll() {
		EntityManager em = JpaContext.getInstance().createEntityManager();
		Query query = em.createQuery("select c from Compte c"); //attention : requete jpql ! et non mysql (mais m�me mot clefs); attention : derriere from : pas de table mais une classe ! 
//		Query query = em.createQuery("from Personne p"); //idem 
		
		//		query.getSingleResult() // si un seul r�sultat (pas 0, pas 2)
		List<Compte> comptes = query.getResultList();
		
		return comptes;
	}

	@Override
	public void insert(Compte obj) {
		// TODO Auto-generated method stub
		EntityManager em = JpaContext.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx= em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();

		}catch(Exception e) {
			if(tx != null && tx.isActive()) //v�rifier que �a sert d'annuler la transaction (�vite les cascades d'erreur)
			{ 
				tx.rollback();
			}
			e.printStackTrace();
		}finally { // s'execute dans tous les cas (catch d�clench� ou non)
			if(em!=null && em.isOpen()){
				em.close();
			}
		}

	}

	@Override
	public Compte update(Compte obj) {
		EntityManager em = JpaContext.getInstance().createEntityManager();
		EntityTransaction tx = null;
		Compte c = null;
		try {
			tx= em.getTransaction();
			tx.begin();
			c= em.merge(obj);
			tx.commit();

		}catch(Exception e) {
			if(tx != null && tx.isActive()){ //v�rifier que �a sert d'annuler la transaction (�vite les cascades d'erreur)
				tx.rollback();
			}
			e.printStackTrace();
		}finally { // s'execute dans tous les cas (catch d�clench� ou non)
			if(em!=null && em.isOpen()){
				em.close();
			}
		}
		return c;

	}

	@Override
	public void delete(Compte obj) {
		EntityManager em = JpaContext.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx= em.getTransaction();
			tx.begin();
			em.remove(em.merge(obj)); // on fait un merge pour etre sur d'avoir un objet attach� � la base au moment de remove.
			tx.commit();

		}catch(Exception e) {
			if(tx != null && tx.isActive()){ //v�rifier que �a sert d'annuler la transaction (�vite les cascades d'erreur)
				tx.rollback();
			}
			e.printStackTrace();
		}finally { // s'execute dans tous les cas (catch d�clench� ou non)
			if(em!=null && em.isOpen()){
				em.close();
			}
		}		
	}

	@Override
	public void deleteById(Integer key) {
		delete(selectById(key));
	}


	
}
