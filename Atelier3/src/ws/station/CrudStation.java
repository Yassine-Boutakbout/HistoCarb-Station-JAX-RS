package ws.station;

import javax.jws.WebMethod;
import service.models.Station;


//Service Endpoint Interface
public interface CrudStation
{
	@WebMethod public String getHelloWorldAsString(String name);
	
	
	public void CreateStation(String name, String ville, String adresse);
	public void ReadStation();
	public void UpdateStation();
	public void DeleteStation();
	public Station FindById(String id);
	
}