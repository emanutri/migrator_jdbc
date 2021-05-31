package it.prova.migratorjdbc.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import it.prova.migratorjdbc.model.Assicurato;

public class CsvReaderServiceImpl{

	public static List<Assicurato> readCsv(String filePath) throws IOException {
		BufferedReader csvReader = new BufferedReader(new FileReader(filePath));
		String row;
		List<String[]> datiVecchioDb = new ArrayList<>();
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			datiVecchioDb.add(data);
		}
		csvReader.close();

		List<Assicurato> assicuratiDaVecchioDb = new ArrayList<>();
		for (int i = 0; i < datiVecchioDb.size(); i++) {
			String[] assicuratoString = datiVecchioDb.get(i);
			Assicurato assicurato = new Assicurato();
			assicurato.setId(Integer.parseInt(assicuratoString[0]));
			assicurato.setNome(assicuratoString[1]);
			assicurato.setCognome(assicuratoString[2]);
			assicurato.setCodiceFiscale(assicuratoString[3]);
			assicurato.setDataNascita(Date.valueOf(assicuratoString[4]));
			assicurato.setNuoviSinistri(Integer.valueOf(assicuratoString[5]));
			assicuratiDaVecchioDb.add(assicurato);
			System.out.println(i);
		}
		return assicuratiDaVecchioDb;
	}

}