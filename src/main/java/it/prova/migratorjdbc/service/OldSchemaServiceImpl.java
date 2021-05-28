package it.prova.migratorjdbc.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.prova.migratorjdbc.connection.MyConnection;
import it.prova.migratorjdbc.dao.IConstants;
import it.prova.migratorjdbc.dao.OldSchemaDao;
import it.prova.migratorjdbc.model.OldSchema;

public class OldSchemaServiceImpl implements OldSchemaService {

	private OldSchemaDao oldSchemaDao;

	@Override
	public List<OldSchema> listAll() throws Exception {
		List<OldSchema> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(IConstants.DRIVER_NAME,
				IConstants.CONNECTION_URL_OLD)) {
			oldSchemaDao.setConnection(connection);
			result = oldSchemaDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public void setOldSchemaDao(OldSchemaDao oldSchemaDao) {
		this.oldSchemaDao = oldSchemaDao;
	}

}
