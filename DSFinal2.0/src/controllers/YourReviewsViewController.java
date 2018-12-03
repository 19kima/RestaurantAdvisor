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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class YourReviewsViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Login;
    
    @FXML
    private Button EditButton;

    @FXML
    private Label Reviews;

    @FXML
    private ListView<?> YourReviewsList;


    @FXML
    void EditReview(ActionEvent event) throws Exception {
    	Main.setCurrentReview(Main.getCurrentUser().getYourReviews().get(YourReviewsList.getSelectionModel().getSelectedIndex()));
    	Main.setCurrentRestaurant(Main.getCurrentReview().getName());
    	Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/EditReviewView.fxml"));
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
    void Restaurants(ActionEvent event) throws Exception {
    	Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/RestaurantView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
    }

    @FXML
    void ShowEdit(MouseEvent event) {
    	EditButton.setVisible(true);
    }

    @FXML
    void YourReviews(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert Login != null : "fx:id=\"Login\" was not injected: check your FXML file 'YourReviewsView.fxml'.";
        assert Reviews != null : "fx:id=\"Reviews\" was not injected: check your FXML file 'YourReviewsView.fxml'.";
        assert YourReviewsList != null : "fx:id=\"YourReviewsList\" was not injected: check your FXML file 'YourReviewsView.fxml'.";
        ObservableList elements = FXCollections.observableArrayList();
        for (int i = 0; i < Main.getCurrentUser().getYourReviews().size(); i++) {
        	elements.add(Main.getCurrentUser().getYourReviews().get(i).toStringYourReviews());
        }
        YourReviewsList.setItems(elements);
        Login.setText(Main.getCurrentUser().getName());

    }

}
