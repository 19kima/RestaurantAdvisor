package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;
import models.Restaurant;

public class EditRestaurantViewController {
	private static int RestaurantCounter = 0;
	private Restaurant starter;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button AddMenu;

	@FXML
	private Label Address;

	@FXML
	private TextField AddressSet;

	@FXML
	private Label Cusine;

	@FXML
	private Label Dining;

	@FXML
	private Button EditHours;

	@FXML
	private Label Email;

	@FXML
	private TextField EmailSet;

	@FXML
	private ListView<?> Hours;

	@FXML
	private TextField HoursSet;

	@FXML
	private Button Login;

	@FXML
	private ListView<?> Menu;

	@FXML
	private TextField MenuNameSet;

	@FXML
	private TextField MenuPriceSet;

	@FXML
	private TextField NameSet;

	@FXML
	private Label Phone;

	@FXML
	private TextField PhoneSet;

	@FXML
	private Label Price;

	@FXML
	private TextField PriceSet;

	@FXML
	private Button Save;

	@FXML
	private TextField TypeOfCuisineSet;

	@FXML
	private TextField TypeOfDiningSet;

	@FXML
	void AddMenu(ActionEvent event) throws Exception {
		starter.setAddress(AddressSet.getText());
		starter.setEmail(EmailSet.getText());
		starter.setName(NameSet.getText());
		starter.setPhone(PhoneSet.getText());
		starter.setPrice(PriceSet.getText());
		starter.setTypeOfCuisine(TypeOfCuisineSet.getText());
		starter.setTypeOfDining(TypeOfDiningSet.getText());
		starter.getMenu().add(MenuNameSet.getText() + " - " + MenuPriceSet.getText());
		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/EditRestaurantView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
	}

	@FXML
	void Home(ActionEvent event) throws Exception {
		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
	}

	@FXML
	void Login(ActionEvent event) throws Exception {
		Main.setLoggedin(false);
		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
	}

	@FXML
	void OpenEditing(MouseEvent event) {
		EditHours.setDisable(false);
	}

	@FXML
	void Restaurants(ActionEvent event) throws Exception {
		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/ResultsView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
	}

	@FXML
	void SaveHours(ActionEvent event) throws Exception {
		starter.setAddress(AddressSet.getText());
		starter.setEmail(EmailSet.getText());
		starter.setName(NameSet.getText());
		starter.setPhone(PhoneSet.getText());
		starter.setPrice(PriceSet.getText());
		starter.setTypeOfCuisine(TypeOfCuisineSet.getText());
		starter.setTypeOfDining(TypeOfDiningSet.getText());
		Main.getCurrentRestaurant().getHours().set(Hours.getSelectionModel().getSelectedIndex(), HoursSet.getText());
		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/EditRestaurantView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
	}

	@FXML
	void RemoveMenu(MouseEvent event) throws Exception {
		starter.setAddress(AddressSet.getText());
		starter.setEmail(EmailSet.getText());
		starter.setName(NameSet.getText());
		starter.setPhone(PhoneSet.getText());
		starter.setPrice(PriceSet.getText());
		starter.setTypeOfCuisine(TypeOfCuisineSet.getText());
		starter.setTypeOfDining(TypeOfDiningSet.getText());
		starter.getMenu().remove(Menu.getSelectionModel().getSelectedIndex());
		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/EditRestaurantView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
	}
	

	@FXML
	void SavePage(ActionEvent event) throws Exception {
		starter.setAddress(AddressSet.getText());
		starter.setEmail(EmailSet.getText());
		starter.setName(NameSet.getText());
		starter.setPhone(PhoneSet.getText());
		starter.setPrice(PriceSet.getText());
		starter.setTypeOfCuisine(TypeOfCuisineSet.getText());
		starter.setTypeOfDining(TypeOfDiningSet.getText());
		Main.saveData();
		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/ResultsView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
	}

	@FXML
	void YourReviews(ActionEvent event) throws Exception {
		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/YourReviewsView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
	}

	@FXML
	void initialize() {
		assert AddMenu != null : "fx:id=\"AddMenu\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert Address != null : "fx:id=\"Address\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert AddressSet != null : "fx:id=\"AddressSet\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert Cusine != null : "fx:id=\"Cusine\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert Dining != null : "fx:id=\"Dining\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert EditHours != null : "fx:id=\"EditHours\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert Email != null : "fx:id=\"Email\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert EmailSet != null : "fx:id=\"EmailSet\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert Hours != null : "fx:id=\"Hours\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert HoursSet != null : "fx:id=\"HoursSet\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert Login != null : "fx:id=\"Login\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert Menu != null : "fx:id=\"Menu\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert MenuNameSet != null : "fx:id=\"MenuNameSet\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert MenuPriceSet != null : "fx:id=\"MenuPriceSet\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert NameSet != null : "fx:id=\"NameSet\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert Phone != null : "fx:id=\"Phone\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert PhoneSet != null : "fx:id=\"PhoneSet\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert Price != null : "fx:id=\"Price\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert PriceSet != null : "fx:id=\"PriceSet\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert Save != null : "fx:id=\"Save\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert TypeOfCuisineSet != null : "fx:id=\"TypeOfCuisineSet\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		assert TypeOfDiningSet != null : "fx:id=\"TypeOfDiningSet\" was not injected: check your FXML file 'EditRestaurantView.fxml'.";
		Login.setText(Main.getCurrentUser().getName());
		if (Main.getCurrentRestaurant() == null) {
			Main.setCurrentRestaurant(new Restaurant());
			starter = Main.getCurrentRestaurant();
			Save.setText("Add");
			Main.getRestaurants().add(starter);
		} else {
			starter = Main.getCurrentRestaurant();
		}
		NameSet.setText(starter.getName());
		AddressSet.setText(Main.getCurrentRestaurant().getAddress());
		EmailSet.setText(Main.getCurrentRestaurant().getEmail());
		TypeOfCuisineSet.setText(Main.getCurrentRestaurant().getTypeOfCuisine());
		TypeOfDiningSet.setText(Main.getCurrentRestaurant().getTypeOfDining());
		PriceSet.setText(Main.getCurrentRestaurant().getPrice());
		PhoneSet.setText(Main.getCurrentRestaurant().getPhone());
		ObservableList hoursToAdd = FXCollections.observableArrayList();
		hoursToAdd.add("Monday: " + starter.getHours().get(0));
		hoursToAdd.add("Tuesday: " + starter.getHours().get(1));
		hoursToAdd.add("Wednesday: " + starter.getHours().get(2));
		hoursToAdd.add("Thursday: " + starter.getHours().get(3));
		hoursToAdd.add("Friday: " + starter.getHours().get(4));
		hoursToAdd.add("Saturday: " + starter.getHours().get(5));
		hoursToAdd.add("Sunday: " + starter.getHours().get(6));
		Hours.setItems(hoursToAdd);
		ObservableList MenuToAdd = FXCollections.observableArrayList();
		starter.getMenu().reset();
		for (int i = 0; i < starter.getMenu().size(); i++) {
			MenuToAdd.add(starter.getMenu().get(i));
		}
		Menu.setItems(MenuToAdd);

	}

}
