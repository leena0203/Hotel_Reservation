package com.HotelReservation;

import java.util.Scanner;

public class Hotel {
	String name;
	int weekdayRate, weekendRate,rating;
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Hotel(String name, int weekdayRate, int weekendRate, int rating) {
		super();
		this.name = name;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
		this.rating = rating;
	}
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
	public Hotel(String name, int weekdayRate, int weekendRate) {
		super();
		this.name = name;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
	}
	public String toString() {
		return this.getName();
	}
	

}

