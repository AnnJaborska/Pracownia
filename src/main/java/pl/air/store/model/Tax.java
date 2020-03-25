package pl.air.store.model;

public class Tax extends Id{
	
	private Double TaxLevel;
	 
    public Tax() {
    }
    
    public Tax(Double value) {
    	
    	this.TaxLevel = value;
    }

	public Double getTaxLevel() {
		return TaxLevel;
	}

	public void setTaxLevel(Double taxLevel) {
		TaxLevel = taxLevel;
	}

}
