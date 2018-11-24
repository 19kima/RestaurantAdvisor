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


public class Main extends Application {
	private static boolean Loggedin;
	private static Stage MainStage;
	private static DSArrayIndexedList<Restaurant> restaurants;
	private static Restaurant currentRestaurant;
	private static DSArrayIndexedList<User> users;
	private static User currentUser;
	private static Review currentReview;
	@Override
	public void start(Stage primaryStage) throws Exception {
		restaurants = new DSArrayIndexedList<Restaurant>();
		users = new DSArrayIndexedList<User>();
		primaryStage.setTitle("Landing Page");
		//primaryStage.setFullScreen(true);
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
}
