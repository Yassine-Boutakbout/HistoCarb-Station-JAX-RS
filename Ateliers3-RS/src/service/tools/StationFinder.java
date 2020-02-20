package service.tools;

import javax.persistence.EntityManager;
import service.models.Station;

public class StationFinder {
	
	public StationFinder() {
		
	}
	
	public static Station FindById(String id)
	{
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		Station st = em.find(Station.class, Integer.parseInt(id));
		return st;
	}
}
