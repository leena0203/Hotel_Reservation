package com.HotelReservation;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class HotelReservationTest {

	//	/**
	//	 * UC2_Return cheapest hotel name
	//	 */
	//	@Test
	//	void cheapestMethod_shouldReturn_hotelName() {
	//		HotelReservation test = new HotelReservation();
	//		test.addHotel("Lakewood", 110);
	//		test.addHotel("Bridgewood",160);
	//		test.addHotel("Ridgewood",220);
	//		String result = test.findCheapestHotel("10 Sep 2020", "11 Sep 2020");
	//		assertEquals("Lakewood",result);
	//	}
	//	/**
	//	 * UC4_Return cheapest hotel name
	//	 */
	//	@Test
	//	void givenDateAndRateOfStay_shouldReturn_cheapesthotelName() {
	//		HotelReservation test = new HotelReservation();
	//		test.addHotel("Lakewood", 110,90);
	//		test.addHotel("Bridgewood",150,50);
	//		test.addHotel("Ridgewood",220,150);
	//		List<Hotel> result = test.minimumRate("11 Sep 2020", "12 Sep 2020");
	//		assertEquals("Bridgewood",result.get(0).getName());2
	//		assertEquals("Lakewood",result.get(1).getName());
	//	}

	/**
	 * UC6_Return best rated cheapest hotel
	 */
	@Test
	void givenDateAndRateOfStayAndRating_shouldReturn_cheapesthotelName() {
		HotelReservation test = new HotelReservation();
		//		test.addHotel("Lakewood", 110,90,3);
		//		test.addHotel("Bridgewood",150,50,4);
		//		test.addHotel("Ridgewood",220,150,5);
		test.addHotel();
		ArrayList<Hotel> cheapest = test.minimumRate();
		ArrayList<Hotel> bestRated = test.bestRatedHotel(cheapest);
		//System.out.println(.size());
		assertEquals("Bridgewood",cheapest.get(0).getName());

	}

	/**
	 * UC7_Return best rated  hotel
	 */
	@Test
	void givenDateAndRateOfStayAndRating_shouldReturn_bestRatedhotelName() {
		HotelReservation test = new HotelReservation();
		test.addHotel();
		ArrayList<Hotel> cheapest = test.minimumRate();
		ArrayList<Hotel> bestRated = test.bestRatedHotel(cheapest);
		//System.out.println(.size());
		assertEquals("Ridgewood",bestRated.get(0).getName());

	}

	//	
	//	/**
	//	 * UC3_Add hotel name and weekday and weekend rates
	//	 */
	//	@Test
	//	public void givenHotelNameAndWeekendRate_shouldReturn_listSize() {
	//		
	//		HotelReservation test = new HotelReservation();
	//		test.addHotel("Lakewood", 110,90);
	//		test.addHotel("Bridgewood",150,50);
	//		test.addHotel("Ridgewood",220,150);
	//		int result = test.hotelList.size();
	//		assertEquals(3, result);
	//	}

	//			/**
	//			 * UC5_Add hotel name and weekday and weekend rates and rating
	//			 */
	//			@Test
	//			public void givenHotelNameAndWeekendRateAndRating_shouldReturn_listSize() {
	//		
	//				HotelReservation test = new HotelReservation();
	//				test.addHotel("Lakewood", 110,90, 3);
	//				test.addHotel("Bridgewood",150,50, 4);
	//				test.addHotel("Ridgewood",220,150, 5);
	//				int result = test.hotelList.size();
	//				assertEquals(3, result);
	//}




}
