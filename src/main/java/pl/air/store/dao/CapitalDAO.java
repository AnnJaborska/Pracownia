package pl.air.store.dao;

import java.util.Collection;
import java.util.Map;

import pl.air.store.model.Capital;
import pl.air.store.repo.StoreRepo;

public class CapitalDAO extends DAO{

	public CapitalDAO(StoreRepo repo) {
		super(repo);
	}

	public Capital get(long id) {
		Map<Long, Capital> countries = getTable();
		return countries.get(id);
	}
	
	public Collection<Capital> list() {
		return getTable().values();
	}
	
	public long save(Capital one) {
		long id = one.getId();
		getTable().put(id, one);
		return id;
	}
	
	public void update(Capital one) {
		long id = one.getId();
		getTable().put(id, one);
	}
	
	public void delete (long id) {
		getTable().remove(id);
	}
	
	private Map<Long, Capital> getTable() {
		return repo.getCapitals();
	}
	
	
}
