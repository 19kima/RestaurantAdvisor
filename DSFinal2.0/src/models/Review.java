package models;

import application.Main;

public class Review {
	private User user;
	private Restaurant name;
	private double rating;
	private String text;
	
	public Review() {
		name = Main.getCurrentRestaurant();
		user = Main.getCurrentUser();
		rating = 5.0;
		text = "";
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public Restaurant getName() {
		return name;
	}

	public void setName(Restaurant name) {
		this.name = name;
	}
	public String toString() {
		return "By: " + user.getName() + "	Rating: " + rating + "/5.0\n" + text; 
	}
	public String toStringYourReviews() {
		return "Restaurant: " + name.getName() + "	Rating: " + rating + "/5.0\n" + text; 
	}
}
