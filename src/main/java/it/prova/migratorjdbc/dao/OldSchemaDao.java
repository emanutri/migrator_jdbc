package it.prova.migratorjdbc.dao;

import java.sql.Connection;
import java.util.List;

import it.prova.migratorjdbc.model.OldSchema;

public interface OldSchemaDao{

	void setConnection(Connection connection);

	List<OldSchema> list() throws Exception;
	
	

}
