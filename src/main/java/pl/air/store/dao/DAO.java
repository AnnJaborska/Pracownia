package pl.air.store.dao;

import pl.air.store.repo.StoreRepo;

public abstract class DAO {

	protected StoreRepo repo;
	
	public DAO(StoreRepo repo) {
		this.repo = repo;
	}
	
}
