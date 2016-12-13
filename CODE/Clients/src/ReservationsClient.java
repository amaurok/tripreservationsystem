import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class ReservationsClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			URL url = new URL("http://192.168.33.10:5672/saveReservation");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setDoOutput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json");
	        
	        String JSON_DATA =
                    "{" 
	        		+ "\"userId\": \"71380980\","
	        		+ "\"roomId\": \"\","
	        		+ "\"tripProgramId\": \"562cf5b793e8c90ddfa86eb5\","
	        		+ "\"reservationStartDate\": \"2015-10-28\","
	        		+ "\"reservationEndDate\": \"2015-10-31\""
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
            System.out.println("Successfully saved the reservation\n" +
            		"ObjectID created in the DB: "+sb.toString());
		 } catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
	}

}
