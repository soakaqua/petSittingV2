package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Service;
import util.JpaContext;

public class DaoServiceJpaImpl implements DaoService {

	@Override
	public Service selectById(Integer key) {
		{
			EntityManager em = JpaContext.getInstance().createEntityManager();	
			Service s = null;
			s = em.find(Service.class, key);
			em.close();
			return s;
		}
	}

	@Override
	public List<Service> selectAll() {
		EntityManager em = JpaContext.getInstance().createEntityManager();
		List<Service> services = null;
		Query query = em.createQuery("from Service s");
		services = query.getResultList();
		em.close();
		return services;
	}

	@Override
	public void insert(Service obj) {

		EntityManager em = JpaContext.getInstance().createEntityManager();
		EntityTransaction tx = null;

		try 
		{
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		}
		catch(Exception e) 
		{
			if(tx != null && tx.isActive())
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			if(em != null && em.isOpen())
			{
				em.close();
			}
		}
		
	}

	@Override
	public Service update(Service obj)
	{
		EntityManager em = JpaContext.getInstance().createEntityManager();
		EntityTransaction tx = null;
		Service s=null;
		try 
		{
			tx = em.getTransaction();
			tx.begin();
			s=(Service) em.merge(obj);
			tx.commit();
		}
		catch(Exception e) 
		{
			if(tx != null && tx.isActive())
			{
				tx.rollback();
				e.printStackTrace();
			}
		}
		finally
		{
			if(em != null && em.isOpen())
			{
				em.close();
			}
		}
		return s;

	}
	

	@Override
	public void delete(Service obj) {
		{
			EntityManager em = JpaContext.getInstance().createEntityManager();
			EntityTransaction tx = null;

			try 
			{
				tx = em.getTransaction();
				tx.begin();
				em.remove(em.merge(obj));
				tx.commit();
			}
			catch(Exception e) 
			{
				if(tx != null && tx.isActive())
				{
					tx.rollback();
					e.printStackTrace();
				}
			}
			finally
			{
				if(em != null && em.isOpen())
				{
					em.close();
				}
			}
			
		}
		
	}

	@Override
	public void deleteById(Integer key) {
		{	
			delete(selectById(key));
		}
		
	
			

		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	