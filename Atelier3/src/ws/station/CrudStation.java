package ws.station;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;

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