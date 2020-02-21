package services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.resource.Singleton;

import rs.carburant.CrudCarburantImpl;
import service.models.Carburant;

@Singleton
@Path("/ServiceCarburant")
public class ServiceCarburant {
	
	private CrudCarburantImpl crudcarburant = new CrudCarburantImpl();
	
	@GET
	@Path("/Read")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Carburant> ReadCarburant()
	{
		return crudcarburant.ReadCarburant();
	}
	
	@POST
	@Path("/Create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Carburant CreateCarburant(Carburant cb)
	{
		crudcarburant.CreateCarburant(cb);
		return cb;
	}
	
	@GET
	@Path("FindbyID/{id}")
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Carburant FindByID(@PathParam(value="id")String id)
	{
		return crudcarburant.FindById(id);
	}
	
	@PUT
	@Path("Update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Carburant UpdateCarburant(Carburant cb)
	{
		crudcarburant.UpdateCarburant(cb);
		return cb;
	}
	
	@DELETE
	@Path("Delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public void DeleteCarburant(@QueryParam(value="id") String id)
	{
		//System.out.println("hellloooo");
		crudcarburant.DeleteCarburant(id);
	}
}