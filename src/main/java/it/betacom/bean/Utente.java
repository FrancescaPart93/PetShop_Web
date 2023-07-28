package it.betacom.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class Utente {

	private int id;
	private String nome, cognome, email, telefono, password, ruolo, stato, username;
	private LocalDate data;
	private int tentativiLogin;
	


	public Utente(String nome, String cognome, String email, String telefono, String password, String ruolo,
			String stato, LocalDate data, int tentativiLogin) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
		this.ruolo = ruolo;
		this.stato = stato;
		this.data = data;
		this.tentativiLogin = tentativiLogin;
	}



	public Utente() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(String data) {
		this.data = LocalDate.parse(data);
	}

	public void setData(LocalDate data) {
		this.data = data;
	}


	public String getRuolo() {
		return ruolo;
	}


	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}


	public String getStato() {
		return stato;
	}


	public void setStato(String stato) {
		this.stato = stato;
	}


	public String getUsername() {
		return username;
	}


	
	public void setUsername(String username) {
		this.username = username;
	}



	public int getTentativiLogin() {
		return tentativiLogin;
	}



	public void setTentativiLogin(int tentativiLogin) {
		this.tentativiLogin = tentativiLogin;
	}




	@Override
	public String toString() {
		return "Utente [tentativiLogin=" + tentativiLogin + ", id=" + id + ", nome=" + nome + ", cognome=" + cognome
				+ ", email=" + email + ", telefono=" + telefono + ", password=" + password + ", ruolo=" + ruolo
				+ ", stato=" + stato + ", username=" + username + ", data=" + data + "]";
	}




	public String generateUsername() {
	    // Prendi le prime due lettere del nome e del cognome
	    String username = (nome.length() >= 2 ? nome.substring(0, 2).toLowerCase() : nome.toLowerCase()) +
	                      (cognome.length() >= 2 ? cognome.substring(0, 2).toLowerCase() : cognome.toLowerCase()) +
	                      this.data.getYear();

	    // Connessione al database e controllo dell'esistenza dell'username
	    String jdbcUrl = "jdbc:mysql://localhost:3306/petshop_web"; 
	    String dbUsername = "root"; 
	    String dbPassword = "root";

	    try (Connection conn = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
	        String checkQuery = "SELECT COUNT(*) AS count FROM utente WHERE username = ?";
	        PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
	        checkStmt.setString(1, username);
	        ResultSet resultSet = checkStmt.executeQuery();
	        resultSet.next();
	        int count = resultSet.getInt("count");

	        int suffix = 1;
	        String originalUsername = username;
	        while (count > 0) {
	            // Se l'username esiste già nel database, aggiunge un (_) e un numero autoincrementale
	            username = originalUsername + "_" + suffix;
	            checkStmt.setString(1, username);
	            resultSet = checkStmt.executeQuery();
	            resultSet.next();
	            count = resultSet.getInt("count");
	            suffix++;
	        }

	        return username;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Gestisci l'eccezione in modo appropriato
	        return null;
	    }
	}
	

	
	
	
}
