package service.tools;

import javax.persistence.EntityManager;

import service.models.Carburant;

public class CarburantFinder {
	
	public CarburantFinder() {
		
	}
	
	public static Carburant FindById(String id)
	{
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		Carburant cb = em.find(Carburant.class, Integer.parseInt(id));
		return cb;
	}
}
