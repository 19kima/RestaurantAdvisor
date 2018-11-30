package models;

import java.io.Serializable;

import dataStructures.DSArrayIndexedList;

public class Restaurant implements Serializable{
	private String name;
	private String address;
	private String phone;
	private String email;
	private String price;
	private String typeOfDining;
	private String typeOfCuisine;
	private double rating;
	private DSArrayIndexedList<String> hours;
	private DSArrayIndexedList<String> menu;
	private DSArrayIndexedList<Review> reviews;

	public Restaurant() {
		setReviews(new DSArrayIndexedList<Review>());
		setHours(new DSArrayIndexedList<String>(7));
		setMenu(new DSArrayIndexedList<String>());
		hours.add(0, "");
		hours.add(1, "");
		hours.add(2, "");
		hours.add(3, "");
		hours.add(4, "");
		hours.add(5, "");
		hours.add(6, "");
		name = "";
		address = "";
		phone = "";
		email = "";
		price = "";
		typeOfDining = "";
		typeOfCuisine = "";
		rating = 5.0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTypeOfDining() {
		return typeOfDining;
	}

	public void setTypeOfDining(String typeOfDining) {
		this.typeOfDining = typeOfDining;
	}

	public String getTypeOfCuisine() {
		return typeOfCuisine;
	}

	public void setTypeOfCuisine(String typeOfCuisine) {
		this.typeOfCuisine = typeOfCuisine;
	}

	public DSArrayIndexedList<String> getHours() {
		return hours;
	}

	public void setHours(DSArrayIndexedList<String> hours) {
		this.hours = hours;
	}

	public DSArrayIndexedList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(DSArrayIndexedList<Review> reviews) {
		this.reviews = reviews;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	public String toString() {
		return name + " | " + rating + "/5\n" + "Price: " + price +	"	Type: " + typeOfCuisine +	"	Address: " + address;
	}

	public DSArrayIndexedList<String> getMenu() {
		return menu;
	}

	public void setMenu(DSArrayIndexedList<String> menu) {
		this.menu = menu;
	}
	public void calcRating() {
		double sum = 0;
		for(int i = 0; i < reviews.size(); i++) {
			sum+=reviews.get(i).getRating();
		}
		rating = sum/((double)reviews.size());
	}

}
