package com.HotelReservation;

public class HotelReservation {
/**
 * UC1_Add hotel name
 */
	public static void addHotel() {
		Hotel H1 = new Hotel("Lakewood",110,90);
		Hotel H2 = new Hotel("Bridgewood",160,60);
		Hotel H3 = new Hotel("Ridgewood",220,150);
	}

	public static void main(String[] args) {
		HotelReservation hotelReservation = new HotelReservation();
		System.out.println("Welcome to Hotel Reservation Program");
		addHotel();
	}
}
