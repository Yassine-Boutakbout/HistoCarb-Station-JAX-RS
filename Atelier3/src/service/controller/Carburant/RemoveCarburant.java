package service.controller.Carburant;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.List;

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

import service.models.Station;

/**
 * Servlet implementation class RemoveServlet
 */
@WebServlet("/RemoveCarburant")
public class RemoveCarburant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RemoveCarburant() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("id");
		Client client = Client.create(new DefaultClientConfig());
		URI uri=UriBuilder.fromUri("http://localhost:8080/Ateliers3-RS/").build();
		ClientResponse resp = client.resource(uri).path("ServiceCarburant").path("Delete").queryParam("id", id).delete(ClientResponse.class);
		
		RequestDispatcher dis =this.getServletContext().getRequestDispatcher("/ReadCarburant");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
