package course;

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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import database.sql_connect;

public class SearchCourses implements Initializable {

    Connection conn = sql_connect.ConnectcrDB();
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField code;
    @FXML
    private TextField name;
    @FXML
    private TextField creditHrs;
    @FXML
    private TextField findCode;

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

    @FXML
    private void EnterPressed_searchTextField(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            course_search_method();
        }
    }

    @FXML
    private void handle_searchBtn(ActionEvent event) {
        course_search_method();
    }

    private void course_search_method() {
        String query = "select * from Courses where Course_Code = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, findCode.getText());
            rs = pst.executeQuery();

            while (rs.next()) {
                code.setText(rs.getString("Course_Code"));
                name.setText(rs.getString("Course_Name"));
                creditHrs.setText(rs.getString("Course_CreditHrs"));
            }
            pst.close();
            rs.close();
            if ((code.getText()).isEmpty() || (code.getText()) == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Course not found.");
                alert.showAndWait();

                chang_scene_method("Menu_Courses_SearchCourses.fxml");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Not found." + e);
        }
    }

    @FXML
    private void handle_gobackBtn(ActionEvent event) {
        chang_scene_method("Menu_Courses.fxml");
    }

    void chang_scene_method(String FXML_Name) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(FXML_Name));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
}
