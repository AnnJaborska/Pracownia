package pl.air.store.dao;

import java.util.Collection;
import java.util.Map;

import pl.air.store.model.Country;
import pl.air.store.repo.StoreRepo;

public class CountryDAO extends DAO{

	public CountryDAO(StoreRepo repo) {
		super(repo);
	}

	public Country get(long id) {
		Map<Long, Country> countries = getTable();
		return countries.get(id);
	}
	
	public Collection<Country> list() {
		return getTable().values();
	}
	
	public long save(Country one) {
		long id = one.getId();
		getTable().put(id, one);
		return id;
	}
	
	public void update(Country one) {
		long id = one.getId();
		getTable().put(id, one);
	}
	
	public void delete (long id) {
		getTable().remove(id);
	}
	
	private Map<Long, Country> getTable() {
		return repo.getCountries();
	}
	
	
}
