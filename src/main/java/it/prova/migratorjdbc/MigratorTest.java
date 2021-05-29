package it.prova.migratorjdbc;

import java.util.List;
import java.util.stream.Collectors;

import it.prova.migratorjdbc.model.Assicurato;
import it.prova.migratorjdbc.model.NotProcessed;
import it.prova.migratorjdbc.service.AssicuratoService;
import it.prova.migratorjdbc.service.CsvReaderServiceImpl;
import it.prova.migratorjdbc.service.MyServiceFactory;

public class MigratorTest {

	public static void main(String[] args) throws Exception {

		AssicuratoService assicuratoService = MyServiceFactory.getAssicuratoServiceImpl();
//-------------DATA MIGRATOR FROM CSV-------------------

		List<Assicurato> assicuratiDaVecchioDb = CsvReaderServiceImpl.readCsv("C:/Users/NEW ROOM/Desktop/CsvAssiucrato.csv");

		List<Assicurato> assicurati = assicuratiDaVecchioDb.stream()
				.filter(assicurato -> assicurato.getCodiceFiscale().length() == 16).collect(Collectors.toList());
		List<Assicurato> assicuratiNotProcessed = assicuratiDaVecchioDb.stream()
				.filter(assicurato -> assicurato.getCodiceFiscale().length() != 16).collect(Collectors.toList());

		assicurati.stream().forEach(assicuratoItem -> {
			try {
				assicuratoService.inserisciNuovo(assicuratoItem);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		assicuratiNotProcessed.stream().forEach(assicuratoNonProcessatoItem -> {
			try {
				NotProcessed notProcessedItem = new NotProcessed();
				notProcessedItem.setCodiceFiscale(assicuratoNonProcessatoItem.getCodiceFiscale());
				notProcessedItem.setOldId(assicuratoNonProcessatoItem.getId().toString());
				assicuratoService.inserisciNotProcessed(notProcessedItem);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

//-------------DATA MIGRATO BETWEEN DB'S-------------------
//		OldSchemaService oldSchemaService = MyServiceFactory.getOldSchemaServiceImpl();
//
//		List<OldSchema> oldData = oldSchemaService.listAll();
//		
//		for(OldSchema dataItem : oldData) {
//			if(dataItem.getCodiceFiscale().length() != 16 || dataItem.getCognome() == null || dataItem.getNome() == null) {
//				NotProcessed notProcessedTemp = new NotProcessed();
//				notProcessedTemp.setCodiceFiscale(dataItem.getCodiceFiscale());
//				notProcessedTemp.setOldId(dataItem.getId().toString());
//				
//				assicuratoService.inserisciNotProcessed(notProcessedTemp);
//			}else {
//				Assicurato assicuratoTemp = new Assicurato();
//				assicuratoTemp.setNome(dataItem.getNome());
//				assicuratoTemp.setCognome(dataItem.getCognome());
//				assicuratoTemp.setCodiceFiscale(dataItem.getCodiceFiscale());
//				assicuratoTemp.setDataNascita(dataItem.getDataNascita());
//				assicuratoTemp.setNuoviSinistri(dataItem.getNumeroSinistri());
//				
//				assicuratoService.inserisciNuovo(assicuratoTemp);
//			}
//		}

	}
}
