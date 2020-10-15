package com.HotelReservation;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {
	public static List<Hotel> hotelList = new ArrayList<>(); 

	/**
	 * UC1_Add hotel name and week rate rate
	 */
	public static void addHotel(String name,int weekdayRate) {
		Hotel H1 = new Hotel(name,weekdayRate);
		hotelList.add(H1);
		
	}
	/**
	 * UC3_Add hotel name and week rate rate and weekendRate
	 */
	public static void addHotel(String name,int weekdayRate,int weekendRate) {
		Hotel H1 = new Hotel(name,weekdayRate, weekendRate);
		hotelList.add(H1);
		
	}
	

	/**
	 * String to local date format
	 * @param date
	 * @return
	 */
	public static LocalDate stringToLocalDate(String value) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
		//convert String to LocalDate
		LocalDate localDate = LocalDate.parse(value, formatter);
		return localDate;
	}

	/**
	 * UC2_Cheapest hotel
	 * @param departure 
	 * @param arrival 
	 * @return 
	 */

	public  String cheapestHotel(String arrival, String departure) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter Arrival Date: ");
//		String arrival = sc.nextLine();
//		System.out.println("Enter Departure Date: ");
//		String departure = sc.nextLine();
		LocalDate localDate1 = stringToLocalDate(arrival);
		LocalDate localDate2 = stringToLocalDate(departure);
		// calculate difference
		int days = (int)Period.between(localDate1, localDate2).getDays();
		int cost = Integer.MAX_VALUE;
		String cheapHotel = "";
		for (Hotel hotel: hotelList ) {
			int newCost = hotel.weekdayRate*days ;
			if (newCost < cost) {
				cheapHotel = hotel.name;
				cost = newCost;
			}
		}
		System.out.println("Cheapest hotel : " + cheapHotel + ",  Rates : $" + cost);
		return cheapHotel;
		
	}
	public int size() {
		return hotelList.size() ;
	}

//	public static void main(String[] args) {
//		System.out.println("Welcome to Hotel Reservation Program");
//		addHotel();
//		//cheapestHotel("10 Sep 2020","11 Sep 2020");
//	}
}

