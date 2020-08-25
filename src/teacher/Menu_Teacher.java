package teacher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

public class Menu_Teacher implements Initializable {

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
    }

    @FXML
    private void add_new_teacher(ActionEvent event) {
        chang_scene_method("AddNewTeacher.fxml");
    }

    @FXML
    private void show_techer_list(ActionEvent event) {
        chang_scene_method("ShowTeacherList.fxml");
    }

    @FXML
    private void edit_teacher_data(ActionEvent event) {
        chang_scene_method("EditTeacher.fxml");
    }

    @FXML
    private void search_teacher_data(ActionEvent event) {
        chang_scene_method("SearchTeacher.fxml");
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
