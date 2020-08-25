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

public class AddNewCourse implements Initializable {

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
    private void handle_saveBtn(ActionEvent event) {
        saveToDatabase();
    }

    @FXML
    private void handleEnterPressed_AllTxtFields(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            saveToDatabase();
        }
    }

    private void saveToDatabase() {
        boolean flag = true;

        if ((code.getText()).isEmpty()) {
            code.setPromptText("You can't leave this field empty.");
            code.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((name.getText()).isEmpty()) {
            name.setPromptText("You can't leave this field empty.");
            name.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((creditHrs.getText()).isEmpty()) {
            creditHrs.setPromptText("You can't leave this field empty.");
            creditHrs.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if (flag == true) {
            try {
                String query = "insert into Courses values(?,?,?)";
                pst = conn.prepareStatement(query);

                pst.setString(1, code.getText());
                pst.setString(2, name.getText());
                pst.setString(3, creditHrs.getText());

                pst.execute();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Course has been successfully added.");
                alert.showAndWait();
                chang_scene_method("Menu_Courses_AddNewCourse.fxml");

            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Error in database: " + e);
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void handle_cancleBtn(ActionEvent event) {
        chang_scene_method("Menu_Courses.fxml");
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
