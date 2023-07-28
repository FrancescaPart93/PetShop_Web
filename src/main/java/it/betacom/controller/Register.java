package it.betacom.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Qui gestisci la logica di registrazione e salvi i dati nel database
        //creazione e salvataggio utente tramite Dao.save()
        Utente utente = new Utente(request.getParameter("nome"), request.getParameter("cognome"), request.getParameter("email"), request.getParameter("telefono"), request.getParameter("password"), "G", "A", LocalDate.parse(request.getParameter("data")), 3);
        UtenteDao.save(utente);

        // Dopo aver completato la registrazione, reindirizza alla pagina di login
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

}
