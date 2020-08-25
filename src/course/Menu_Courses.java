package course;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

public class Menu_Courses implements Initializable {

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
        // TODO
    }

    @FXML
    private void handle_AddCourse(ActionEvent event) {
        chang_scene_method("AddNewCourse.fxml");
    }

    @FXML
    private void handle_ShowCourse(ActionEvent event) {
        chang_scene_method("ShowCourses.fxml");
    }

    @FXML
    private void handle_searchCourse(ActionEvent event) {
        chang_scene_method("SearchCourses.fxml");
    }

    @FXML
    private void handle_EditCourse(ActionEvent event) {
        chang_scene_method("EditCourse.fxml");
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
