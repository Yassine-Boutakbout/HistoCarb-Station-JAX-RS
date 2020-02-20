package ws.station;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import service.models.*;
import service.tools.LocalEntityManagerFactory;
import service.tools.StationFinder;

//Service Implementation
public class CrudStationImpl implements CrudStation
{
	
	@Override
	public String getHelloWorldAsString(String name) 
	{   
		return "Hello World JAX-WS " + name;
	}

	@Override
	public void CreateStation(Station st){
		// TODO Auto-generated method stub
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(st);
		em.getTransaction().commit();
	}

	@Override
	public List<Station> ReadStation()
	{
		// TODO Auto-generated method stub
		
		
		//Station st = new Station("petromin", "Tanger", "Route RABAT");
		//Carburant cb = new Carburant("gazoil", "mazooot");
		
		//HistoCarb hc = new HistoCarb(new Date() , 11.0, st, cb);
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		TypedQuery<Station> query = em.createQuery("select s from Station s", Station.class);
		List<Station> ls= query.getResultList();
		return ls;
	}

	@Override
	public void UpdateStation(Station st){
		// TODO Auto-generated method stub
		
		
		EntityManager em = LocalEntityManagerFactory.createEntityManager();
		Station sts = em.find(Station.class, st.getId_s());
		em.getTransaction().begin();
		sts.setAdresse(st.getAdresse());
		sts.setNom(st.getNom());
		sts.setVille(st.getVille());
		em.getTransaction().commit();
	}

	@Override
	public void DeleteStation(String id){
		// TODO Auto-generated method stub
		EntityManager em =LocalEntityManagerFactory.createEntityManager();
		Station st =FindById(id);
		Station current = null;
		em.getTransaction().begin();
		if (!em.contains(st)) {
		    current = em.merge(st);
		}
		em.remove(current);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Station FindById(String id) {
		// TODO Auto-generated method stub
		return StationFinder.FindById(id);
	}
	
}