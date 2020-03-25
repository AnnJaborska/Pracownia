package pl.air.store.service;

import java.io.PrintStream;

import pl.air.store.model.Capital;
import pl.air.store.model.Cost;
import pl.air.store.model.Country;
import pl.air.store.model.Currency;
import pl.air.store.model.Dokument;
import pl.air.store.model.Id;
import pl.air.store.model.Tax;



public class PrintService {
	
	private PrintStream output;
	
	public PrintService(PrintStream output) {
		this.output = output;
	}
	
	private  String printId(Id idEntity) {
		return " (id=" + idEntity.getId() + ")";
	}
	
	public  void printCountry(Country country) {
		output.println(country.getCountryName()+ printId(country));
	}
	public  void printCapital(Capital capital) {
		output.println(capital.getCapitalName()+ printId(capital));
	}
	public  void printCurrency(Currency currency) {
		output.println(currency.getCurrencyName()+ printId(currency));
	}
	public  void printCost(Cost cost) {
		output.println(cost.getCostValue()+ printId(cost));
	}
	public  void printTax(Tax tax) {
		output.println(tax.getTaxLevel()+ printId(tax));
	}
	
	
	public  void printDokument(Dokument doc) {
		
		Country country = doc.getCountry();
		printCountry(country);
		
		Capital capital = doc.getCapital();
		printCapital(capital);
		
		Currency currency = doc.getCurrency();
		printCurrency(currency);
		
		Cost cost = doc.getCost();
		printCost(cost);
		
		Tax tax = doc.getTax();
		printTax(tax);
	
		output.println();
		
	}

}
