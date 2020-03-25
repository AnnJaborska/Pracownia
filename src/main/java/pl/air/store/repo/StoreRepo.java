package pl.air.store.repo;


import java.util.HashMap;
import java.util.Map;

import pl.air.store.model.Capital;
import pl.air.store.model.Cost;
import pl.air.store.model.Country;
import pl.air.store.model.Currency;
import pl.air.store.model.Dokument;
import pl.air.store.model.Tax;


public class StoreRepo {
	
	private Map<Long, Country> countries = new HashMap<>();
	private Map<Long, Capital> capitals = new HashMap<>();
	private Map<Long, Currency> currencies = new HashMap<>();
	private Map<Long, Cost> costs = new HashMap<>();
	private Map<Long, Tax> taxes = new HashMap<>();
	private Map<Long, Dokument> documents = new HashMap<>();
	
	public StoreRepo() {		
	}

	public Map<Long, Country> getCountries() {
		return countries;
	}

	public Map<Long, Currency> getCurrencies() {
		return currencies;
	}

	public Map<Long, Cost> getCosts() {
		return costs;
	}
	public Map<Long, Tax> getTaxes() {
		return taxes;
	}

	public Map<Long, Dokument> getDocuments() {
		return documents;
	}

	public Map<Long, Capital> getCapitals() {
		return capitals;
	}
	

}
