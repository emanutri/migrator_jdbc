package it.prova.migratorjdbc.dao;

import it.prova.migratorjdbc.model.Assicurato;
import it.prova.migratorjdbc.model.NotProcessed;

public interface AssicuratoDao extends IBaseDao<Assicurato>{

	int insertNotProcessed(NotProcessed input) throws Exception;

}
