package it.prova.migratorjdbc.model;

import java.util.Date;

public class OldSchema {

	private Integer id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private Date dataNascita;
	private Integer numeroSinistri;

	public OldSchema() {
	}

	public OldSchema(Integer id, String nome, String cognome, String codiceFiscale, Date dataNascita,
			Integer numeroSinistri) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataNascita = dataNascita;
		this.numeroSinistri = numeroSinistri;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Integer getNumeroSinistri() {
		return numeroSinistri;
	}

	public void setNumeroSinistri(Integer numeroSinistri) {
		this.numeroSinistri = numeroSinistri;
	}

}
