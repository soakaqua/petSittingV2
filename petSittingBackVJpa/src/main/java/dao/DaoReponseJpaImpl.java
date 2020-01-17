package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Annonce;
import model.Reponse;
import model.ReponsePK;
import util.JpaContext;

public class DaoReponseJpaImpl implements DaoReponse {

	

	//-----------------------------------------------------------------------------------DAO CLASSIQUE
	
	@Override
	public Reponse selectById(ReponsePK key) {
		EntityManager em=JpaContext.getInstance().createEntityManager();
		Reponse a=null;
		a=em.find(Reponse.class, key); 
		em.close();
		return a;
	}

	@Override
	public List<Reponse> selectAll() {
		EntityManager em=JpaContext.getInstance().createEntityManager();
		List<Reponse> annonce=null;
		Query query=em.createQuery("select p from Reponse p");  
		annonce=query.getResultList();
		em.close();
		return annonce;
	}

	@Override
	public void insert(Reponse obj) {
		EntityManager em=JpaContext.getInstance().createEntityManager();
		EntityTransaction tx=null;
		
		try {
			tx=em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx!=null && tx.isActive())
				{tx.rollback(); 
			} 
			e.printStackTrace();
		} finally {
			if (em!=null && em.isOpen())
			{em.close();}
		}		
	}

	@Override
	public Reponse update(Reponse obj) {
		EntityManager em=JpaContext.getInstance().createEntityManager();
		EntityTransaction tx=null;
		Reponse annonce=null;
		
		try {
			tx=em.getTransaction();
			tx.begin();
			annonce=em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx!=null && tx.isActive())
				{tx.rollback(); 
			} 
			e.printStackTrace();
		} finally { 
			if (em!=null && em.isOpen())
			{em.close();}
		}
		return annonce;
	}

	@Override
	public void delete(Reponse obj) {
		EntityManager em=JpaContext.getInstance().createEntityManager();
		EntityTransaction tx=null;
		
		try {
			tx=em.getTransaction();
			tx.begin();
			em.remove(em.merge(obj));  
			tx.commit();
		} catch (Exception e) {
			if (tx!=null && tx.isActive())
				{tx.rollback(); 
			} 
			e.printStackTrace();
		} finally { 
			if (em!=null && em.isOpen())
			{em.close();}
		}
	}
	

	@Override
	public void deleteById(ReponsePK key) {
		delete(selectById(key));
	}
}
