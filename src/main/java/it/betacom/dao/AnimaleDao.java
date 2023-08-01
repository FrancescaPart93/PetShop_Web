package it.betacom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import it.betacom.bean.Animale;


public class AnimaleDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshop_web","root","root");
		}catch(Exception e){System.out.println(e);}
		return con;
		
	}
	
	
	public static List<Animale> getAllRecords(){
		List<Animale> list=new ArrayList<Animale>();
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from animali");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Animale a = new Animale();
				a.setMatricola(rs.getString("matricola"));
				a.setTipo(rs.getString("tipo"));
				a.setNome(rs.getString("nome"));
				a.setDataAcquisto(rs.getString("dataAcquisto"));
				a.setPrezzo(rs.getDouble("prezzo"));
			
				list.add(a);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	
	public static List<Animale> getRecordByIdCliente(int id){
		
		List<Animale> list=new ArrayList<Animale>();
	
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select matricola, tipo, nome, dataAcquisto, prezzo from animali where idCliente = ?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Animale a = new Animale();				
				a.setMatricola(rs.getString("matricola"));
				a.setTipo(rs.getString("tipo"));
				a.setNome(rs.getString("nome"));
				a.setDataAcquisto(rs.getString("dataAcquisto"));
				a.setPrezzo(rs.getDouble("prezzo"));
				
				list.add(a);
			}
		}catch(Exception e){System.out.println(e);}
		System.out.println(list);
		return list;
			
	}
}
