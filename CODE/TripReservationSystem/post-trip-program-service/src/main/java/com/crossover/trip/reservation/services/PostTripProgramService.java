package com.crossover.trip.reservation.services;


import java.util.HashMap;

import org.apache.camel.Body;
import org.bson.types.ObjectId;

import com.crossover.trip.reservation.dao.PostTripProgramDAO;
import com.crossover.trip.reservation.domain.TripProgramFeatures;
import com.fasterxml.jackson.databind.ObjectMapper;



public class PostTripProgramService {

	/**
	 * Save the information of a new room available, posted by a travel agent.
	 * 
	 * @param roomInfo
	 * @return ObjectId
	 * @throws Exception
	 */
	public ObjectId saveTripProgram(@Body HashMap<String, String> tripProgramInfo)
	throws Exception {
				
		TripProgramFeatures program = new ObjectMapper().readValue(new ObjectMapper().writeValueAsString(tripProgramInfo), TripProgramFeatures.class);
				
		return PostTripProgramDAO.saveTripProgram(program);
	}
	

}
