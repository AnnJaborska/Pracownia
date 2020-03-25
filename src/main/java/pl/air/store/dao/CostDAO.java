package pl.air.store.dao;

import java.util.Collection;
import java.util.Map;

import pl.air.store.model.Cost;
import pl.air.store.repo.StoreRepo;

public class CostDAO extends DAO{
	
	public CostDAO(StoreRepo repo) {
		super(repo);
	}

	public Cost get(long id) {
		Map<Long, Cost> costs = getTable();
		return costs.get(id);
	}
	
	public Collection<Cost> list() {
		return getTable().values();
	}
	
	public long save(Cost one) {
		long id = one.getId();
		getTable().put(id, one);
		return id;
	}
	
	public void update(Cost one) {
		long id = one.getId();
		getTable().put(id, one);
	}
	
	public void delete (long id) {
		getTable().remove(id);
	}
	
	private Map<Long, Cost> getTable() {
		return repo.getCosts();
	}
	
	
}
