package it.prova.migratorjdbc.service;

import it.prova.migratorjdbc.dao.AssicuratoDao;
import it.prova.migratorjdbc.model.Assicurato;
import it.prova.migratorjdbc.model.NotProcessed;

public interface AssicuratoService {
	
	public void setAssicuratoDao(AssicuratoDao assicuratoDao);
	
//	public List<Assicurato> listAll() throws Exception;
	
	public int inserisciNuovo(Assicurato input) throws Exception;

	int inserisciNotProcessed(NotProcessed input) throws Exception;


}
