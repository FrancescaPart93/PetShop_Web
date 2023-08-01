package it.betacom.bean;

public class Animale {

	private String matricola;
	private String tipo;
	private String nome;
	private String dataAcquisto;
	private Double prezzo;
	
	
	public Animale() {
		super();
	}


	public String getMatricola() {
		return matricola;
	}


	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDataAcquisto() {
		return dataAcquisto;
	}


	public void setDataAcquisto(String dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}


	public Double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}


	@Override
	public String toString() {
		return "Animale [matricola=" + matricola + ", tipo=" + tipo + ", nome=" + nome + ", dataAcquisto="
				+ dataAcquisto + ", prezzo=" + prezzo + "]";
	}
	
	
	
	
}
