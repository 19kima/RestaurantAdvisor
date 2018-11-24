package signup;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;


public class SignUpViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Menu Home;

    @FXML
    private Button Signup;

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    @FXML
    private TextField username;


    @FXML
    void Home(ActionEvent event) {
    }

    @FXML
    void Signup(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'SignUpView.fxml'.";
        assert Signup != null : "fx:id=\"Signup\" was not injected: check your FXML file 'SignUpView.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'SignUpView.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'SignUpView.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'SignUpView.fxml'.";


    }

}
