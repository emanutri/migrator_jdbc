package it.prova.migratorjdbc.service;

import java.util.List;

import it.prova.migratorjdbc.dao.OldSchemaDao;
import it.prova.migratorjdbc.model.OldSchema;

public interface OldSchemaService {
	
	public void setOldSchemaDao(OldSchemaDao oldSchemaDao);

	public List<OldSchema> listAll() throws Exception;

}
