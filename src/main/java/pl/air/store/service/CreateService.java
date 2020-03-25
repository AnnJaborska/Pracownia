package pl.air.store.service;

import pl.air.store.dao.CapitalDAO;
import pl.air.store.dao.CostDAO;
import pl.air.store.dao.CountryDAO;
import pl.air.store.dao.CurrencyDAO;
import pl.air.store.dao.DokumentDAO;
import pl.air.store.dao.TaxDAO;
import pl.air.store.model.Capital;
import pl.air.store.model.Cost;
import pl.air.store.model.Country;
import pl.air.store.model.Currency;
import pl.air.store.model.Dokument;
import pl.air.store.model.Tax;
import pl.air.store.repo.StoreRepo;

public class CreateService {
	
	private StoreRepo repo;
	
	public CreateService(StoreRepo repo) {
		this.repo=repo;
	}
	
	public Country createCountry(String countryName) {
		Country one = new Country(countryName);
		CountryDAO dao = new CountryDAO(repo);
		dao.save(one);
		return one;
	}
	
	public Capital createCapital(String capitalName) {
		Capital one = new Capital(capitalName);
		CapitalDAO dao = new CapitalDAO(repo);
		dao.save(one);
		return one;
	}
	
	public Currency createCurrency(String currencyName) {
		Currency one = new Currency(currencyName);
		CurrencyDAO dao = new CurrencyDAO(repo);
		dao.save(one);
		return one;
	}
	public Cost createCost(Double costValue) {
		Cost one = new Cost(costValue);
		CostDAO dao = new CostDAO(repo);
		dao.save(one);
		return one;
	}
	public Tax createTax(Double taxLevel) {
		Tax one = new Tax(taxLevel);
		TaxDAO dao = new TaxDAO(repo);
		dao.save(one);
		return one;
	}
	
	public Dokument createDokument
	(Country country, Capital capital, Currency currency, Cost cost, Tax tax) { 
		Dokument one = new Dokument();
		one.setCountry(country);
		one.setCurrency(currency);
		one.setCost(cost);
		one.setTax(tax);
		one.setCapital(capital);
		DokumentDAO dao = new DokumentDAO(repo);
		dao.save(one);
		return one;
	}
	
	public void createData() {
		
		Country GB = createCountry("Wielka Brytania");
		Country DB = createCountry("Niemcy");
		Country PL = createCountry("Polska");
		
		Capital Londyn = createCapital("Londyn");
		Capital Berlin = createCapital("Berlin");
		Capital Warszawa = createCapital("Warszawa");
		
		Currency GBP = createCurrency("GBP");
		Currency EUR = createCurrency("EUR");
		Currency PLN = createCurrency("PLN");
		
		Cost one = createCost(600.0);
		Cost two = createCost(800.0);
		Cost three = createCost(1200.0);
		
		Tax level1 = createTax(0.25);
		Tax level2 = createTax(0.20);
		Tax level3 = createTax(0.19);
		
		
		// ---------- Dokumenty ---------		
		
		Dokument Anglia = createDokument(GB, Londyn, GBP, one, level1);
		Dokument Niemcy = createDokument(DB, Berlin, EUR, two, level2);
		Dokument Polska = createDokument(PL, Warszawa, PLN, three, level3);

	}

}
