package com.HotelReservation;

public class Hotel {
	String name;
	int weekdayRate, weekendRate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeekdayRate() {
		return weekdayRate;
	}
	public void setWeekdayRate(int weekdayRate) {
		this.weekdayRate = weekdayRate;
	}
	public int getWeekendRate() {
		return weekendRate;
	}
	public void setWeekendRate(int weekendRate) {
		this.weekendRate = weekendRate;
	}
	public Hotel(String name, int weekdayRate) {
		super();
		this.name = name;
		this.weekdayRate = weekdayRate;
	}

}

