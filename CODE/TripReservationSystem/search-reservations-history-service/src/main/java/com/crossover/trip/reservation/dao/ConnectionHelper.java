package com.crossover.trip.reservation.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class ConnectionHelper {

	/**
	 * Parameters to connect to the NonSQL database.
	 */
	private static final String database = "tripsreservations";
	private static MongoDatabase db;
	
	
	/**
	 * Returns the Datastore instance (singleton), used to access the datastore.
	 * This is an implementation of the singleton pattern, to guarantee the same instance is available to the callers.
	 * 
	 * @return Datastore
	 */
	public static synchronized MongoDatabase getDatabaseConnection() {

        if (db == null) {
            synchronized (ConnectionHelper.class) {
            	/*
            	 * Check again to guarantee an unique datastore instance is created, if any thread was preempted.
            	 */
                if (db == null) {
                	db =  new MongoClient( "localhost" , 27017 ).getDatabase(database);
                }
            }
        }

        return db;
    }
}
