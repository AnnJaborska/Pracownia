package pl.air.store.dao;

import java.util.Collection;
import java.util.Map;

import pl.air.store.model.Currency;
import pl.air.store.repo.StoreRepo;

public class CurrencyDAO extends DAO{
	
	public CurrencyDAO(StoreRepo repo) {
		super(repo);
	}

	public Currency get(long id) {
		Map<Long, Currency> currencies = getTable();
		return currencies.get(id);
	}
	
	public Collection<Currency> list() {
		return getTable().values();
	}
	
	public long save(Currency one) {
		long id = one.getId();
		getTable().put(id, one);
		return id;
	}
	
	public void update(Currency one) {
		long id = one.getId();
		getTable().put(id, one);
	}
	
	public void delete (long id) {
		getTable().remove(id);
	}
	
	private Map<Long, Currency> getTable() {
		return repo.getCurrencies();
	}
	
	
}
