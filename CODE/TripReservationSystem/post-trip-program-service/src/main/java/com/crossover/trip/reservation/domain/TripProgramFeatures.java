package com.crossover.trip.reservation.domain;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Bean representing the features of a trip program, posted by a travel agent.
 *
 */
@Entity("tripprograms")
public class TripProgramFeatures {

	@Id
	private ObjectId id;
	
	private String origin;
	
	private String destination;
	
	private double price;
	
	private boolean insuranceIncluded;
	
	private int numAdults;
	
	private int numChildren;
	
	private String hotelName;
	
	private int numDays;
	
	private Date availableFrom;
	
	private Date endDate;
	
	private String currency;
	
	private boolean carIncluded;

	public ObjectId getId() {
		return id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isInsuranceIncluded() {
		return insuranceIncluded;
	}

	public void setInsuranceIncluded(boolean insuranceIncluded) {
		this.insuranceIncluded = insuranceIncluded;
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

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getNumDays() {
		return numDays;
	}

	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}

	public Date getAvailableFrom() {
		return availableFrom;
	}

	public void setAvailableFrom(Date availableFrom) {
		this.availableFrom = availableFrom;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isCarIncluded() {
		return carIncluded;
	}

	public void setCarIncluded(boolean carIncluded) {
		this.carIncluded = carIncluded;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
