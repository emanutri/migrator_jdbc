package it.prova.migratorjdbc.model;

public class NotProcessed {

	private Integer id;
	private String codiceFiscale;
	private String oldId;

	public NotProcessed() {
	}

	public NotProcessed(Integer id, String codiceFiscale, String oldId) {
		this.id = id;
		this.codiceFiscale = codiceFiscale;
		this.oldId = oldId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getOldId() {
		return oldId;
	}

	public void setOldId(String oldId) {
		this.oldId = oldId;
	}

}
