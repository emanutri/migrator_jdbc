package it.prova.migratorjdbc.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.prova.migratorjdbc.connection.MyConnection;
import it.prova.migratorjdbc.dao.AssicuratoDao;
import it.prova.migratorjdbc.dao.IConstants;
import it.prova.migratorjdbc.model.Assicurato;
import it.prova.migratorjdbc.model.NotProcessed;

public class AssicuratoServiceImpl implements AssicuratoService {

	private AssicuratoDao assicuratoDao;

	@Override
	public void setAssicuratoDao(AssicuratoDao assicuratoDao) {
		this.assicuratoDao = assicuratoDao;
	}

	@Override
	public List<Assicurato> listAll() throws Exception {
		List<Assicurato> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(IConstants.DRIVER_NAME,
				IConstants.CONNECTION_URL_NEW)) {
			assicuratoDao.setConnection(connection);
			result = assicuratoDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int inserisciNuovo(Assicurato input) throws Exception {
		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(IConstants.DRIVER_NAME,
				IConstants.CONNECTION_URL_NEW)) {

			assicuratoDao.setConnection(connection);

			result = assicuratoDao.insert(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	
	@Override
	public int inserisciNotProcessed(NotProcessed input) throws Exception {
		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(IConstants.DRIVER_NAME,
				IConstants.CONNECTION_URL_NEW)) {

			assicuratoDao.setConnection(connection);

			result = assicuratoDao.insertNotProcessed(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}
