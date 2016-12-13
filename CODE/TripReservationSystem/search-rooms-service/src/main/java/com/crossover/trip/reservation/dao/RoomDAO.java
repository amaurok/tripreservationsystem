package com.crossover.trip.reservation.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

/**
 * Provide data store access for the SearchRoomService.
 *
 */
public class RoomDAO {

	/**
	 * Search the available room by the criteria defined by the user.
	 * 
	 * @param query
	 * @return List<Document>
	 */
	public static List<Document> searchRooms(Document query) {
		
		MongoCollection<Document> rooms = ConnectionHelper.getDatabaseConnection().getCollection("rooms");
		List<Document> roomsDoc = new ArrayList<Document>();
		MongoCursor<Document> cursor = rooms.find(query).iterator();
		try {
		    while (cursor.hasNext()) {
		    	roomsDoc.add(cursor.next());
		    }
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return roomsDoc;
	}
}
