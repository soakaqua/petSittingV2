package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Annonce;
import model.Annonce_Service;
import model.Annonce_ServicePK;
import util.JpaContext;

public class DaoAnnonce_ServiceJpaImpl implements DaoAnnonce_Service {
	

	//-----------------------------------------------------------------------------------DAO CLASSIQUE
	
	@Override
	public Annonce_Service selectById(Annonce_ServicePK key) {
		EntityManager em=JpaContext.getInstance().createEntityManager();
		Annonce_Service a=null;
		a=em.find(Annonce_Service.class, key); 
		em.close();
		return a;
	}

	@Override
	public List<Annonce_Service> selectAll() {
		EntityManager em=JpaContext.getInstance().createEntityManager();
		List<Annonce_Service> annonce=null;
		Query query=em.createQuery("select p from Annonce_Service p");  
		annonce=query.getResultList();
		em.close();
		return annonce;
	}

	@Override
	public void insert(Annonce_Service obj) {
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
	public Annonce_Service update(Annonce_Service obj) {
		EntityManager em=JpaContext.getInstance().createEntityManager();
		EntityTransaction tx=null;
		Annonce_Service annonce=null;
		
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
	public void delete(Annonce_Service obj) {
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
	public void deleteById(Annonce_ServicePK key) {
		delete(selectById(key));
	}
}
