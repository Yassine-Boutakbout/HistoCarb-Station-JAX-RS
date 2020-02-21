package rs.carburant;


import java.util.List;

import service.models.Carburant;
//Service Endpoint Interface

public interface CrudCarburant
{

	public String getHelloWorldAsString(String name);
	public void CreateCarburant(Carburant st);
	public List<Carburant> ReadCarburant();
	public void UpdateCarburant(Carburant st);
	public void DeleteCarburant(String id);
	public Carburant FindById(String id);
}