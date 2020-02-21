package service.controller.Carburant;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import service.models.Carburant;


/**
 * Servlet implementation class ReadServlet
 */
@WebServlet("/ReadCarburant")
public class ReadCarburant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadCarburant() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Carburant> cbslst = new ArrayList<>();
		Client client = Client.create(new DefaultClientConfig());
		URI uri=UriBuilder.fromUri("http://localhost:8080/Ateliers3-RS/").build();
		ClientResponse resp = client.resource(uri).path("ServiceCarburant").path("Read").get(ClientResponse.class);

		String corpsRepHttp= resp.getEntity(String.class);
		//System.out.println(corpsRepHttp);
		
		ObjectMapper mapper = new ObjectMapper();
		
		Carburant[] cbs = mapper.readValue(corpsRepHttp, Carburant[].class);
		
		for(Carburant cb:cbs)
		{
			cbslst.add(cb);
		}
		try {
			
			request.setAttribute("carburants", (List<Carburant>) cbslst);
			RequestDispatcher dis = this.getServletContext().getRequestDispatcher("/CrudCarburant.jsp");
			dis.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ReadCarburant.doGet() " + e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
