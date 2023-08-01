package it.betacom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import it.betacom.bean.Cliente;
import it.betacom.bean.Utente;


public class ClienteDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshop_web","root","root");
		}catch(Exception e){System.out.println(e);}
		return con;
		
	}
	
	
	public static List<Cliente> getAllRecords(){
		List<Cliente> list=new ArrayList<Cliente>();
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from clienti");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Cliente c = new Cliente();
				c.setIdCliente(rs.getInt("idCliente"));
				c.setNome(rs.getString("nome"));
				c.setCognome(rs.getString("cognome"));
				c.setCitta(rs.getString("citta"));
				c.setTelefono(rs.getString("telefono"));
				c.setIndirizzo(rs.getString("indirizzo"));
				list.add(c);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	
	public static Cliente getRecordById(int idCliente){
		Cliente c = null;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from clienti where idCliente = ?");
			ps.setInt(1, idCliente);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				c = new Cliente();
				c.setIdCliente(rs.getInt("idCliente"));
				c.setNome(rs.getString("nome"));
				c.setCognome(rs.getString("cognome"));
				c.setCitta(rs.getString("citta"));
				c.setTelefono(rs.getString("telefono"));
				c.setIndirizzo(rs.getString("indirizzo"));
			}
		}catch(Exception e){System.out.println(e);}
		System.out.println(c);
		return c;
		
		
	}
}
