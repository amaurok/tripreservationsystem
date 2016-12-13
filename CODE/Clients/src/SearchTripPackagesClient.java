import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class SearchTripPackagesClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			URL url = new URL("http://192.168.33.10:5675/getTripPackages");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setDoOutput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json");
	        
	        String JSON_DATA =
	        		"{" 
        				+ "\"destination\": \"Canada\","
    	        		+ "\"price\": \"2500\","
    	        		+ "\"endDate\": \"2015-11-28\","
    	        		+ "\"startDate\": \"2015-09-28\""
	    	        + "}";
	        OutputStream os = conn.getOutputStream();
            os.write(JSON_DATA.getBytes());
            os.flush();
            System.out.println("Response Code: "+conn.getResponseCode()+" Response Message: "+conn.getResponseMessage());
            
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
            	sb.append(output);
            }
            System.out.println("Trips Packages\n" +sb.toString());
		 } catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
	}

}
