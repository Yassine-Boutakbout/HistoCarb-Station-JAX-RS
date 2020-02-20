package service.controller;

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
@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("id");
		Client client = Client.create(new DefaultClientConfig());
		URI uri=UriBuilder.fromUri("http://localhost:8080/Ateliers3-RS/").build();
		ClientResponse resp = client.resource(uri).path("ServiceStation").path("Delete").queryParam("id", id).delete(ClientResponse.class);
		
		RequestDispatcher dis =this.getServletContext().getRequestDispatcher("/ReadServlet");
		dis.forward(request, response);
		/*
		 * String id=request.getParameter("id"); EntityManager em =
		 * LocalEntityManagerFactory.createEntityManager(); Station st =
		 * em.find(Station.class, Integer.parseInt(id)); if(st==null) { PrintWriter out
		 * = response.getWriter(); out.println("Object has been removed!! ^^'"); } else
		 * { em.getTransaction().begin(); em.remove(st); em.getTransaction().commit(); }
		 * 
		 * TypedQuery<Station> query=em.createQuery("select s from Station s",
		 * Station.class); List<Station> lst= query.getResultList();
		 * request.setAttribute("stations", lst); RequestDispatcher dis =
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
