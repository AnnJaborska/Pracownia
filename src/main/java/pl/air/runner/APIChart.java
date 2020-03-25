package pl.air.runner;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class APIChart {
	
public static Double displayTimeSeriesChart(String currency) throws IOException {
    	
    if (currency=="PLN") {
    	double a = 1;
    	return a;
    } else {
        
        String current_date = "";
        String back_date = "";
        
        try { 
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();

            // current date
            cal.add(Calendar.DATE, 0);
            current_date = dateFormat.format(cal.getTime());
            System.out.println(current_date);
            // -90 days
            cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -90);
            back_date = dateFormat.format(cal.getTime());
            System.out.println(back_date);
        } catch (Exception e) {  
        }

        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/a/"+
                currency+"/"+back_date+"/"+current_date+"/?format=json");
        
        HttpURLConnection c = (HttpURLConnection) url.openConnection();
        c.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }   
        in.close();

        JSONObject json = new JSONObject(sb.toString());
        JSONArray jsonArray = json.getJSONArray("rates");
      
        Double a = 0.0;
        XYSeries series1 = new XYSeries("First");
        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject value = jsonArray.getJSONObject(i); 
            a = (Double) value.get("mid");
            System.out.println(a);
            series1.add(i, a);
        }
            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(series1);

           
			JFreeChart chart = ChartFactory.createXYLineChart
					("Line Chart" + currency, "Time", "Exchange rate", dataset,
					PlotOrientation.VERTICAL, true, true, false);
		

            // create and display a window(frame)
            ChartFrame frame = new ChartFrame("Wykres LiniowyXY", chart);
            frame.pack();
            frame.setVisible(true);
            return a;
    	}
    }




public static Double ObtainData(String currency) throws IOException {
	
	if (currency=="PLN") {
    	double a = 1;
    	return a;
    } else {

    URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/a/"+currency+"/?format=json");
    HttpURLConnection c = (HttpURLConnection) url.openConnection();
    c.setRequestMethod("GET");
    BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
    StringBuilder sb = new StringBuilder();
    String line;
    
    while ((line = in.readLine()) != null) {
        sb.append(line);
        //System.out.println(line);
    }   
    in.close();

    JSONObject json = new JSONObject(sb.toString());
    JSONArray jsonArray = json.getJSONArray("rates");
    //JSONObject rates = json.get("rates");
  
        Double a = 0.0;
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject value = jsonArray.getJSONObject(i); 
        a = (Double) value.get("mid");
    }
        return a;
}
}

public static void displayBarChart(String currency) throws IOException {
	
	
	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	dataset.addValue(ObtainData(currency), "Row 1", currency);
	dataset.addValue(ObtainData("EUR"), "Row 1", "EUR");
	dataset.addValue(ObtainData("USD"), "Row 1", "USD");
	dataset.addValue(ObtainData("CHF"), "Row 1", "CHF");

	
			JFreeChart chart = ChartFactory.createBarChart("Bar Chart " + currency + " vs. another currencies",
					"Currency", "Exchange rate to PLN", dataset, PlotOrientation.VERTICAL, true, true, false);
	
	CategoryPlot plot = (CategoryPlot) chart.getPlot(); 
	BarRenderer renderer = (BarRenderer) plot.getRenderer();
	renderer.setSeriesPaint(0, Color.orange);
	
	ChartFrame frame = new ChartFrame("Wykres słupkowy", chart);
	frame.pack();
	frame.setVisible(true);
}
	
}

