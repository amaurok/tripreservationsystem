package com.crossover.trip.reservation.domain;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 * Bean representing a customer in the system.
 *
 */
@Entity("users")
public class UserVO {

	@Id
	private ObjectId id;
	
	private String userId;
	
	private String userName;
	
	private String userLastName;
	
	@Reference
    private List<ReservationVO> reservations;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public List<ReservationVO> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationVO> reservations) {
		this.reservations = reservations;
	}

	public ObjectId getId() {
		return id;
	}
	
}
