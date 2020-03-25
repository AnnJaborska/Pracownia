package pl.air.store.model;

public class  Country extends Id{
	
    private String CountryName;
 
    public Country() {
    }
    
    public Country(String name) {
    	
    	this.CountryName = name;
    }

    public String getCountryName() {
		return this.CountryName;
	}

	public void setCountryName(String countryName) {
		this.CountryName = countryName;
	}

}
