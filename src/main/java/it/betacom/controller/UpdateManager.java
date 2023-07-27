package it.betacom.controller;


import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.bean.Utente;
import it.betacom.dao.UtenteDao;

/**
 * Servlet implementation class updatemanager
 */
@WebServlet("/UpdateManager")
public class UpdateManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idString = request.getParameter("id"); //mi legge come stringa l'id dal form
		
		int id = Integer.parseInt(idString); // parsa l'id 
		
		Utente u = UtenteDao.getRecordById2(id);  // mi ritorna l'utente in cui passo l'id che legge dal form
		
		if (u != null) {
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String telefono = request.getParameter("telefono");
	
			UtenteDao.update(id, email, password, telefono);
		}
		
		response.sendRedirect(request.getContextPath() + "/successomodifica.jsp");
		

	
	}

}
