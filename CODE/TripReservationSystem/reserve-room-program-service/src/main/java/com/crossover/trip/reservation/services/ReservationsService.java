package com.crossover.trip.reservation.services;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.camel.Body;

import com.crossover.trip.reservation.dao.ReservationsDAO;
import com.crossover.trip.reservation.domain.ReservationVO;
import com.crossover.trip.reservation.domain.UserVO;


public class ReservationsService {

	/**
	 * Save the information of a new room available, posted by a travel agent.
	 * 
	 * @param reservationInfo
	 * @return String 
	 * @throws Exception
	 */
	public String saveReservation(@Body HashMap<String, String> reservationInfo)
	throws Exception {
				
		UserVO user = ReservationsDAO.findCustomerById(reservationInfo.get("userId"));
		if(user == null) {
			throw new Exception("The customer with ID "+reservationInfo.get("userId")+" doesn't exist.");
		}
		
		ReservationVO reservation = new ReservationVO();
		reservation.setRoomId(reservationInfo.get("roomId"));
		reservation.setTripProgramId(reservationInfo.get("tripProgramId"));
		reservation.setReservationStartDate(formatDate(reservationInfo.get("reservationStartDate")));
		reservation.setReservationEndDate(formatDate(reservationInfo.get("reservationEndDate")));
		reservation.setUserId(user.getId());
		
		ReservationsDAO.saveReservation(reservation);
		
		return "Successfully saved the reservation for the user "+user.getUserName();
	}
	
	/**
	 * Parse a string to a date.
	 * 
	 * @param date
	 * @return Date
	 * @throws ParseException
	 */
	private static Date formatDate(String date) 
	throws ParseException{
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		return df.parse(date);
		
	}
	

}
