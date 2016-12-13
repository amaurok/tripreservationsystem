package com.crossover.trip.reservation.services;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.camel.Body;
import org.bson.Document;

import com.crossover.trip.reservation.dao.SearchReservationsHistoryDAO;
import com.fasterxml.jackson.databind.ObjectMapper;



public class SearchReservationsHistoryService {

	/**
	 * Perform the search of a reservations history by the criteria defined by the user.
	 * 
	 * @param searchCriteria
	 * @return List<StringBuilder>
	 * @throws Exception
	 */
	public List<StringBuilder> searchReservations(@Body HashMap<String, String> searchCriteria)
	throws Exception {			
		
		if(searchCriteria.get("startDate").isEmpty() || searchCriteria.get("startDate")== null) {
			
			throw new Exception("You must define a start date to perform the search of reservations.");
		}
		
		if(searchCriteria.get("endDate").isEmpty() || searchCriteria.get("endDate")== null) {
			
			throw new Exception("You must define an end date to perform the search of reservations.");
		}
		
		return SearchReservationsHistoryDAO.searchReservations(
				formatDate(searchCriteria.get("startDate")),
				formatDate(searchCriteria.get("endDate")));
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
	

}
