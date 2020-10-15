package com.HotelReservation;
import java.time.temporal.ChronoField;
import java.time.DayOfWeek;
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
	 * UC5_Add hotel name,weekday rate,weekend rate, rating
	 * @param name
	 * @param weekdayRate
	 * @param weekendRate
	 * @param rating
	 */
	public static void addHotel(String name,int weekdayRate,int weekendRate, int rating) {
		Hotel H2 = new Hotel(name,weekdayRate, weekendRate, rating);
		hotelList.add(H2);
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
	 * method to find weekdays and weekends
	 * @param arrival
	 * @param departure
	 * @return
	 */
	public static int[] numberOfDays(String arrival, String departure) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
		// convert String to LocalDate
		LocalDate from = LocalDate.parse(arrival, formatter);
		LocalDate to = LocalDate.parse(departure, formatter);
		int numOfweekdays = 0;
		int numOfWeekends = 0;
		for (LocalDate date = from; date.isBefore(to.plusDays(1)); date = date.plusDays(1)) {
			DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK)); // returns enum of day
			switch (day) {
			case SATURDAY:
				numOfWeekends++;
				break;
			case SUNDAY:
				numOfWeekends++;
				break;
			default:
				numOfweekdays++;
				break;
			}
		}
		return new int[] { numOfweekdays, numOfWeekends };
	}

	/**
	 * UC2_Cheapest hotel
	 * UC4_Refactored to find cheapest hotel with weekends rate
	 * @param departure 
	 * @param arrival 
	 * @return 
	 */

	public static  String cheapestHotel(String arrival, String departure) {
		//		Scanner sc = new Scanner(System.in);
		//		System.out.println("Enter Arrival Date: ");
		//		String arrival = sc.nextLine();
		//		System.out.println("Enter Departure Date: ");
		//		String departure = sc.nextLine();
		LocalDate localDate1 = stringToLocalDate(arrival);
		LocalDate localDate2 = stringToLocalDate(departure);
		int[] numOfDays = numberOfDays(arrival, departure);
		int cost = Integer.MAX_VALUE;
		String cheapHotel = "";
		for (Hotel hotel: hotelList ) {
			int newCost1 = hotel.weekdayRate*numOfDays[0] ;
			int newcost2 = hotel.weekendRate*numOfDays[1];
			int newCost = newCost1 + newcost2;
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
	//		cheapestHotel();
	//	}
}

