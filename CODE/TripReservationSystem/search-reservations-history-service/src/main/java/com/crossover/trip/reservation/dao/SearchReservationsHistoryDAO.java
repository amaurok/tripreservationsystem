package com.crossover.trip.reservation.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.*;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class SearchReservationsHistoryDAO {

	/**
	 * Search the history of reservations, according to the criteria defined by the user.
	 * 
	 * @param Date startDate
	 * @param Date endDate
	 * @return List<Document>
	 */
	public static List<StringBuilder> searchReservations(
			Date startDate,
			Date endDate) {
		
		MongoCollection<Document> reservations = ConnectionHelper.getDatabaseConnection().getCollection("reservations");
		MongoCollection<Document> users = ConnectionHelper.getDatabaseConnection().getCollection("users");
		MongoCollection<Document> rooms = ConnectionHelper.getDatabaseConnection().getCollection("rooms");
		MongoCollection<Document> programs = ConnectionHelper.getDatabaseConnection().getCollection("tripprograms");
		
		List<StringBuilder> docs = new ArrayList<StringBuilder>();
		MongoCursor<Document> cursor = reservations.find(and(gte("reservationStartDate", startDate), lte("reservationEndDate", endDate))).iterator();
		try {
		    while (cursor.hasNext()) {
		    	Document revDoc = cursor.next();
		    	
		    	//Clean the output
		    	revDoc.remove("className");
		    	revDoc.remove("counter");
		    	revDoc.remove("processIdentifier");
		    	revDoc.remove("machineIdentifier");
		    	StringBuilder buf = new StringBuilder();
		    	
		    	Document doc = users.find(eq("_id",revDoc.getObjectId("userId"))).first();
		    	if(doc != null) {
		    		revDoc.append("userName", doc.getString("userName"));
		    	}
		    	buf.append(revDoc.toJson());
		    	if(revDoc.getString("tripProgramId")!= null && !revDoc.getString("tripProgramId").equals("")) {
		    		doc = programs.find(eq("_id",new ObjectId(revDoc.getString("tripProgramId")))).first();
		    		if(doc != null) {
		    			buf.append(doc.toJson());
		    		}
		    	}	
		    		
		    	if(revDoc.getString("roomId") != null && !revDoc.getString("roomId").equals("")) {
		    		doc = rooms.find(eq("_id",new ObjectId(revDoc.getString("roomId")))).first();
		    		if(doc != null) { 
		    			buf.append(doc.toJson());
		    		}
		    	}
		    	
		    	docs.add(buf);
		    }
		} finally {
		    cursor.close();
		}
		
		return docs;
	}

}
