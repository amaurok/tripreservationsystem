package com.crossover.trip.reservation.services;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;

import org.apache.camel.Body;
import org.bson.Document;

import com.crossover.trip.reservation.dao.LoginDAO;


public class LoginService {

	/**
	 * Provide login to an user,and returns the JSON Web Token for authentication and verification.
	 * 
	 * @param roomInfo
	 * @return String JSON Web Token
	 * @throws Exception
	 */
	public String authenticateUser(@Body HashMap<String, String> userCredentials)
	throws Exception {
		
		if(userCredentials.get("userId").isEmpty() || userCredentials.get("userId")== null) {
			
			throw new Exception("You must provide an user id to log in.");
		}
		
		if(userCredentials.get("password").isEmpty() || userCredentials.get("password")== null) {
			
			throw new Exception("You must provide an password to log in.");
		}
		
		Document userDoc = LoginDAO.getUser(userCredentials.get("userId"), userCredentials.get("password"));
		if(userDoc == null) {
			
			throw new Exception("Invalid login for the user id and password provided.");
		}
		
		return Jwts.builder().setSubject(userCredentials.get("userId"))
	            .claim("role", userDoc.getString("role")).setIssuedAt(new Date())
	            .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
	}
	

}
