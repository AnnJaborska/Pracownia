package pl.air.store.model;

public abstract class Id { 
	
	private static long currentId=1;
	protected long id; 
	
	public Id() {
		this.id = nextId();
	}
	private long nextId() {
		return currentId++;
	}
	
	
	public long getId() {
		return this.id;
	}

}
