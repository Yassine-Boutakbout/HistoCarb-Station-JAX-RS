package service.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.models.Station;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
