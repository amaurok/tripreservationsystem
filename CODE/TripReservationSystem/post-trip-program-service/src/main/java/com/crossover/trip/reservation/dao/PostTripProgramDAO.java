package com.crossover.trip.reservation.dao;

import org.bson.types.ObjectId;

import com.crossover.trip.reservation.domain.TripProgramFeatures;


public class PostTripProgramDAO {

	/**
	 * Save a new trip program posted by a travel agent.
	 * 
	 * @param trip
	 * @return ObjectId
	 */
	public static ObjectId saveTripProgram(
			TripProgramFeatures trip) {
		
		ConnectionHelper.getDataStore().save(trip);
		
		return trip.getId();
	}

}
