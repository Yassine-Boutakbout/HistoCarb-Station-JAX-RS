package service.controller.Station;

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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateStation")
public class UpdateStation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String ville = request.getParameter("ville");
		String adresse = request.getParameter("adresse");

		
		String st= "{\"id_s\":"+id+",\"nom\": \""+nom+"\", \"ville\": \""+ville+"\",\"adresse\": \""+adresse+"\"}";
		//System.out.println(st);
		Client client = Client.create(new DefaultClientConfig());
		URI uri=UriBuilder.fromUri("http://localhost:8080/Ateliers3-RS/").build();
		ClientResponse resp = client.resource(uri).path("ServiceStation").path("Update").type(MediaType.APPLICATION_JSON).put(ClientResponse.class,st);
		
		RequestDispatcher dis =this.getServletContext().getRequestDispatcher("/ReadStation");
		dis.forward(request, response);
		
		/*
		 * EntityManager em = LocalEntityManagerFactory.createEntityManager();
		 * 
		 * Station st = em.find(Station.class, Integer.parseInt(id));
		 * 
		 * em.getTransaction().begin(); st.setAdresse(adresse); st.setNom(nom);
		 * st.setVille(ville); em.getTransaction().commit();
		 * 
		 * PrintWriter out = response.getWriter();
		 * 
		 * out.println("sucsess !!!! redirecting ^^");
		 * 
		 * TypedQuery<Station> query = em.createQuery("select s from Station s",
		 * Station.class); List<Station> lst = query.getResultList();
		 * System.out.println(lst.get(0).toString()); request.setAttribute("stations",
		 * lst); RequestDispatcher dis =
		 * this.getServletContext().getRequestDispatcher("/CrudStation.jsp");
		 * dis.forward(request, response);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
