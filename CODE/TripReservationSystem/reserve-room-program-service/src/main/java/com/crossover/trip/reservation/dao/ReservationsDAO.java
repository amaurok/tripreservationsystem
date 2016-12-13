package com.crossover.trip.reservation.dao;


import com.crossover.trip.reservation.domain.ReservationVO;
import com.crossover.trip.reservation.domain.UserVO;


/**
 * Provide services to access the data store, for the business functions associated with the reservations.
 *
 */
public class ReservationsDAO {

	/**
	 * Save a new reservation made by a customer.
	 * 
	 * @param user
	 */
	public static void saveReservation(ReservationVO reservation) {
		
		ConnectionHelper.getDataStore().save(reservation);
	}
	
	/**
	 * Find a customer by id.
	 * 
	 * @param userId
	 * @return UserVO
	 */
	public static UserVO findCustomerById(
			String userId) {
		
		return ConnectionHelper.getDataStore().createQuery(UserVO.class).filter("userId =", userId).get();
	}
	
}
