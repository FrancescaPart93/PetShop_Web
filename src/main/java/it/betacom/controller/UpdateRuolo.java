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
 * Servlet implementation class UpdateRuolo
 */
@WebServlet("/UpdateRuolo")
public class UpdateRuolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRuolo() {
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
		
//		String idString = request.getParameter("id"); //mi legge come stringa l'id dal form
//		
//		int id = Integer.parseInt(idString); // parsa l'id 
//		
//		Utente u = UtenteDao.getRecordById(id);  // mi ritorna l'utente in cui passo l'id che legge dal form
//		
//		if (u != null) {
//			
//			String ruolo = request.getParameter("ruolo");
//	
//			UtenteDao.updateRuolo(id);
//		}
//		
//		System.out.println(u);
//		
//		response.sendRedirect(request.getContextPath() + "/successomodifica.jsp");
		
		
		String idString = request.getParameter("id"); //mi legge come stringa l'id dal form
		
		int id = Integer.parseInt(idString); // parsa l'id 
		
		Utente u = UtenteDao.getRecordById(id); // mi ritorna l'utente in cui passo l'id che legge dal form
		
		String ruolo = request.getParameter("ruolo");
		String nuovoRuolo;
	
		if(ruolo.equals("G")){
			nuovoRuolo = "M";
		}else{
			nuovoRuolo = "G";
		}
		
		UtenteDao.updateRuolo(id, nuovoRuolo);
		
		response.sendRedirect(request.getContextPath() + "/successomodifica.jsp");

	}

}
