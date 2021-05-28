package it.prova.migratorjdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.migratorjdbc.model.OldSchema;

public class OldSchemaDaoImpl extends AbstractMySQLDao implements OldSchemaDao {

	@Override
	public List<OldSchema> list() throws Exception {
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<OldSchema> result = new ArrayList<OldSchema>();
		OldSchema oldSchemaTemp = null;

		try (Statement ps = connection.createStatement();
				ResultSet rs = ps.executeQuery(
						"select d.id, d.codice_fiscale, a.nome, a.cognome, a.data_nascita, count(s.id) as numero_sinistri from schemaold.dati_fiscali d\r\n"
								+ "join schemaold.anagrafica a on  d.id = a.dati_fiscali\r\n"
								+ "left join schemaold.sinistri s on a.id = s.anagrafica\r\n" + "group by d.id")) {

			while (rs.next()) {
				oldSchemaTemp = new OldSchema();
				oldSchemaTemp.setId(rs.getInt("id"));
				oldSchemaTemp.setNome(rs.getString("nome"));
				oldSchemaTemp.setCognome(rs.getString("cognome"));
				oldSchemaTemp.setDataNascita(rs.getDate("data_nascita"));
				oldSchemaTemp.setNumeroSinistri(rs.getInt("numero_sinistri"));
				oldSchemaTemp.setCodiceFiscale(rs.getString("codice_fiscale"));
				result.add(oldSchemaTemp);
			}

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
