import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class PostTripPackagesClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			URL url = new URL("http://192.168.33.10:5677/postTripProgram");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setDoOutput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json");
	        
	        String JSON_DATA =
                    "{" 
	        		+ "\"origin\": \"USA\","
	        		+ "\"destination\": \"Canada\","
	        		+ "\"price\": \"2500\","
	        		+ "\"carIncluded\": \"true\","
	        		+ "\"numAdults\": \"2\","
	        		+ "\"numChildren\": \"0\","
	        		+ "\"currency\": \"USD\","
	        		+ "\"hotelName\": \"Calypso Cay\","
	        		+ "\"numDays\": \"8\","
	        		+ "\"availableFrom\": \"2015-10-03\","
	        		+ "\"endDate\": \"2015-10-29\","
	        		+ "\"insuranceIncluded\": \"false\""
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
            System.out.println("Successfully posted the new trip package\n" +
            		"ObjectID created in the DB: "+sb.toString());
		 } catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
	}

}
