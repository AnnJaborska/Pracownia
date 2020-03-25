package pl.air.runner;

import java.io.*;

import pl.air.store.model.Currency;


public class Kalkulator {

	public static double kalkulacja(int j, String currency, String value) throws NumberFormatException, IOException {
		double stawka = Double.parseDouble(value);
			double podatek = Ramka.dokumenty.get(j).getTax().getTaxLevel();
			double kosztUzyskania= Ramka.dokumenty.get(j).getCost().getCostValue();;
			double stawka1=stawka*22;
			double stawka2=stawka1-kosztUzyskania;
			double netto=stawka2-(stawka2*podatek);
			double a = API.getRate(currency);
			double nettoPLN=netto*a;
			
		return nettoPLN;	
	}
}
