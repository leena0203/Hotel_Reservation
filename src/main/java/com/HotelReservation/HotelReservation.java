package com.HotelReservation;
import java.time.LocalDate;
import java.time.temporal.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Map.Entry;
import java.util.Scanner;

public class HotelReservation {
	static long totalDays,totalWeekDays,totalWeekEndDays;
	static String customerType;
	public ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
	/**
	 * UC1
	 * Function adds Hotel to the Hotel Reservation System
	 * @param input
	 * @return
	 */
	public void addHotel(Scanner input) {
		getInput(input);
		Hotel hotel1,hotel2,hotel3;
		if(customerType.equals("Regular")) {
			hotel1 = new Hotel("LakeWood", "Regular", 90, 4, 110);
			hotel2 = new Hotel("BridgeWood", "Regular", 50, 3, 150);
			hotel3 = new Hotel("RidgeWood" , "Regular", 150, 5, 220);
		}
		else {
			hotel1 = new Hotel("LakeWood", "Reward", 80, 4, 80);
			hotel2 = new Hotel("BridgeWood", "Reward", 50, 3, 110);
			hotel3 = new Hotel("RidgeWood" , "Reward", 40, 5, 100);
		}
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		hotelList.add(hotel3);
	}
	/**
	 * Get the list of hotels
	 * @return
	 */
	public ArrayList<Hotel> getHotelList() {
		return hotelList;
	}
	public void setHotelList(ArrayList<Hotel> hotelList) {
		this.hotelList = hotelList;
	}
	public void getInput(Scanner input) {
		LocalDate[] localDate = new LocalDate[2];
		String inputDate = "";
		inputDate = input.nextLine();
		//Split the string to get the dates
		String[] dates = inputDate.split(":|,");
		for(String date : dates) {
		System.out.println(date);
		}
		customerType = dates[0];
		for(int iteration = 1; iteration<=2 ; iteration++) {
			//Convert dates to standard format
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy", Locale.ENGLISH);
			LocalDate date = LocalDate.parse(dates[iteration], formatter);
			localDate[iteration-1] = date;
		}
		LocalDate start = localDate[0];
		LocalDate end = localDate[1];
		totalDays = ChronoUnit.DAYS.between(start, end);
		totalDays = totalDays + 1;
		totalWeekEndDays = getTotalWeekEndDays(start, end); 
		totalWeekDays = totalDays - totalWeekEndDays;
	}
	public int getTotalWeekEndDays(LocalDate start, LocalDate end) {
		long weekEndDays = 0;
		LocalDate next = start.minusDays(1);
		//iterate from start date to end date
		while ((next = next.plusDays(1)).isBefore(end.plusDays(1))) {
			if(next.getDayOfWeek().toString().equals("SATURDAY") || next.getDayOfWeek().toString().equals("SUNDAY")) {
				totalWeekEndDays++;
			}
		}
		return (int)totalWeekEndDays;	
	}
	/**
	 * UC2
	 * Modification of the function to take into account different rates for weekend and weekdays
	 * @param input
	 * @return
	 */
	public ArrayList<Hotel> findCheapestHotel(Scanner input) {
		ArrayList<Hotel> cheapestHotels = this.findCheapest();
		return cheapestHotels;
	}
	public ArrayList<Hotel> findCheapest() {
		int minimumRate = 0;
		ArrayList<Hotel> cheapestHotels = new ArrayList<Hotel>();
		HashMap<Hotel,Integer> hotelMap = new HashMap<Hotel,Integer>();
		HashMap<Hotel,Integer> ratingMap = new HashMap<Hotel,Integer>();
		for(Hotel hotel : hotelList) {
			int totalRate = hotel.getWeekdayRate() * (int)totalWeekDays + hotel.getWeekendRate() * (int)totalWeekEndDays;
			hotelMap.put(hotel, totalRate);
			ratingMap.put(hotel, hotel.getRating());
		}
		minimumRate = Collections.min(hotelMap.values());
		
		for(Map.Entry<Hotel, Integer> entry : hotelMap.entrySet()) {
			if(entry.getValue() == minimumRate) {
				cheapestHotels.add(entry.getKey());
			}
		}
		int maximumRating = Collections.max(ratingMap.values());
		for(Hotel hotel : cheapestHotels) {
			if(hotel.getRating() != maximumRating) {
				cheapestHotels.remove(hotel);
				continue;
			}
			System.out.println(hotel.getName() + "Ratings : " + hotel.getRating() +" Total Rate : " + minimumRate);
		}
		return cheapestHotels;
	}
	/**
	 *UC7
	 *Function to find Best Rated Hotels
	 * @return
	 */
	public ArrayList<Hotel> findBestRatedHotels(Scanner input){
		ArrayList<Hotel> bestRatedHotels = new ArrayList<Hotel>();
		HashMap<Hotel,Integer> ratingMap = new HashMap<Hotel,Integer>();
		for(Hotel hotel : hotelList) {
			ratingMap.put(hotel, hotel.getRating());
		}
		int maximumRating = Collections.max(ratingMap.values());
		for(Map.Entry<Hotel, Integer> entry : ratingMap.entrySet()) {
			if(entry.getValue() == maximumRating) {
				bestRatedHotels.add(entry.getKey());
				System.out.println("Hotel Name : " + entry.getKey().getName() + "Ratings : " + entry.getKey().getRating() +" Total Rate : " + ((int) totalWeekDays * entry.getKey().getWeekdayRate() + (int)totalWeekEndDays * entry.getKey().getWeekendRate()));
			}
		}
		for(Hotel hotel : bestRatedHotels) {
			System.out.println(hotel);
		}
		return bestRatedHotels;	
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Hotel Reservation Program");
		HotelReservation hotel = new HotelReservation();
		hotel.getInput(input);
		input.close();
	}
}