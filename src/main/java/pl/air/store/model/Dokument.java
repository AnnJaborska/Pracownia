package pl.air.store.model;


public class Dokument extends Id{

	private Country country;
	private Currency currency;
	private Cost cost;
	private Tax tax;
	private Capital capital;

    public Dokument() {
    }
    

    public void setCountry(Country country) {
		this.country = country;
	}
	public Country getCountry() {
		return country;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Currency getCurrency() {
		return currency;
	} 
	public void setCost(Cost cost) {
		this.cost = cost;
	}
	public Cost getCost() {
		return cost;
	}
	public void setTax(Tax tax) {
		this.tax = tax;
	}
	public Tax getTax() {
		return tax;
	} 
	public void setCapital(Capital capital) {
		this.capital = capital;
	}
	public Capital getCapital() {
		return capital;
	} 
    
}
