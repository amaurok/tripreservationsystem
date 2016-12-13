package com.crossover.trip.reservation.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Bean representing the features of a room, posted by a travel agent.
 *
 */
@Entity("rooms")
public class RoomFeatures {

	@Id
	private ObjectId id;
	
	private String accomodation;
	
	private double price;
	
	private boolean breakfastIncluded;
	
	private boolean phoneService;
	
	private boolean deluxeRoom;
	
	private boolean cableTV;
	
	private int numAdults;
	
	private int numChildren;

	public String getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(String accomodation) {
		this.accomodation = accomodation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ObjectId getId() {
		return id;
	}

	public boolean isBreakfastIncluded() {
		return breakfastIncluded;
	}

	public void setBreakfastIncluded(boolean breakfastIncluded) {
		this.breakfastIncluded = breakfastIncluded;
	}

	public boolean isPhoneService() {
		return phoneService;
	}

	public void setPhoneService(boolean phoneService) {
		this.phoneService = phoneService;
	}

	public boolean isDeluxeRoom() {
		return deluxeRoom;
	}

	public void setDeluxeRoom(boolean deluxeRoom) {
		this.deluxeRoom = deluxeRoom;
	}

	public boolean isCableTV() {
		return cableTV;
	}

	public void setCableTV(boolean cableTV) {
		this.cableTV = cableTV;
	}

	public int getNumAdults() {
		return numAdults;
	}

	public void setNumAdults(int numAdults) {
		this.numAdults = numAdults;
	}

	public int getNumChildren() {
		return numChildren;
	}

	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	}

}
