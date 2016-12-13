package com.crossover.trip.reservation.dao;

import org.bson.types.ObjectId;

import com.crossover.trip.reservation.domain.RoomFeatures;

/**
 * Provide services to access the data store, for the business functions associated to post available rooms.
 *
 */
public class PostRoomDAO {

	/**
	 * Save a new room posted as available by a travel agent.
	 * 
	 * @param room
	 * @return ObjectId
	 */
	public static ObjectId saveRoom(
			RoomFeatures room) {
		
		ConnectionHelper.getDataStore().save(room);
		
		return room.getId();
	}

}
