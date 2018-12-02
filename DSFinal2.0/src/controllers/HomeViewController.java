package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeViewController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button Login;

	@FXML
	private Button Restaurants;

	@FXML
	private Button Search;

	@FXML
	private TextField SearchText;

	@FXML
	private Button YourReviews;

	@FXML
	void Home(ActionEvent event) {
	}

	@FXML
	void Login(ActionEvent event) throws Exception {
		if (!Main.isLoggedin()) {
			Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
			Scene newScene = new Scene(newView);
			Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
			mainWindow.setScene(newScene);
		} else {
			Login.setText("Login");
			Main.setLoggedin(false);
			Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
			Scene newScene = new Scene(newView);
			Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
			mainWindow.setScene(newScene);
		}
	}

	@FXML
	void Restaurants(ActionEvent event) throws Exception {
		if (Main.isLoggedin()) {
			Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/ResultsView.fxml"));
			Scene newScene = new Scene(newView);
			Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
			mainWindow.setScene(newScene);
		}
	}

	@FXML
	void Search(ActionEvent event) throws Exception {
		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/ResultsView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
	}

	@FXML
	void YourReviews(ActionEvent event) throws Exception {
		if (Main.isLoggedin()) {
			Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/YourReviewsView.fxml"));
			Scene newScene = new Scene(newView);
			Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
			mainWindow.setScene(newScene);
		}
	}

	@FXML
	void initialize() {
		assert Login != null : "fx:id=\"Login\" was not injected: check your FXML file 'HomeView.fxml'.";
		assert Restaurants != null : "fx:id=\"Restaurants\" was not injected: check your FXML file 'HomeView.fxml'.";
		assert Search != null : "fx:id=\"Search\" was not injected: check your FXML file 'HomeView.fxml'.";
		assert SearchText != null : "fx:id=\"SearchText\" was not injected: check your FXML file 'HomeView.fxml'.";
		assert YourReviews != null : "fx:id=\"YourReviews\" was not injected: check your FXML file 'HomeView.fxml'.";
		System.out.println(Main.isLoggedin());
		if (Main.isLoggedin()) {
			Login.setText(Main.getCurrentUser().getName());
		} else {
			Restaurants.setText("");
			YourReviews.setText("");
		}

	}

}