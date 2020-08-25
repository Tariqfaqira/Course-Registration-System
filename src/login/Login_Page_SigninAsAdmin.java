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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import database.sql_connect;

public class Login_Page_SigninAsAdmin implements Initializable {

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String user, pass, signinAs;

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private AnchorPane anchorPane;
    private Label label;
    @FXML
    private Label error;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = sql_connect.ConnectcrDB();
    }

    @FXML
    private void handle_EnterPressed_AllTxtFields(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            signin_method();
        }
    }

    @FXML
    private void handle_signin(ActionEvent event) {
        signin_method();
    }

    private void signin_method() {
        String query = "select * from Accounts";
        boolean flag = false;
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                user = rs.getString("Username");
                pass = rs.getString("Password");
                signinAs = rs.getString("SigninAs");
                if ((username.getText()).equals(user) && (password.getText()).equals(pass)) {
                    pst.close();
                    rs.close();
                    flag = true;
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("Login_Page_Signup.fxml"));
                    anchorPane.getChildren().setAll(pane);
                }
            }
            if (flag == false) {
                error.setText("Invalid user name or Password.\nPlease try again...");
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        } catch (IOException ex) {
            Logger.getLogger(Login_Page_SigninAsAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (username.getText() == null && (username.getText()).isEmpty()) {
            username.setPromptText("You can't leave this field empty");
            username.setStyle("-fx-prompt-text-fill: Red");
        }
        if (password.getText() != null && (password.getText()).isEmpty()) {
            password.setPromptText("You can't leave this field empty");
            password.setStyle("-fx-prompt-text-fill: Red");
        } else {
            password.setPromptText("You can't leave this field empty");
            password.setStyle("-fx-prompt-text-fill: Red");
        }
    }

    @FXML
    private void handle_cancle(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Login_Page.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
}
