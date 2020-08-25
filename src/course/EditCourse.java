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

public class EditCourse implements Initializable {

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
    private AnchorPane anchorPane_hide_main;
    @FXML
    private AnchorPane anchorPane_hide_Btns;
    @FXML
    private AnchorPane find_anchorPane;
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
    private void handle_findEnter_pressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            loadDtaFromDatabase_setToForm();
        }
    }

    @FXML
    private void handle_findRegInDB(ActionEvent event) {
        loadDtaFromDatabase_setToForm();
    }

    private void loadDtaFromDatabase_setToForm() {
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

                chang_scene_method("Menu_Courses_EditCourse.fxml");
            } else {
                find_anchorPane.setVisible(false);
                anchorPane_hide_main.setVisible(true);
                anchorPane_hide_Btns.setVisible(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Not found." + e);
        }

    }

    @FXML
    private void handleEnterPressed_AllTxtFields(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            updateDataIntoDataBassew();
        }
    }

    @FXML
    private void handle_updateBtn(ActionEvent event) {
        updateDataIntoDataBassew();
    }

    void updateDataIntoDataBassew() {
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
                pst = null;
                String query = "update Courses set Course_Code=?,"
                        + "Course_Name=?,"
                        + "Course_CreditHrs=?"
                        + "WHERE Course_Code ='" + findCode.getText() + "'";
                pst = conn.prepareStatement(query);

                pst.setString(1, code.getText());
                pst.setString(2, name.getText());
                pst.setString(3, creditHrs.getText());

                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Data has been successfully updated");
                alert.showAndWait();

                chang_scene_method("Menu_Courses_EditCourse.fxml");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
        }
    }

    @FXML
    private void handle_cancleBtn(ActionEvent event) {
        chang_scene_method("Menu_Courses_EditCourse.fxml");
    }

    @FXML
    private void handle_findCancle(ActionEvent event) {
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
