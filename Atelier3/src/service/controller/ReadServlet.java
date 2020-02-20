package service.controller;

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

import service.models.Station;


/**
 * Servlet implementation class ReadServlet
 */
@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 *  Client client =
		 * ClientBuilder.newClient(); WebTarget target =
		 * client.target("http://localhost:8080/Ateliers3-RS/ServiceStation/Read");
		 * JsonArray resp =
		 * target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
		 * System.out.println(resp);
		 */
		
		
		
		List<Station> stslst = new ArrayList<>();
		Client client = Client.create(new DefaultClientConfig());
		URI uri=UriBuilder.fromUri("http://localhost:8080/Ateliers3-RS/").build();
		ClientResponse resp = client.resource(uri).path("ServiceStation").path("Read").get(ClientResponse.class);

		String corpsRepHttp= resp.getEntity(String.class);
		//System.out.println(corpsRepHttp);
		
		ObjectMapper mapper = new ObjectMapper();
		
		Station[] sts = mapper.readValue(corpsRepHttp, Station[].class);
		
		for(Station st:sts)
		{
			stslst.add(st);
		}
		try {
			
			request.setAttribute("stations", (List<Station>) stslst);
			RequestDispatcher dis = this.getServletContext().getRequestDispatcher("/CrudStation.jsp");
			dis.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ReadServlet.doGet() " + e.getMessage());
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
