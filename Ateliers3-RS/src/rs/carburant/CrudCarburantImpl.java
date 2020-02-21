package rs.carburant;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import service.models.*;
import service.tools.CarburantFinder;
import service.tools.LocalEntityManagerFactory;

//Service Implementation
public class CrudCarburantImpl implements CrudCarburant
{
	
	@Override
	public String getHelloWorldAsString(String name) 
	{   
		return "Hello World JAX-WS " + name;
	}

	@Override
	public void CreateCarburant(Carburant cb){
		// TODO Auto-generated method stub
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(cb);
		em.getTransaction().commit();
	}

	@Override
	public List<Carburant> ReadCarburant()
	{
		// TODO Auto-generated method stub
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		TypedQuery<Carburant> query = em.createQuery("select c from Carburant c", Carburant.class);
		List<Carburant> ls= query.getResultList();
		return ls;
	}

	@Override
	public void UpdateCarburant(Carburant cb){
		// TODO Auto-generated method stub
		
		
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		Carburant cbs = em.find(Carburant.class, cb.getId_c());
		em.getTransaction().begin();
		
		cbs.setDescription(cb.getDescription());
		cbs.setNom(cb.getNom());
		em.getTransaction().commit();
	}

	@Override
	public void DeleteCarburant(String id){
		// TODO Auto-generated method stub
		EntityManager em =LocalEntityManagerFactory.createEntityManager();
		Carburant cb =FindById(id);
		Carburant current = null;
		em.getTransaction().begin();
		if (!em.contains(cb)) {
		    current = em.merge(cb);
		}
		em.remove(current);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Carburant FindById(String id) {
		// TODO Auto-generated method stub
		return CarburantFinder.FindById(id);
	}
	
}