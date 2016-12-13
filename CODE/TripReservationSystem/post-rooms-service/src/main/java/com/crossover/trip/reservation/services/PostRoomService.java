package com.crossover.trip.reservation.services;


import java.util.HashMap;

import org.apache.camel.Body;
import org.bson.types.ObjectId;

import com.crossover.trip.reservation.dao.PostRoomDAO;
import com.crossover.trip.reservation.domain.RoomFeatures;
import com.fasterxml.jackson.databind.ObjectMapper;



public class PostRoomService {

	/**
	 * Save the information of a new room available, posted by a travel agent.
	 * 
	 * @param roomInfo
	 * @return ObjectId The new ObjectId assigned to the room saved in the datastore.
	 * @throws Exception
	 */
	public ObjectId saveRoom(@Body HashMap<String, String> roomInfo)
	throws Exception {
				
		RoomFeatures room = new ObjectMapper().readValue(new ObjectMapper().writeValueAsString(roomInfo), RoomFeatures.class);
		
		return PostRoomDAO.saveRoom(room);
	}
	

}
