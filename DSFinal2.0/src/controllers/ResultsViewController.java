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
import javafx.scene.control.ListView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ResultsViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Details;

    @FXML
    private ListView<?> FoodList;

    @FXML
    private Button Login;


    @FXML
    void Home(ActionEvent event) {
    }

    @FXML
    void PickRestaurant(MouseEvent event) throws Exception {
    	System.out.println(FoodList.getSelectionModel().getSelectedIndex());
    	Main.setCurrentRestaurant(Main.getRestaurants().get(FoodList.getSelectionModel().getSelectedIndex()));
    	Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/RestaurantView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
    }

    @FXML
    void Restaurants(ActionEvent event) {
    }
    
    @FXML
    void AddRestaurant(ActionEvent event) throws Exception {
    	Main.setCurrentRestaurant(null);
    	Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/EditRestaurantView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
    }

    @FXML
    void SelectRestaurant(ContextMenuEvent event) {
    }

    @FXML
    void YourReviews(ActionEvent event) {
    }

    @FXML
    void getDetails(ActionEvent event) throws Exception {
    }

    @FXML
    void initialize() {
        assert Details != null : "fx:id=\"Details\" was not injected: check your FXML file 'ResultsView.fxml'.";
        assert FoodList != null : "fx:id=\"FoodList\" was not injected: check your FXML file 'ResultsView.fxml'.";
        assert Login != null : "fx:id=\"Login\" was not injected: check your FXML file 'ResultsView.fxml'.";
        Login.setText(Main.getCurrentUser().getName());
        ObservableList elements = FXCollections.observableArrayList();
        for (int i = 0; i < Main.getRestaurants().size(); i++) {
        	elements.add(Main.getRestaurants().get(i).toString());
        }
        FoodList.setItems(elements);

    }

}
