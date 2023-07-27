package it.betacom.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import it.betacom.bean.Utente;


public class UtenteDao {
	
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshop_web","root","root");
		}catch(Exception e){System.out.println(e);}
		return con;
		
	}
	
	
	public static int save(Utente utente){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into utente(nome, cognome, email, password, telefono, data_di_nascita, ruolo, stato, username) values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1,utente.getNome());
			ps.setString(2,utente.getCognome());
			ps.setString(3,utente.getEmail());
			ps.setString(4,utente.getPassword());
			ps.setString(5,utente.getTelefono());
			ps.setDate(6,Date.valueOf(utente.getData()));
			ps.setString(7, utente.getRuolo());
			ps.setString(8, utente.getStato());
			ps.setString(9, utente.generateUsername());
			
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static List<Utente> getAllRecords(){
		List<Utente> list=new ArrayList<Utente>();
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from utente");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Utente u=new Utente();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setCognome(rs.getString("cognome"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setTelefono(rs.getString("telefono"));
				u.setStato(rs.getString("stato"));
				u.setRuolo(rs.getString("ruolo"));
				u.setUsername(rs.getString("username"));
				list.add(u);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	
	public static Utente getRecordById(int id){
		Utente u = null;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from utente where id = ?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				u = new Utente();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setCognome(rs.getString("cognome"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setTelefono(rs.getString("telefono"));
				//u.setData_di_nascita(rs.getDate("data_di_nascita"));
			}
		}catch(Exception e){System.out.println(e);}
		return u;
	}
	
	
	public static int update(Utente u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update utente set nome=?, cognome=?, email=?, password=?, telefono=?, data_di_nascita=? where id=?");
			ps.setString(1,u.getNome());
			ps.setString(2,u.getCognome());
			ps.setString(3,u.getEmail());
			ps.setString(4,u.getPassword());
			ps.setString(5,u.getTelefono());
		//	ps.setDate(6,(Date) u.getData_di_nascita());
			ps.setInt(7,u.getId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int delete(Utente u){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from utente where id=?");
			ps.setInt(1,u.getId());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}

		return status;
	}

	
	public static Utente getRecordByEmail(String email){
		Utente u = null;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from utente where email= ?");
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				u = new Utente();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setCognome(rs.getString("cognome"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setTelefono(rs.getString("telefono"));
				u.setStato(rs.getString("stato"));
				u.setRuolo(rs.getString("ruolo"));
				u.setUsername(rs.getString("username"));


//				u.setData(rs.getDate(Date.valueOf(u.getData())));
//				ps.setDate(6,Date.valueOf(utente.getData()));
			}
		}catch(Exception e){System.out.println(e);}
		return u;
	}
	
//	public static Utente controlloLogin(String email, String password) {
//		
//		Utente utente = getRecordByEmail(email);
//		if(utente != null && utente.getStato().equals("A") && utente.getPassword().equals(password)) {
//			System.out.println("Accesso effettuato");
//			System.out.println(utente.toString());
//
//			return utente;
//		}
//		
//		return null;
//	
//	}
	
	
	
	// DA RIVEDERE IL CONTROLLO TENTATIVI PASSWORD
	
	public static Utente controlloLogin(String email, String password) {
		
	
		Utente utente = getRecordByEmail(email);
	    if (utente != null && utente.getStato().equals("A")) {
	        if (utente.getPassword().equals(password)) {
	            System.out.println("Accesso effettuato");
	            System.out.println(utente.toString());
	           // utente.setTentativiPwd(3); // Reimposta il numero di tentativi quando l'accesso ha successo
	            return utente;
	        } else {
	            utente.decrementaTentativo();
	            System.out.println("Password errata! Tentativi rimanenti: " + utente.getTentativiPwd());
	            if (utente.getTentativiPwd() == 0) {
	                utente.setStato("D");
	                System.out.println("Contatta il servizio clienti");
	            }
	        }
	    } else {
	        System.out.println("Utente non trovato o disabilitato");
	    }
	    return null;
	
	}
	
	
	
	// metodo per la modifica del ruolo da parte del manager
	public static void updateRuolo(int id, String ruolo){
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update utente set ruolo=? where id=?");
			ps.setString(1, ruolo);
			ps.setInt(2, id);
			ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		
	}
	
	public static void updateStato(int id, String stato){
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update utente set stato=? where id=?");
			ps.setString(1, stato);
			ps.setInt(2, id);
			ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}

	}
	
	public static void update(int id, String email, String password, String telefono){
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update utente set email = ?, password = ?, telefono = ? where id = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, telefono);
			ps.setInt(4, id);
			ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}

	}
	
	
	public static Utente getRecordById2(int id){
		Utente u = null;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from utente where id = ?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				u = new Utente();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setCognome(rs.getString("cognome"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setTelefono(rs.getString("telefono"));
				u.setUsername(rs.getString("username"));
			}
		}catch(Exception e){System.out.println(e);}
		System.out.println(u);
		return u;
		
		
	}
}
