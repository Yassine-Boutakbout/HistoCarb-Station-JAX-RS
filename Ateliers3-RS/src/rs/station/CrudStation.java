package rs.station;

import java.util.List;
import service.models.Station;
//Service Endpoint Interface

public interface CrudStation
{

	public String getHelloWorldAsString(String name);
	public void CreateStation(Station st);
	public List<Station> ReadStation();
	public void UpdateStation(Station st);
	public void DeleteStation(String id);
	public Station FindById(String id);
	
}