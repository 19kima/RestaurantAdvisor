package login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class LoginViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox Box;

    @FXML
    private Button LogIn;

    @FXML
    private Button SignUp;

    @FXML
    private TextField password;

    @FXML
    private TextField user;


    @FXML
    void LogIn(ActionEvent event) throws Exception {
    	if (user.getText().equals("test") && password.getText().equals("test")) {
    		Parent newView = (VBox) FXMLLoader.load(getClass().getResource("/landingPage/HomeView.fxml"));
    		Scene newScene = new Scene(newView);
    		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		mainWindow.setScene(newScene);
    	}
    }

    @FXML
    void SignUp(ActionEvent event) throws Exception {
    	Parent newView = (VBox) FXMLLoader.load(getClass().getResource("/signup/SignUpView.fxml"));
		Scene newScene = new Scene(newView);
		Stage mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
		mainWindow.setScene(newScene);
    }

    @FXML
    void initialize() {
        assert Box != null : "fx:id=\"Box\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert LogIn != null : "fx:id=\"LogIn\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert SignUp != null : "fx:id=\"SignUp\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert user != null : "fx:id=\"user\" was not injected: check your FXML file 'LoginView.fxml'.";


    }

}
