package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Annonce;
import model.Compte;
import model.Sitter;
import util.JpaContext;

public class DaoAnnonceJpaImpl implements DaoAnnonce {

	
	//-----------------------------------------------------------------------------------DAO SPECIFIQUE
	
	public List<Annonce> SelectAllWithStatut0(){ // attention : supprimer static dans dao.
		EntityManager em=JpaContext.getInstance().createEntityManager();
		DaoAnnonce daoAnnonce = DaoAnnonceFactory.getInstance(); // attention : supprimer ligne dans dao.

		
		Query query = em.createQuery("select a from Annonce a where a.statut=0" ); 
		List<Annonce> annonces = query.getResultList(); 
		
		em.close();
		
		return annonces;

	}
	
	
	public List<Annonce> selectAnnonceByProprio(Integer numC) { //afficherAnnoncesPubliees(); Consulter mes annonces PROPRIO
		EntityManager em=JpaContext.getInstance().createEntityManager();
		List<Annonce> annonces=null;
		Query query=em.createQuery("select distinct p from Annonce p where p.numC=:numC"); 
		query.setParameter("numC", numC);
		annonces=query.getResultList();
		em.close();
		return annonces;
	}
	

	public List<Annonce> afficherAnnoncesTerminees(Integer numC) { //noterS(); Noter un sitter PROPRIO
		EntityManager em=JpaContext.getInstance().createEntityManager();
		List<Annonce> annonces=null;
		Query query=em.createQuery("select p from Annonce p where p.numC=:numC and p.statut=1");   
		query.setParameter("numC", numC);
		annonces=query.getResultList();
		em.close();
		return annonces;
	}
	

	public List<Annonce> selectAnnonceBySitter(Integer numC)  { // afficherAnnoncesPostulees(); Consulter mes annonces SITTER
		EntityManager em=JpaContext.getInstance().createEntityManager();
		List<Annonce> annonces=null;
		Query query=em.createQuery("select distinct a from Annonce a left join fetch a.reponse rep where rep.key.sitter.numC=:numC");  
		query.setParameter("numC", numC);
		annonces=query.getResultList();
		em.close();
		return annonces;
	}
	
	public List<Sitter> selectSittersByReponseValidee(Annonce a) {
		EntityManager em=JpaContext.getInstance().createEntityManager();
		List<Sitter> sitters=null;
		int numA=a.getNumA();
		Query query=em.createQuery("select distinct s from Sitter s left join fetch s.reponse rep where rep.key.numA=:numA");  
		query.setParameter("numA", numA);
		sitters=query.getResultList();
		em.close();
		return sitters;
	}
	
	public List<Integer> selectNoteSitter(Compte c) {
		EntityManager em=JpaContext.getInstance().createEntityManager();
		List<Integer> liste=null;
		int numC=c.getNumC();
		Query query=em.createQuery("select distinct noteS from Sitter s left join fetch s.annonce ann where ann.key.numC=:numC");  
		query.setParameter("numC", numC);
		liste=query.getResultList();
		em.close();
		return liste;
	}


	//-----------------------------------------------------------------------------------DAO CLASSIQUE
	
	@Override
	public Annonce selectById(Integer key) {
		EntityManager em=JpaContext.getInstance().createEntityManager();
		Annonce a=null;
		a=em.find(Annonce.class, key); 
		em.close();
		return a;
	}

	@Override
	public List<Annonce> selectAll() {
		EntityManager em=JpaContext.getInstance().createEntityManager();
		List<Annonce> annonce=null;
		Query query=em.createQuery("select p from Annonce p");  
		annonce=query.getResultList();
		em.close();
		return annonce;
	}

	@Override
	public void insert(Annonce obj) {
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
	public Annonce update(Annonce obj) {
		EntityManager em=JpaContext.getInstance().createEntityManager();
		EntityTransaction tx=null;
		Annonce annonce=null;
		
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
	public void delete(Annonce obj) {
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
	public void deleteById(Integer key) {
		delete(selectById(key));
	}
}
