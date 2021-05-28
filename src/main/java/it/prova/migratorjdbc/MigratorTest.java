package it.prova.migratorjdbc;

import java.util.List;

import it.prova.migratorjdbc.model.Assicurato;
import it.prova.migratorjdbc.model.NotProcessed;
import it.prova.migratorjdbc.model.OldSchema;
import it.prova.migratorjdbc.service.AssicuratoService;
import it.prova.migratorjdbc.service.MyServiceFactory;
import it.prova.migratorjdbc.service.OldSchemaService;

public class MigratorTest {

	public static void main(String[] args) throws Exception {

		AssicuratoService assicuratoService = MyServiceFactory.getAssicuratoServiceImpl();

		OldSchemaService oldSchemaService = MyServiceFactory.getOldSchemaServiceImpl();

		List<OldSchema> oldData = oldSchemaService.listAll();
		
		for(OldSchema dataItem : oldData) {
			if(dataItem.getCodiceFiscale().length() != 16 || dataItem.getCognome() == null || dataItem.getNome() == null) {
				NotProcessed notProcessedTemp = new NotProcessed();
				notProcessedTemp.setCodiceFiscale(dataItem.getCodiceFiscale());
				notProcessedTemp.setOldId(dataItem.getId().toString());
				
				assicuratoService.inserisciNotProcessed(notProcessedTemp);
			}else {
				Assicurato assicuratoTemp = new Assicurato();
				assicuratoTemp.setNome(dataItem.getNome());
				assicuratoTemp.setCognome(dataItem.getCognome());
				assicuratoTemp.setCodiceFiscale(dataItem.getCodiceFiscale());
				assicuratoTemp.setDataNascita(dataItem.getDataNascita());
				assicuratoTemp.setNuoviSinistri(dataItem.getNumeroSinistri());
				
				assicuratoService.inserisciNuovo(assicuratoTemp);
			}
		}
		
	}
}
