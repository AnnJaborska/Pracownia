package pl.air.runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class API {
	
	
public static Double getRate(String currency) throws IOException {
    	
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
}
