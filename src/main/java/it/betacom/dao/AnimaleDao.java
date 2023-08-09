package it.betacom.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import it.betacom.bean.Animale;
import it.betacom.bean.Cliente;



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
				a.setIdCliente(rs.getInt("idCliente"));
			
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
	
	public static int save(Animale animale){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into animali(matricola, tipo, nome, prezzo) values(?,?,?,?)");
			ps.setString(1,animale.getMatricola());
			ps.setString(2,animale.getTipo());
			ps.setString(3,animale.getNome());
			ps.setDouble(4,animale.getPrezzo());
			
			status=ps.executeUpdate();
			
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	
	public static Animale getRecordByMatricola(String matricola){
		Animale a = null;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from animali where matricola = ?");
			ps.setString(1, matricola);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				a = new Animale();
				a.setMatricola(rs.getString("matricola"));
				a.setTipo(rs.getString("tipo"));
				a.setNome(rs.getString("nome"));
				a.setDataAcquisto(rs.getString("dataAcquisto"));
				a.setPrezzo(rs.getDouble("prezzo"));
				a.setIdCliente(rs.getInt("idCliente"));
			}
		}catch(Exception e){System.out.println(e);}
		System.out.println(a);
		return a;
	}
}
