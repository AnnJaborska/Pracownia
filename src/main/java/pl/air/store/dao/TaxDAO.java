package pl.air.store.dao;

import java.util.Collection;
import java.util.Map;

import pl.air.store.model.Tax;
import pl.air.store.repo.StoreRepo;

public class TaxDAO extends DAO{
	
	public TaxDAO(StoreRepo repo) {
		super(repo);
	}

	public Tax get(long id) {
		Map<Long, Tax> taxes = getTable();
		return taxes.get(id);
	}
	
	public Collection<Tax> list() {
		return getTable().values();
	}
	
	public long save(Tax one) {
		long id = one.getId();
		getTable().put(id, one);
		return id;
	}
	
	public void update(Tax one) {
		long id = one.getId();
		getTable().put(id, one);
	}
	
	public void delete (long id) {
		getTable().remove(id);
	}
	
	private Map<Long, Tax> getTable() {
		return repo.getTaxes();
	}
	
	
}
