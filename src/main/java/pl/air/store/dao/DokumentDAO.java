package pl.air.store.dao;

import java.util.Collection;
import java.util.Map;

import pl.air.store.model.Dokument;
import pl.air.store.repo.StoreRepo;

public class DokumentDAO extends DAO{
	

	public DokumentDAO(StoreRepo repo) {
		super(repo);
	}

	public Dokument get(long id) {
		Map<Long, Dokument> documents = getTable();
		return documents.get(id);
	}
	
	public Collection<Dokument> list() {
		return getTable().values();
	}
	
	public long save(Dokument one) {
		long id = one.getId();
		getTable().put(id, one);
		return id; 
	}
	
	public void update(Dokument one) {
		long id = one.getId();
		getTable().put(id, one);
	}
	
	public void delete (long id) {
		getTable().remove(id);
	}
	
	private Map<Long, Dokument> getTable() {
		return repo.getDocuments();
	}
	
	
}
