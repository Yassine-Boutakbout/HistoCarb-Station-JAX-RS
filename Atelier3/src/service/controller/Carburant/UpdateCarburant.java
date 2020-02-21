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

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateCarburant")
public class UpdateCarburant extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public UpdateCarburant() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String desc = request.getParameter("desc");

		
		String cb= "{\"id_c\":"+id+",\"nom\": \""+nom+"\", \"description\": \""+desc+"\"}";
		//System.out.println(st);
		Client client = Client.create(new DefaultClientConfig());
		URI uri=UriBuilder.fromUri("http://localhost:8080/Ateliers3-RS/").build();
		ClientResponse resp = client.resource(uri).path("ServiceCarburant").path("Update").type(MediaType.APPLICATION_JSON).put(ClientResponse.class,cb);
		RequestDispatcher dis =this.getServletContext().getRequestDispatcher("/ReadCarburant");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
