package it.prova.migratorjdbc.dao;

import java.sql.Connection;

import it.prova.migratorjdbc.model.Assicurato;
import it.prova.migratorjdbc.model.NotProcessed;

public interface AssicuratoDao{

	int insertNotProcessed(NotProcessed input) throws Exception;

	void setConnection(Connection connection);

	int insert(Assicurato input) throws Exception;

}
