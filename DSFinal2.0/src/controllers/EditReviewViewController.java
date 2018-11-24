package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import models.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class EditReviewViewController {
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button AddReview;

	@FXML
	private Button Login;

	@FXML
	private TextField Rating;

	@FXML
	private Label RestaurantName;

	@FXML
	private TextArea Review;

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
    void Restaurants(ActionEvent event) throws Exception {
    	Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/ResultsView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
    }

	@FXML
	void ReviewSet(ActionEvent event) throws Exception{
		Main.getCurrentReview().setRating(Double.parseDouble(Rating.getText()));
    	Main.getCurrentReview().setText(Review.getText());
    	Main.getCurrentRestaurant().calcRating();
		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/RestaurantView.fxml"));
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
		assert AddReview != null : "fx:id=\"AddReview\" was not injected: check your FXML file 'EditReviewView.fxml'.";
		assert Login != null : "fx:id=\"Login\" was not injected: check your FXML file 'EditReviewView.fxml'.";
		assert Rating != null : "fx:id=\"Rating\" was not injected: check your FXML file 'EditReviewView.fxml'.";
		assert RestaurantName != null : "fx:id=\"RestaurantName\" was not injected: check your FXML file 'EditReviewView.fxml'.";
		assert Review != null : "fx:id=\"Review\" was not injected: check your FXML file 'EditReviewView.fxml'.";
		if (Main.getCurrentReview()==null) {
			Main.setCurrentReview(new Review());
			Main.getCurrentUser().getYourReviews().add(Main.getCurrentReview());
			Main.getCurrentRestaurant().getReviews().add(Main.getCurrentReview());
		} else {
			AddReview.setText("Edit Review");
			Rating.setText(Main.getCurrentReview().getRating()+"");
			Review.setText(Main.getCurrentReview().getText());
		}
		RestaurantName.setText(Main.getCurrentRestaurant().getName());
		Login.setText(Main.getCurrentUser().getName());
	}

}
