package pl.air.runner;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.air.store.model.Currency;
import pl.air.store.model.Dokument;
import pl.air.store.model.Country;
import pl.air.store.model.Capital;
import pl.air.store.model.Cost;
import pl.air.store.model.Tax;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
public class Ramka extends JFrame implements ActionListener {

	static ArrayList<Dokument> dokumenty;
	ArrayList<JButton> przyciskiKraj;
	ArrayList<JTextField> polaTekstoweWaluta;
	ArrayList<JTextField> polaTekstoweStolica;
	ArrayList<JTextField> polaTekstoweKoszty;
	ArrayList<JTextField> polaTekstowePodatek;
	JPanel mojPanel;
	
	ArrayList<JButton> przyciski;
	JButton pDodaj;
	JButton pTechniczny;


	public Ramka(ArrayList<Dokument> Lista) {

		dokumenty = new ArrayList<Dokument>(Lista);
		mojPanel = new JPanel();
		add(mojPanel);
		wypelnijPanel();
		start();
	}
	
	public void start() {
		JOptionPane.showMessageDialog(null, "Kliknij na kraj w którym pracujesz aby obliczyć zarobki netto w PLN. \n"
				+ "Pamiętaj aby wprowadzać stawkę dzienną w walucie wybranego kraju!");
	}

	public void wypelnijPanel() {

		mojPanel.removeAll();
		
		setTitle("Zadanie zaliczeniowe");

		int a = dokumenty.size();
		GridLayout uklad = new GridLayout(a + 1,6,3,3);
		mojPanel.setLayout(uklad);
		przyciskiKraj = new ArrayList<JButton>();
		polaTekstoweWaluta = new ArrayList<JTextField>();
		polaTekstoweStolica = new ArrayList<JTextField>();
		polaTekstoweKoszty = new ArrayList<JTextField>();
		polaTekstowePodatek= new ArrayList<JTextField>();
		przyciski = new ArrayList<JButton>();
		
		
		pTechniczny = new JButton("Kraj");
		mojPanel.add(pTechniczny);
		pTechniczny = new JButton("Stolica");
		mojPanel.add(pTechniczny);
		pTechniczny = new JButton("Waluta");
		mojPanel.add(pTechniczny);
		pTechniczny = new JButton("Koszt staly");
		mojPanel.add(pTechniczny);
		pTechniczny = new JButton("Podatek");
		mojPanel.add(pTechniczny);
		
		pDodaj = new JButton("Dodaj");
		mojPanel.add(pDodaj);
		pDodaj.addActionListener(this);

		for (int i = 0; i < dokumenty.size(); i++) {

			JButton P2 = new JButton("Polska");
			P2.setText(dokumenty.get(i).getCountry().getCountryName());
			przyciskiKraj.add(P2);
			mojPanel.add(P2);
			P2.addActionListener(this);
			
			JTextField JFT2 = new JTextField();
			JFT2.setText(dokumenty.get(i).getCapital().getCapitalName());
			mojPanel.add(JFT2);
			JTextField JFT3 = new JTextField();
			JFT3.setText(dokumenty.get(i).getCurrency().getCurrencyName());
			mojPanel.add(JFT3);
			JTextField JFT4 = new JTextField();
			JFT4.setText(Double.toString((dokumenty.get(i).getCost().getCostValue())));
			mojPanel.add(JFT4);
			JTextField JFT5 = new JTextField();
			JFT5.setText(Double.toString((dokumenty.get(i).getTax().getTaxLevel())));
			mojPanel.add(JFT5);
			
			JButton P1 = new JButton("Usuń");
			przyciski.add(P1);
			mojPanel.add(P1);
			P1.addActionListener(this);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	public void actionPerformed(ActionEvent arg0) {
			Object zrodlo = arg0.getSource();
			for (int j = 0; j < przyciski.size(); j++) {
				if (zrodlo == przyciski.get(j)) {
					dokumenty.remove(j);
					break;
				} 
			}	
			for (int j = 0; j < przyciskiKraj.size(); j++) {
				if (zrodlo == przyciskiKraj.get(j)) {
					String value = JOptionPane.showInputDialog(null, "Wartość wynagrodzenia bturro/h",
							"Nowa kalkulacja", JOptionPane.OK_CANCEL_OPTION);
							String waluta = dokumenty.get(j).getCurrency().getCurrencyName();
							//System.out.println(waluta);
							double b=0;
							try {
								b = Kalkulator.kalkulacja(j, waluta, value);
							} catch (NumberFormatException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Twoje wynagrodzenie netto/miesiąc to:  \n"
									+ Double.toString(b));
							
							APIChart chart = new APIChart();
							try {
								chart.displayTimeSeriesChart(waluta);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							APIChart chart2 = new APIChart();
							try {
								chart2.displayBarChart(waluta);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				}
			}
			if (zrodlo == pDodaj) {
				String country = JOptionPane.showInputDialog(null, "Nazwa Kraju",
						"Nowy Kraj", JOptionPane.OK_CANCEL_OPTION);
				String capital = JOptionPane.showInputDialog(null, "Nazwa Stolicy",
						"Nowa Stolica", JOptionPane.OK_CANCEL_OPTION);
				String currency = JOptionPane.showInputDialog(null, "Waluta",
						"Waluta", JOptionPane.OK_CANCEL_OPTION);
				String cost1 = JOptionPane.showInputDialog(null, "Koszt uzyskania przychodu",
						"Koszt", JOptionPane.OK_CANCEL_OPTION);
				Double cost = Double.parseDouble(cost1);
				String tax1 = JOptionPane.showInputDialog(null, "Stawka podatkowa",
						"Podatek", JOptionPane.OK_CANCEL_OPTION);
				Double tax = Double.parseDouble(tax1);
				Dokument dokument4 = new Dokument();
				dokument4.setCountry(new Country(country));
				dokument4.setCapital(new Capital(capital));
				dokument4.setCurrency(new Currency(currency));
				dokument4.setCost(new Cost(cost));
				dokument4.setTax(new Tax(tax));
				dokumenty.add(dokument4);
				}
			wypelnijPanel();
	}
}
