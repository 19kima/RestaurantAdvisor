package models;

import dataStructures.DSArrayIndexedList;

public class User {
	private String name;
	private String username;
	private String password;
	private DSArrayIndexedList<Review> yourReviews;
	private int numReview;
	
	public User(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
		numReview = 0;
		yourReviews = new DSArrayIndexedList<Review>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public DSArrayIndexedList<Review> getYourReviews() {
		return yourReviews;
	}
	public void setYourReviews(DSArrayIndexedList<Review> yourReviews) {
		this.yourReviews = yourReviews;
	}
}
