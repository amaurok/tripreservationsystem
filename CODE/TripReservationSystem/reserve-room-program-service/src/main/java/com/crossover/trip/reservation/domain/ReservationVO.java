package com.crossover.trip.reservation.domain;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Entity class representing the reservation made by an user, for any a room or a trip program.
 *
 */
@Entity("reservations")
public class ReservationVO {

	@Id
	private ObjectId id;
	
	private ObjectId userId;
	
	private String roomId;
	
	private String tripProgramId;
	
	private Date reservationStartDate;
	
	private Date reservationEndDate;

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getTripProgramId() {
		return tripProgramId;
	}

	public void setTripProgramId(String tripProgramId) {
		this.tripProgramId = tripProgramId;
	}

	public Date getReservationStartDate() {
		return reservationStartDate;
	}

	public void setReservationStartDate(Date reservationStartDate) {
		this.reservationStartDate = reservationStartDate;
	}

	public Date getReservationEndDate() {
		return reservationEndDate;
	}

	public void setReservationEndDate(Date reservationEndDate) {
		this.reservationEndDate = reservationEndDate;
	}

	public ObjectId getId() {
		return id;
	}

	public ObjectId getUserId() {
		return userId;
	}

	public void setUserId(ObjectId userId) {
		this.userId = userId;
	}
	
}
