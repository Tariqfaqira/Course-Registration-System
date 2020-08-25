package dashboard;

import database.sql_connect;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

public class Menu implements Initializable {

    Connection conn = sql_connect.ConnectcrDB();
    PreparedStatement pst = null;
    ResultSet rs = null;
    String signinAs;

    @FXML
    private AnchorPane main_anchorPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button adminBtn;
    @FXML
    private Button studentBtn;
    @FXML
    private Button teacherBtn;
    @FXML
    private Button reportBtn;
    @FXML
    private Button helpBtn;
    @FXML
    private Button courseBtn;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handle_Student(ActionEvent event) {
        chang_scene_method("/student/Menu_Student.fxml");
    }

    @FXML
    private void handle_Admin(ActionEvent event) {
        String query = "select * from Loggedin";
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                signinAs = rs.getString("Signedin");
            }
            if (signinAs.equals("Admin")) {
                chang_scene_method("/admin/Menu_Admin.fxml");
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("You don't have enough permition.");
                alert.showAndWait();
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    @FXML
    private void handle_Teacher(ActionEvent event) {
        chang_scene_method("/teacher/Menu_Teacher.fxml");
    }

    @FXML
    private void handle_report(ActionEvent event) {
        chang_scene_method("/report/Menu_Report_Student.fxml");
    }

    @FXML
    private void handle_help(ActionEvent event) {
    }

    //Handle Sign out event:
    @FXML
    private void handle_signoutBtn(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/login/Login_Page.fxml"));
            main_anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    @FXML
    private void handle_Course(ActionEvent event) {
        chang_scene_method("/course/Menu_Courses.fxml");
    }

    //Methods to chang the scene:
    void chang_scene_method(String FXML_Name) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(FXML_Name));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
}
