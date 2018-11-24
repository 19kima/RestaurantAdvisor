package landingPage;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HomeViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox Box;

    @FXML
    private Menu Home;

    @FXML
    private Menu MyReviewsNav;

    @FXML
    private Menu RestaurantNav;

    @FXML
    private Button SearchText;


    @FXML
    void Home(ActionEvent event) {
    }
    
    @FXML
    void MyReviewsNav(ActionEvent event) {
    }
    
    @FXML
    void Login(ActionEvent event) throws Exception {
    	Parent newView = (VBox) FXMLLoader.load(getClass().getResource("/login/LoginView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
    }

    @FXML
    void RestaurantNav(ActionEvent event) throws Exception {
    	Parent newView = (AnchorPane) FXMLLoader.load(getClass().getResource("/results/ResultsView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
    }

    @FXML
    void Search(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert Box != null : "fx:id=\"Box\" was not injected: check your FXML file 'HomeView.fxml'.";
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'HomeView.fxml'.";
        assert MyReviewsNav != null : "fx:id=\"MyReviewsNav\" was not injected: check your FXML file 'HomeView.fxml'.";
        assert RestaurantNav != null : "fx:id=\"RestaurantNav\" was not injected: check your FXML file 'HomeView.fxml'.";
        assert SearchText != null : "fx:id=\"SearchText\" was not injected: check your FXML file 'HomeView.fxml'.";


    }

}