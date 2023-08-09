package it.betacom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.bean.Utente;
import it.betacom.dao.UtenteDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Utente utente = UtenteDao.getRecordByEmail(email);
		
		
		utente = UtenteDao.controlloLogin(email, password, utente);
		
		if(utente != null && utente.getRuolo().equals("M") ) {
			
			HttpSession session = request.getSession();
			
	        session.setAttribute("utenteId", utente.getId());
	        session.setAttribute("nome", utente.getNome());
	        session.setAttribute("cognome", utente.getCognome());
	        session.setAttribute("ruolo", utente.getRuolo());
	        response.sendRedirect(request.getContextPath() + "/arrivomanager.jsp");
	        
		}else if (utente != null && utente.getRuolo().equals("G")) {
			
			HttpSession session = request.getSession();
			
	        session.setAttribute("utenteId", utente.getId());
	        session.setAttribute("nome", utente.getNome());
	        session.setAttribute("cognome", utente.getCognome());
	        session.setAttribute("ruolo", utente.getRuolo());


	        response.sendRedirect(request.getContextPath() + "/arrivoguest.jsp");
		} else {
	        // Display the login feedback message
	        request.setAttribute("loginFailed", true);
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
	}
	
	


}
