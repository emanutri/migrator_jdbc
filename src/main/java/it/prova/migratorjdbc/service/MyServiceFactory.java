package it.prova.migratorjdbc.service;

import it.prova.migratorjdbc.dao.AssicuratoDaoImpl;
import it.prova.migratorjdbc.dao.OldSchemaDaoImpl;

public class MyServiceFactory {
	public static AssicuratoService getAssicuratoServiceImpl() {
		AssicuratoService assicuratoService = new AssicuratoServiceImpl();
		assicuratoService.setAssicuratoDao(new AssicuratoDaoImpl());
		
		return assicuratoService;
	}
	public static OldSchemaService getOldSchemaServiceImpl() {
		OldSchemaService oldSchemaService = new OldSchemaServiceImpl();
		oldSchemaService.setOldSchemaDao(new OldSchemaDaoImpl());
		
		return oldSchemaService;
	}
}
