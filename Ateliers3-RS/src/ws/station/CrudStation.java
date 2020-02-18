package ws.station;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.models.Station;
//Service Endpoint Interface

@Path("/StationService")
public interface CrudStation
{

	public String getHelloWorldAsString(String name);
	public void CreateStation(Station st);
	public List<Station> ReadStation();
	public void UpdateStation();
	public void DeleteStation();
	public Station FindById(String id);
	
}