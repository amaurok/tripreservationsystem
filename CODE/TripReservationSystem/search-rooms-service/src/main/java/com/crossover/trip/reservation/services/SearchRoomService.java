package com.crossover.trip.reservation.services;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.camel.Body;
import org.bson.Document;

import com.crossover.trip.reservation.dao.RoomDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implementation of the business need to search for available rooms.
 *
 */
public class SearchRoomService {

	/**
	 * Construct the query document to search for available rooms, based on the criteria defined by the user.
	 * 
	 * @param searchCriteria
	 * @return String
	 * @throws Exception
	 */
	public String searchRooms(@Body HashMap<String, String> searchCriteria)
	throws Exception {
		
		Set<Entry<String, String>> entries = searchCriteria.entrySet();
		Iterator<Entry<String, String>>it = entries.iterator();
		Document query = new Document();
		if(searchCriteria.containsKey("startDate") && searchCriteria.containsKey("endDate")) {
			List<Document> datesFilter = new ArrayList<Document>();
			datesFilter.add(new Document("reservationEndDate", new Document("$lte", formatDate(searchCriteria.get("startDate")))));
			datesFilter.add(new Document("reservationStartDate", new Document("$gte", formatDate(searchCriteria.get("endDate")))));
			query.put("$and", datesFilter);
		} 
			
		while(it.hasNext()) {
			Entry<String, String> entry = it.next();
			if(!entry.getKey().equals("startDate") && !entry.getKey().equals("endDate")) {
				addFormattedQueryParameters(entry.getKey(), entry.getValue(),query);
			}
		}
		
		return new ObjectMapper().writeValueAsString(RoomDAO.searchRooms(query));
		
	}
	
	/**
	 * Parse a string to a date.
	 * 
	 * @param date
	 * @return Date
	 * @throws ParseException
	 */
	private static Date formatDate(String date) 
	throws ParseException{
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		return df.parse(date);
		
	}
	
	/**
	 * Format the query parameters to the required format for mongo.
	 * @param name
	 * @param value
	 * @param query
	 */
	private static void addFormattedQueryParameters(
			String name,
			String value,
			Document query) {
		
		
		if(name.equals("accomodation") || name.equals("hotel")) {
			query.append(name, value);
			return;
		}
		if(name.equals("numAdults") || name.equals("numChildren")) {
			query.append(name, new Integer(value).intValue());
			return;
		}
		if(name.equals("price")) {
			query.append(name, new Double(value).doubleValue());
			return;
		}
		query.append(name, new Boolean(value).booleanValue());
	}

}
