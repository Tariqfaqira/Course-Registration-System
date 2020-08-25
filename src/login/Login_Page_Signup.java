package login;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import database.sql_connect;

public class Login_Page_Signup implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;

    Connection conn = sql_connect.ConnectcrDB();
    ;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String signinAs = "Clerk";

    @FXML
    private Label label;
    @FXML
    private RadioButton show_pass;
    @FXML
    private AnchorPane anchorPane;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = sql_connect.ConnectcrDB();
    }

    @FXML
    private void handle_makeAdmin(ActionEvent event) {
        signinAs = "Admin";
    }

    @FXML
    private void handle_createAccount(ActionEvent event) {

        if ((password.getLength() >= 6) && (username.getLength() >= 6)
                && (password.getText()).equals(confirmPassword.getText())) {
            try {
                String query = "insert into Accounts values(?,?,?)";
                pst = conn.prepareStatement(query);

                pst.setString(1, username.getText());
                pst.setString(2, password.getText());
                pst.setString(3, signinAs);
                pst.execute();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Account successfully created. ");
                alert.showAndWait();
                
                AnchorPane pane = FXMLLoader.load(getClass().getResource("Login_Page.fxml"));
                anchorPane.getChildren().setAll(pane);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error Signup: " + e);
            } catch (IOException ex) {
                Logger.getLogger(Login_Page_Signup.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if ((username.getText()).isEmpty()) {
                username.setPromptText("You can't leave this field empty");
                username.setStyle("-fx-prompt-text-fill: Red");
            }
            if (((username.getLength()) < 6) && !((username.getText()).isEmpty())) {
                username.setPromptText("Enter at least 6 characters");
                username.setStyle("-fx-prompt-text-fill: Red");
                username.setText("");
            }

            if ((password.getText()).isEmpty()) {
                password.setPromptText("You can't leave this field empty");
                password.setStyle("-fx-prompt-text-fill: Red");
            }
            if ((confirmPassword.getText()).isEmpty()) {
                confirmPassword.setPromptText("You can't leave this field empty");
                confirmPassword.setStyle("-fx-prompt-text-fill: Red");
            }

            if ((password.getLength() < 6) && !((password.getText()).isEmpty())) {
                password.setPromptText("Enter at least 6 characters");
                password.setStyle("-fx-prompt-text-fill: Red");
                password.setText("");
                //password.setDisable(true);
            }
            if ((confirmPassword.getLength() < 6) && !((confirmPassword.getText()).isEmpty())) {

                confirmPassword.setPromptText("Enter at least 6 characters");
                confirmPassword.setStyle("-fx-prompt-text-fill: Red");
                confirmPassword.setText("");
                //confirmPassword.setDisable(true);
            }
            if (!(password.getText()).equals(confirmPassword.getText())) {
                password.setPromptText("Password don't match");
                password.setStyle("-fx-prompt-text-fill: Red");
                password.setText("");

                confirmPassword.setPromptText("Password don't match");
                confirmPassword.setStyle("-fx-prompt-text-fill: Red");
                confirmPassword.setText("");
            }

        }
    }

    @FXML
    private void handle_showPassword(ActionEvent event) {
        if (show_pass.isSelected()) {
            password.setPromptText(password.getText());
            password.setText("");
            password.setDisable(true);

        } else {
            password.setText(password.getPromptText());
            password.setPromptText("");
            password.setDisable(false);
        }
    }

    @FXML
    private void handle_cancel(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Login_Page.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
}
