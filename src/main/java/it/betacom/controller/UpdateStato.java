package it.betacom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.bean.Utente;
import it.betacom.dao.UtenteDao;

/**
 * Servlet implementation class UpdateStato
 */
@WebServlet("/UpdateStato")
public class UpdateStato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idString = request.getParameter("id"); //mi legge come stringa l'id dal form
		
		int id = Integer.parseInt(idString); // parsa l'id 
		
		Utente u = UtenteDao.getRecordById(id); // mi ritorna l'utente in cui passo l'id che legge dal form
		
		String stato = request.getParameter("stato");
		String nuovoStato;
	
		if(stato.equals("A")){
			nuovoStato = "D";
		}else{
			nuovoStato = "A";
		}
		
		UtenteDao.updateStato(id, nuovoStato);
		
		response.sendRedirect(request.getContextPath() + "/arrivomanager.jsp");
	}

}
