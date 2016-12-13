package com.crossover.trip.reservation.dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

/**
 * Provide services to access the data store, for the business functions associated to login and user authentication.
 *
 */
public class LoginDAO {

	/**
	 * Search for the existence of a given user, based on the username and password.
	 * 
	 * @param userId
	 * @param userPassword
	 * @return Document
	 */
	public static Document getUser(
			String userId,
			String userPassword) {
		
		MongoCollection<Document> users = ConnectionHelper.getDatabaseConnection().getCollection("users");
		
		return users.find(and(eq("userId", userId), eq("password", userPassword))).first();
				
	}

}
