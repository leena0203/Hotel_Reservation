package com.HotelReservation;
import java.time.temporal.ChronoField;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.lang.Iterable;

public class HotelReservation {
	public static ArrayList<Hotel> hotelList = new ArrayList<>(); 

	//	/**
	//	 * UC1_Add hotel name and week rate rate
	//	 */
	//	public static void addHotel(String name,int weekdayRate) {
	//		Hotel H1 = new Hotel(name,weekdayRate);
	//		hotelList.add(H1);
	//	}
	//
	//	/**
	//	 * UC3_Add hotel name and week rate rate and weekendRate
	//	 */
	//	public static void addHotel(String name,int weekdayRate,int weekendRate) {
	//		Hotel H1 = new Hotel(name,weekdayRate, weekendRate);
	//		hotelList.add(H1);
	//	}
	//
	//	/**
	//	 * UC5_Add hotel name,weekday rate,weekend rate, rating
	//	 * @param name
	//	 * @param weekdayRate
	//	 * @param weekendRate
	//	 * @param rating
	//	 */
	public static void addHotel() {
		//(String name,int weekdayRate,int weekendRate, int rating) {
		//Hotel H2 = new Hotel(name,weekdayRate, weekendRate, rating);
		Hotel H1= new Hotel("Lakewood", 110,90,3);
		Hotel H2= new Hotel("Bridgewood",150,50,4);
		Hotel H3= new Hotel("Ridgewood",220,150,5);
		hotelList.add(H1);
		hotelList.add(H2);
		hotelList.add(H3);
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
	 * UC4 Return hotel with cheapest rate and best rating
	 * @param arrival
	 * @param departure
	 * @return
	 */

	public  ArrayList<Hotel> minimumRate(){
		//(String arrival, String departure) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Arrival Date: ");
		String arrival = sc.nextLine();
		System.out.println("Enter Departure Date: ");
		String departure = sc.nextLine();
		//LocalDate localDate1 = stringToLocalDate(arrival);
		//LocalDate localDate2 = stringToLocalDate(departure);
		//int[] numOfDays = numberOfDays(arrival, departure);
		int[] numOfDays = numberOfDays(arrival, departure);
		int min = 0;
		ArrayList<Hotel> cheapestHotels = new ArrayList<Hotel>();
		HashMap<Hotel, Integer> hotelMap = new HashMap<Hotel, Integer>();
		//HashMap<Hotel, Integer> ratingMap = new HashMap<Hotel, Integer>();
		for(Hotel hotel : hotelList) {
			int totalRate = hotel.weekdayRate * numOfDays[0] + hotel.weekendRate * numOfDays[1];
			hotelMap.put(hotel, totalRate);
			//ratingMap.put(hotel, hotel.getRating());
		}
		min = Collections.min(hotelMap.values());
		for(Map.Entry<Hotel, Integer> entry : hotelMap.entrySet()) {
			if(entry.getValue() == min) {
				cheapestHotels.add(entry.getKey());
			}
		}

		//		int maxRating = 0; //Collections.max(ratingMap.values());
		//		//System.out.println(maxRating);
		//		String rated ="";
		//		for(Hotel hotel : cheapestHotels) {
		//			if(hotel.getRating() > maxRating) {
		//				//cheapestHotels.remove(hotel);
		//				rated = hotel.getName();
		//			}
		//			
		//		}
		//			rated = hotel.getName();
		//			maxRating = hotel.getRating();
		//		}
		//		System.out.println(rated + "Rating: "+maxRating+ " total rate: "+min);
		return cheapestHotels;
	}

	public  ArrayList<Hotel> bestRatedHotel(ArrayList<Hotel> cheapestHotels) {

		HashMap<Hotel, Integer> ratingMap = new HashMap<Hotel, Integer>();
		for(Hotel hotel : cheapestHotels) {
			ratingMap.put(hotel, hotel.getRating());
		}
		int maxRating =Collections.max(ratingMap.values()); 
		System.out.println(maxRating);
		System.out.println(cheapestHotels.size());
		for(Hotel hotel : cheapestHotels) {
			if(hotel.getRating() != maxRating) {
				cheapestHotels.remove(hotel);
				//rated = hotel.getName();
			}
		}
		System.out.println(cheapestHotels.size());
		return cheapestHotels;	

	}
	
	/**
	 * UC7_best rated hotel
	 * @return
	 */
	public ArrayList<Hotel> findCheapestBestRatedHotels(){
		ArrayList<Hotel> cheapestHotel = minimumRate();
		ArrayList<Hotel> bestRatedHotel = bestRatedHotel(cheapestHotel);
		return bestRatedHotel;
	}
	public int size() {
		return hotelList.size() ;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation Program");
		HotelReservation hotels = new HotelReservation();
		hotels.addHotel();
		ArrayList<Hotel> myhotels = hotels.minimumRate();
		for(Hotel hots : myhotels) {
			System.out.println(hots);

		}
		hotels.bestRatedHotel(myhotels);
	}
}


