package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import dataStructures.DSArrayIndexedList;
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
import models.User;


public class LoginViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Home;

    @FXML
    private Button LogIn;

    @FXML
    private Button Restaurants;

    @FXML
    private Button SignUp;

    @FXML
    private Button YourReviews;

    @FXML
    private TextField password;

    @FXML
    private TextField user;


    @FXML
    void Home(ActionEvent event) throws Exception {
    	Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
    }

    @FXML
    void LogIn(ActionEvent event) throws Exception {
    	String userInput = user.getText();
    	String passwordInput = password.getText();
    	boolean sucess = false;
    	User temp = null;
    	DSArrayIndexedList<User> userList = Main.getUsers();
    	for (int i = 0; i < userList.size(); i++) {
    		if (userList.get(i).getUsername().equals(userInput)) {
    			temp = userList.get(i);
    		}
    	}
    	if (temp!=null && temp.getPassword().equals(passwordInput)) {
    		sucess = true;
    	}
    	if (sucess) {
    		Main.setLoggedin(true);
    		Main.setCurrentUser(temp);
    		if(Main.getCurrentUser().getName().equals("admin")) {
    			Main.setAdmin(true);
    		}
    		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
    		Scene newScene = new Scene(newView);
    		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		mainWindow.setScene(newScene);
    		
    	}
    }

    @FXML
    void Restaurants(ActionEvent event) {
    }

    @FXML
    void SignUp(ActionEvent event) throws Exception{
		Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/SignUpView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
    }

    @FXML
    void YourReviews(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert LogIn != null : "fx:id=\"LogIn\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert Restaurants != null : "fx:id=\"Restaurants\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert SignUp != null : "fx:id=\"SignUp\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert YourReviews != null : "fx:id=\"YourReviews\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert user != null : "fx:id=\"user\" was not injected: check your FXML file 'LoginView.fxml'.";


    }

}
