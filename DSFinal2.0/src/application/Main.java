package application;

import dataStructures.DSArrayIndexedList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import models.Restaurant;
import models.Review;
import models.User;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class Main extends Application {
	private static boolean Loggedin;
	private static boolean admin;
	private static Stage MainStage;
	private static DSArrayIndexedList<Restaurant> restaurants;
	private static Restaurant currentRestaurant;
	private static DSArrayIndexedList<User> users;
	private static User currentUser;
	private static Review currentReview;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			FileInputStream fi = new FileInputStream(new File("Restaurants.ser"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			users = (DSArrayIndexedList<User>) oi.readObject();
			restaurants = (DSArrayIndexedList<Restaurant>) oi.readObject();

			System.out.println(users.toString());
			System.out.println(restaurants.toString());

			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*FileInputStream userFile = new FileInputStream("Users.ser");
		ObjectInputStream userReader = new ObjectInputStream(userFile);
		users = (DSArrayIndexedList<User>) userReader.readObject();
		userReader.close();
		FileInputStream restaurantFile = new FileInputStream("Restaurants.ser");
		ObjectInputStream restaurantReader = new ObjectInputStream(restaurantFile);
		restaurants = (DSArrayIndexedList<Restaurant>) restaurantReader.readObject();
		restaurantReader.close();
		restaurantFile.close();*/
		/*users = new DSArrayIndexedList<User>();
		restaurants = new DSArrayIndexedList<Restaurant>();
		users.add(new User("admin", "user", "pass"));
		restaurants.add(new Restaurant());
		saveUsers();
		saveRestaurants();*/
		primaryStage.setTitle("Landing Page");
		// primaryStage.setFullScreen(true);
		primaryStage.setMaximized(true);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/HomeView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		setMainStage(primaryStage);
	}

	public static void main(String[] args) {
		setLoggedin(false);
		setAdmin(false);
		launch(args);
	}

	public static boolean isLoggedin() {
		return Loggedin;
	}

	public static void setLoggedin(boolean loggedin) {
		Loggedin = loggedin;
	}

	public static Stage getMainStage() {
		return MainStage;
	}

	public static void setMainStage(Stage mainStage) {
		MainStage = mainStage;
	}

	public static DSArrayIndexedList<Restaurant> getRestaurants() {
		return restaurants;
	}

	public static void setRestaurants(DSArrayIndexedList<Restaurant> restaurants) {
		Main.restaurants = restaurants;
	}

	public static Restaurant getCurrentRestaurant() {
		return currentRestaurant;
	}

	public static void setCurrentRestaurant(Restaurant currentRestaurant) {
		Main.currentRestaurant = currentRestaurant;
	}

	public static DSArrayIndexedList<User> getUsers() {
		return users;
	}

	public static void setUsers(DSArrayIndexedList<User> users) {
		Main.users = users;
	}

	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User currentUser) {
		Main.currentUser = currentUser;
	}

	public static Review getCurrentReview() {
		return currentReview;
	}

	public static void setCurrentReview(Review currentReview) {
		Main.currentReview = currentReview;
	}

	public static void saveRestaurants() {
		try {
			FileOutputStream rOutput = new FileOutputStream("Restaurants.ser");
			ObjectOutputStream rStream = new ObjectOutputStream(rOutput);
			PrintWriter pw = new PrintWriter("Restaurants.ser");
			pw.close();
			// Write objects to file
			rStream.writeObject(restaurants);
			rStream.close();
			rOutput.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}

	public static void saveUsers() {
		try {
			FileOutputStream uOutput = new FileOutputStream("Users.ser");
			ObjectOutputStream uStream = new ObjectOutputStream(uOutput);
			PrintWriter pw = new PrintWriter("Users.ser");
			pw.close();
			// Write objects to file
			uStream.writeObject(users);
			uStream.close();
			uOutput.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}
	public static void saveData() {
		try {
			FileOutputStream f = new FileOutputStream("Restaurants.ser");
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(users);
			o.writeObject(restaurants);

			o.close();
			f.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}

	public static boolean isAdmin() {
		return admin;
	}

	public static void setAdmin(boolean admin) {
		Main.admin = admin;
	}
}
