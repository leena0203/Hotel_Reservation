package com.HotelReservation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HotelReservationTest {
	
	/**
	 * UC2_Return cheapest hotel name
	 */
	@Test
	void cheapestMethod_shouldReturn_hotelNameAndToatalRate() {
		HotelReservation test = new HotelReservation();
		test.addHotel("Lakewood", 110);
		test.addHotel("Bridgewood",160);
		test.addHotel("Ridgewood",220);
		String result = test.cheapestHotel("10 Sep 2020", "11 Sep 2020");
		assertEquals("Lakewood",result);

	}

}
