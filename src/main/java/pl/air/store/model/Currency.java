package pl.air.store.model;

public class  Currency extends Id{
	
    private String CurrencyName;
 
    public Currency() {
    }
    
    public Currency(String name) {
    	
    	this.CurrencyName = name;
    }

	public String getCurrencyName() {
		return CurrencyName;
	}

	public void setCurrencyName(String currencyName) {
		CurrencyName = currencyName;
	}


}

