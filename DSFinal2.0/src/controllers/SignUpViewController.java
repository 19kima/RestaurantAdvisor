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


public class SignUpViewController {
	
	public static int numUsers = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Signup;

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    @FXML
    private TextField username;


    @FXML
    void Home(ActionEvent event) throws Exception {
    	
    	Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
    }

    @FXML
    void Login(ActionEvent event) throws Exception {
    	Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
    }

    @FXML
    void Restaurants(ActionEvent event) {
    }

    @FXML
    void Signup(ActionEvent event) throws Exception{
    	User newUser = new User(name.getText(), username.getText(), password.getText());
    	DSArrayIndexedList<User> userList = Main.getUsers();
    	boolean userExists = false;
    	for (int i = 0; i < userList.size(); i++) {
    		if (userList.get(i).getUsername().equals(newUser.getUsername())) {
    			userExists = true;
    		}
    	}
    	if (!userExists) {
    		Main.getUsers().add(newUser);
        	Main.setLoggedin(true);
        	Main.setCurrentUser(Main.getUsers().get(numUsers));
        	Main.saveData();
        	Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
    		Scene newScene = new Scene(newView);
    		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		mainWindow.setScene(newScene);
    	}
    	
    }

    @FXML
    void YourReviews(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert Signup != null : "fx:id=\"Signup\" was not injected: check your FXML file 'SignUpView.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'SignUpView.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'SignUpView.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'SignUpView.fxml'.";


    }

}
