package service.controller.Station;

import java.io.IOException;
import java.net.URI;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.DefaultClientConfig;


/**
 * Servlet implementation class AjouterIngServlet
 */

@WebServlet("/CreateStation")
public class CreateStation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateStation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nom = request.getParameter("nom");
		String ville = request.getParameter("ville");
		String adresse = request.getParameter("adresse");
		//Station st = new Station(nom, ville, adresse);
		
		String st= "{\"nom\": \""+nom+"\", \"ville\": \""+ville+"\",\"adresse\": \""+adresse+"\"}";
		Client client = Client.create(new DefaultClientConfig());
		URI uri=UriBuilder.fromUri("http://localhost:8080/Ateliers3-RS/").build();
		ClientResponse resp = client.resource(uri).path("ServiceStation").path("Create").type(MediaType.APPLICATION_JSON).post(ClientResponse.class,st);
		
		RequestDispatcher dis =this.getServletContext().getRequestDispatcher("/ReadStation");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
