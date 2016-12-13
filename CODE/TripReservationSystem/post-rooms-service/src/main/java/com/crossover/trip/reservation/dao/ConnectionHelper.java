package com.crossover.trip.reservation.dao;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class ConnectionHelper {

	/**
	 * Parameters to connect to the NonSQL database.
	 */
	private static final String database = "tripsreservations";
	private static Datastore datastore;
	private static Morphia morphia;
	
	
	/**
	 * Returns the Datastore instance (singleton), used to access the datastore.
	 * This is an implementation of the singleton pattern, to guarantee the same instance is available to the callers.
	 * 
	 * @return Datastore
	 */
	public static synchronized Datastore getDataStore() {

        if (datastore == null) {
            synchronized (ConnectionHelper.class) {
            	/*
            	 * Check again to guarantee an unique datastore instance is created, if any thread was preempted.
            	 */
                if (datastore == null) {
                	datastore = getMorphia().createDatastore(new MongoClient(), database);
                }
            }
        }

        return datastore;
    }
	
	/**
	 * Returns the Morphia instance (singleton), used to perform the CRUD operations in the collections.
	 * This is an implementation of the singleton pattern, to guarantee the same instance is available to the callers.
	 * 
	 * @return Morphia
	 */
	public static synchronized Morphia getMorphia() {
		
		if (morphia == null) {
            synchronized (ConnectionHelper.class) {
            	/*
            	 * Check again to guarantee an unique morphia instance is created, if any thread was preempted.
            	 */
                if (morphia == null) {
                	morphia = new Morphia();
                }
            }
        }
		
		 return morphia;
	}	

}
