package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Restaurant;

public class RestaurantViewController {
	private Restaurant restaurantSetter;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label Address;

	@FXML
	private Label Cusine;

	@FXML
	private Label Dining;

	@FXML
	private Label Email;

	@FXML
	private ListView<?> Hours;

	@FXML
	private Button Login;

	@FXML
	private ListView<?> Menu;

	@FXML
	private Label Phone;

	@FXML
	private Label Price;

	@FXML
	private Label RestaurantName;

	@FXML
	private ListView<?> Reviews;

	@FXML
	void Home(ActionEvent event) throws Exception {
		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
	}

	@FXML
	void Login(ActionEvent event) throws Exception{
		Main.setLoggedin(false);
		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
	}

	@FXML
	void Restaurants(ActionEvent event) {
	}

	@FXML
	void YourReviews(ActionEvent event) throws Exception {
		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/YourReviewsView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
	}
	
	@FXML
    void EditRestaurant(ActionEvent event) throws Exception {
		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/EditRestaurantView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
    }
	
	@FXML
    void AddReview(ActionEvent event) throws Exception {
		Main.setCurrentReview(null);
		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/EditReviewView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
    }

	@FXML
	void initialize() {
		assert Address != null : "fx:id=\"Address\" was not injected: check your FXML file 'RestaurantView.fxml'.";
		assert Cusine != null : "fx:id=\"Cusine\" was not injected: check your FXML file 'RestaurantView.fxml'.";
		assert Dining != null : "fx:id=\"Dining\" was not injected: check your FXML file 'RestaurantView.fxml'.";
		assert Email != null : "fx:id=\"Email\" was not injected: check your FXML file 'RestaurantView.fxml'.";
		assert Hours != null : "fx:id=\"Hours\" was not injected: check your FXML file 'RestaurantView.fxml'.";
		assert Login != null : "fx:id=\"Login\" was not injected: check your FXML file 'RestaurantView.fxml'.";
		assert Menu != null : "fx:id=\"Menu\" was not injected: check your FXML file 'RestaurantView.fxml'.";
		assert Phone != null : "fx:id=\"Phone\" was not injected: check your FXML file 'RestaurantView.fxml'.";
		assert Price != null : "fx:id=\"Price\" was not injected: check your FXML file 'RestaurantView.fxml'.";
		assert RestaurantName != null : "fx:id=\"RestaurantName\" was not injected: check your FXML file 'RestaurantView.fxml'.";
		assert Reviews != null : "fx:id=\"Reviews\" was not injected: check your FXML file 'RestaurantView.fxml'.";
		restaurantSetter = Main.getCurrentRestaurant();
		Login.setText(Main.getCurrentUser().getName());
		Address.setText("Address: " + restaurantSetter.getAddress());
		Email.setText("Email: " + restaurantSetter.getEmail());
		Phone.setText("Phone: " + restaurantSetter.getPhone());
		Dining.setText("Type of Dining: " + restaurantSetter.getTypeOfDining());
		Cusine.setText("Type of Cusine: " + restaurantSetter.getTypeOfCuisine());
		Price.setText("Price: " + restaurantSetter.getPrice());
		if (Main.getCurrentRestaurant().getReviews().size() == 0) {
			RestaurantName.setText(restaurantSetter.getName()+ " | No Reviews");
		} else {
			RestaurantName.setText(restaurantSetter.getName()+ " | " + restaurantSetter.getRating() + "/5.0");
			
		}
		ObservableList hoursToAdd = FXCollections.observableArrayList();
		hoursToAdd.add("Monday: " + restaurantSetter.getHours().get(0));
		hoursToAdd.add("Tuesday: " + restaurantSetter.getHours().get(1));
		hoursToAdd.add("Wednesday: " + restaurantSetter.getHours().get(2));
		hoursToAdd.add("Thursday: " + restaurantSetter.getHours().get(3));
		hoursToAdd.add("Friday: " + restaurantSetter.getHours().get(4));
		hoursToAdd.add("Saturday: " + restaurantSetter.getHours().get(5));
		hoursToAdd.add("Sunday: " + restaurantSetter.getHours().get(6));
		Hours.setItems(hoursToAdd);
		ObservableList MenuToAdd = FXCollections.observableArrayList();
		for (int i = 0; i < restaurantSetter.getMenu().size(); i++) {
			MenuToAdd.add(restaurantSetter.getMenu().get(i));
		}
		Menu.setItems(MenuToAdd);
		ObservableList Review = FXCollections.observableArrayList();
		for (int i = 0; i < restaurantSetter.getReviews().size(); i++) {
			Review.add(restaurantSetter.getReviews().get(i).toString());
		}
		Reviews.setItems(Review);

	}

}
