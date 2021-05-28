package it.prova.migratorjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import it.prova.migratorjdbc.model.Assicurato;
import it.prova.migratorjdbc.model.NotProcessed;

public class AssicuratoDaoImpl extends AbstractMySQLDao implements AssicuratoDao {

//	@Override
//	public List<Assicurato> list() throws Exception {
//		if (isNotActive())
//			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");
//
//		ArrayList<Assicurato> result = new ArrayList<Assicurato>();
//		Assicurato assicuratoTemp = null;
//
//		try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery("select * from assicurato")) {
//
//			while (rs.next()) {
//				assicuratoTemp = new Assicurato();
//				assicuratoTemp.setId(rs.getInt("id"));
//				assicuratoTemp.setNome(rs.getString("nome"));
//				assicuratoTemp.setCognome(rs.getString("cognome"));
//				assicuratoTemp.setDataNascita(rs.getDate("data_nascita"));
//				assicuratoTemp.setNuoviSinistri(rs.getInt("nuovi_sinistri"));
//				assicuratoTemp.setCodiceFiscale(rs.getString("codice_fiscale"));
//				result.add(assicuratoTemp);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//		return result;
//	}

	@Override
	public int insert(Assicurato input) throws Exception {
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO assicurato (nome, cognome, data_nascita, nuovi_sinistri, codice_fiscale) VALUES (?, ?, ?, ?, ?);")) {
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setDate(3, new java.sql.Date(input.getDataNascita().getTime()));
			ps.setInt(4, input.getNuoviSinistri());
			ps.setString(5, input.getCodiceFiscale());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int insertNotProcessed(NotProcessed input) throws Exception {
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (PreparedStatement ps = connection
				.prepareStatement("INSERT INTO not_processed (codice_fiscale, old_id) VALUES (?, ?);")) {
			ps.setString(1, input.getCodiceFiscale());
			ps.setString(2, input.getOldId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
