package student;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

public class Menu_Student implements Initializable {

    @FXML
    private AnchorPane std_anchorPane;

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
    private void handle_register_newStudent(ActionEvent event) {
        chang_scene_method("AddNewStudent.fxml");
    }

    @FXML
    private void handle_courseRegister(ActionEvent event) {
        chang_scene_method("RegisterCourse.fxml");
    }

    @FXML
    private void handle_showCourseRegistered(ActionEvent event) {
        chang_scene_method("ShowCourseRegistered.fxml");
    }

    @FXML
    private void handle_showAllStudent(ActionEvent event) {
        chang_scene_method("ShowAllStudentList.fxml");
    }

    @FXML
    private void handle_edit_CourseRegister(ActionEvent event) {
        chang_scene_method("EditCourseRegistered.fxml");
    }

    @FXML
    private void handle_Edit_Student(ActionEvent event) {
        chang_scene_method("EditStudent.fxml");
    }

    void chang_scene_method(String FXML_Name) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(FXML_Name));
            std_anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
}
