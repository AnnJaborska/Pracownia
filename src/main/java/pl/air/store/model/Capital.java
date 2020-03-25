package pl.air.store.model;

public class  Capital extends Id{
	
    private String CapitalName;
 
    public Capital() {
    }
    
    public Capital(String name) {
    	
    	this.CapitalName = name;
    }

    public String getCapitalName() {
		return this.CapitalName;
	}

	public void setCapitalName(String capitalName) {
		this.CapitalName = capitalName;
	}

}
