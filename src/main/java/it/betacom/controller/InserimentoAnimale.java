package it.betacom.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.bean.Animale;
import it.betacom.bean.Utente;
import it.betacom.dao.AnimaleDao;
import it.betacom.dao.UtenteDao;

/**
 * Servlet implementation class InserimentoAnimale
 */
@WebServlet("/InserimentoAnimale")
public class InserimentoAnimale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserimentoAnimale() {
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
		 
    	String matricola = request.getParameter("matricola");
    	
    	String prezzoString = request.getParameter("prezzo");
		double prezzo = Double.parseDouble(prezzoString); // 
    	
    	//controllo sulla matricola già esistente
    	if(AnimaleDao.getRecordByMatricola(matricola) != null) {
    		 response.sendRedirect(request.getContextPath() + "/error.jsp");    	
    	}else {
    	
	        //creazione e salvataggio utente tramite Dao.save()
	    	
	        Animale animale = new Animale(request.getParameter("matricola"), request.getParameter("tipo"), request.getParameter("nome"), prezzo);
	        
	        AnimaleDao.save(animale);
	
	        // Dopo aver completato la registrazione, reindirizza alla pagina di login
	        response.sendRedirect(request.getContextPath() + "/showanimali.jsp");
    	}    
	}

}
