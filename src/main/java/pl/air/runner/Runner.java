package pl.air.runner;

import java.util.ArrayList;
import java.util.Collection;

import pl.air.store.dao.DokumentDAO;
import pl.air.store.model.Dokument;
import pl.air.store.repo.StoreRepo;
import pl.air.store.service.CreateService;
import pl.air.store.service.PrintService;

public class Runner {

	public static void main(String[] args) {
	StoreRepo repo = new StoreRepo();
	CreateService createSrv = new CreateService(repo);
	PrintService printSrv = new PrintService(System.out);
	
	createSrv.createData();
	
	DokumentDAO dokDAO = new DokumentDAO(repo);
	Collection<Dokument> doks= dokDAO.list();
	
	ArrayList<Dokument> dok = new ArrayList<Dokument>(); 

	for (Dokument d : doks) {
		dok.add(d);
	}
	
	//for (Dokument d : dok) {
	//	printSrv.printDokument(d);
	//}
	
	Ramka mojaRamka = new Ramka(dok);
	mojaRamka.setVisible(true);


	}

}
