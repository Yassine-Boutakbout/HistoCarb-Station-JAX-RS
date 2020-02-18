package services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.resource.Singleton;

import service.models.Station;
import ws.station.CrudStationImpl;

@Singleton
@Path("/ServiceStation")
public class ServiceStation {
	
	private CrudStationImpl crudstation = new CrudStationImpl();
	
	@GET
	@Path("/Read")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Station> ReadStation()
	{
		return crudstation.ReadStation();
	}
	
	@POST
	@Path("/Create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Station CreateStation(Station st)
	{
		crudstation.CreateStation(st);
		return st;
	}
	
}
