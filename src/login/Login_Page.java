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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import database.sql_connect;
//#9ACADE

public class Login_Page implements Initializable {

    Connection conn = sql_connect.ConnectcrDB();
    PreparedStatement pst = null;
    ResultSet rs = null;

    @FXML
    private AnchorPane main_anchorPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    String loginas;
    @FXML
    private Label label;
    @FXML
    private CheckBox show_pass;
    @FXML
    private RadioButton login_asAdmin;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    String user, pass, signinAs;

    @FXML
    private void handle_loginBtn(ActionEvent event) {
        authenticateLoginMethod();
    }

    @FXML
    private void handle_forgot_pass(ActionEvent event) {
    }

    @FXML
    private void handle_signup(ActionEvent event) throws IOException {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Login_Page_SigninAsAdmin.fxml"));
            main_anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    @FXML
    private void handle_help(ActionEvent event) {
    }

    @FXML
    private void handle_show_pass(ActionEvent event) {
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
    private void anchorPaneMouseExited(MouseEvent event) {
        anchorPane.setStyle("-fx-background-color: white");
    }

    @FXML
    private void anchorPaneMouseEntered(MouseEvent event) {
        anchorPane.setStyle("-fx-background-color: skyblue");
    }

    @FXML
    private void handle_something(MouseEvent event) {
    }

    @FXML
    private void handle_usernameKeyPressed(KeyEvent event) {

        if (event.getCode().equals(KeyCode.ENTER)) {
            authenticateLoginMethod();
        }
    }

    @FXML
    private void handle_passwordKeyPressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            authenticateLoginMethod();
        }
    }

    void authenticateLoginMethod() {
        if ((username.getText()).isEmpty()) {
            username.setPromptText("You can't leave this field empty");
            username.setStyle("-fx-prompt-text-fill: Red");
        }
        if ((password.getText()).isEmpty()) {
            password.setPromptText("You can't leave this field empty");
            password.setStyle("-fx-prompt-text-fill: Red");
        }
        
        if (!((username.getText()).isEmpty()) && !((password.getText()).isEmpty())) {
            boolean flag = false;
            String query = "select * from Accounts";
            try {
                pst = conn.prepareStatement(query);
                rs = pst.executeQuery();
                while (rs.next()) {
                    user = rs.getString("Username");
                    pass = rs.getString("Password");
                    signinAs = rs.getString("SigninAs");

                    if (login_asAdmin.isSelected())// Login as Admin selected:
                    {

                        if ((username.getText()).equals(user) && (password.getText()).equals(pass)
                                && signinAs.equals("Admin")) {
                            pst.close();
                            rs.close();
                            insert_SigninAs_inDataBase(signinAs);
                            AnchorPane pane = FXMLLoader.load(getClass().getResource("/dashboard/Menu.fxml"));
                            main_anchorPane.getChildren().setAll(pane);
                        }
                        if ((username.getText()).equals(user) && (password.getText()).equals(pass)) {
                            label.setText("Sorry you can't login as Admin.");
                            flag = true;
                        }
                    } // Login as Admin is not selected:
                    else if ((username.getText()).equals(user) && (password.getText()).equals(pass)) {
                        try {
                            pst.close();
                            rs.close();
                            insert_SigninAs_inDataBase("Clerk");
                            AnchorPane pane = FXMLLoader.load(getClass().getResource("/dashboard/Menu.fxml"));
                            main_anchorPane.getChildren().setAll(pane);
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null, "Error: " + e);
                        }
                    }
                }
                if (flag == false) {
                    label.setText("Sorry Invalid user name or Password.");
                }
                pst.close();
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            } catch (IOException ex) {
                Logger.getLogger(Login_Page.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void insert_SigninAs_inDataBase(String signinAs) {
        try {
            String qquery = "insert into Loggedin values(?)";
            pst = conn.prepareStatement(qquery);

            pst.setString(1, signinAs);

            pst.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
}
