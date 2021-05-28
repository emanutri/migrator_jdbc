package it.prova.migratorjdbc.model;

import java.util.Date;

public class Assicurato {

	private Integer id;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private Integer nuoviSinistri;
	private String codiceFiscale;

	public Assicurato() {
	}

	public Assicurato(String nome, String cognome, Date dataNascita, Integer nuoviSinistri, String codiceFiscale) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.nuoviSinistri = nuoviSinistri;
		this.codiceFiscale = codiceFiscale;
	}

	public Assicurato(Integer id, String nome, String cognome, Date dataNascita, Integer nuoviSinistri,
			String codiceFiscale) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.nuoviSinistri = nuoviSinistri;
		this.codiceFiscale = codiceFiscale;
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

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Integer getNuoviSinistri() {
		return nuoviSinistri;
	}

	public void setNuoviSinistri(Integer nuoviSinistri) {
		this.nuoviSinistri = nuoviSinistri;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

}
