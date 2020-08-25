package student;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import database.sql_connect;

public class EditCourseRegistered implements Initializable {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    private AnchorPane anchorPane;

    String semester;
    String session;
    @FXML
    private TextField regNO;
    @FXML
    private TextField sname;
    @FXML
    private TextField contact;
    @FXML
    private TextField father_contact;
    @FXML
    private TextField course1_code;
    @FXML
    private TextField course1_name;
    @FXML
    private TextField course1_credtHrs;
    @FXML
    private TextField course2_code;
    @FXML
    private TextField course2_name;
    @FXML
    private TextField course2_credtHrs;
    @FXML
    private TextField course3_code;
    @FXML
    private TextField course3_name;
    @FXML
    private TextField course3_credtHrs;
    @FXML
    private TextField course4_code;
    @FXML
    private TextField course4_name;
    @FXML
    private TextField course4_credtHrs;
    @FXML
    private TextField course5_code;
    @FXML
    private TextField course5_name;
    @FXML
    private TextField course5_credtHrs;
    @FXML
    private TextField course6_code;
    @FXML
    private TextField course6_name;
    @FXML
    private TextField course6_credtHrs;
    @FXML
    private TextField course7_code;
    @FXML
    private TextField course7_name;
    @FXML
    private TextField course7_credtHrs;
    @FXML
    private TextField cur_address;
    @FXML
    private TextField batch;
    @FXML
    private TextField degreeeProg;
    @FXML
    private TextField date;

    // For search purpose, regno in database ;
    @FXML
    private AnchorPane find_anchorPane;
    @FXML
    private TextField findReg;
    @FXML
    private AnchorPane anchorPane_hide_main;
    @FXML
    private AnchorPane anchorPane_hide_Btns;
    @FXML
    private CheckBox summer;
    @FXML
    private CheckBox fall;
    @FXML
    private CheckBox spring;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = sql_connect.ConnectcrDB();
    }// End of initialize.

    @FXML
    private void handle_Summer(ActionEvent event) {
        session = "Summer";
    }

    @FXML
    private void handle_Fall(ActionEvent event) {
        session = "Fall";
    }

    @FXML
    private void handle_Spring(ActionEvent event) {
        session = "Spring";
    }

    @FXML
    private void handle_smester1(ActionEvent event) {
        semester = "1";
    }

    @FXML
    private void handle_smester2(ActionEvent event) {
        semester = "2";
    }

    @FXML
    private void handle_smester3(ActionEvent event) {
        semester = "3";
    }

    @FXML
    private void handle_smester4(ActionEvent event) {
        semester = "4";
    }

    @FXML
    private void handle_smester5(ActionEvent event) {
        semester = "5";
    }

    @FXML
    private void handle_smester6(ActionEvent event) {
        semester = "6";
    }

    @FXML
    private void handle_smester7(ActionEvent event) {
        semester = "7";
    }

    @FXML
    private void handle_smester8(ActionEvent event) {
        semester = "8";
    }

    @FXML
    private void handle_updateBtn(ActionEvent event) {
        updateDataIntoDataBassew();
    }

    @FXML
    private void handle_Enter_keyPressed_textFieldOf_UpdateForm(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            updateDataIntoDataBassew();
        }
    }

    void updateDataIntoDataBassew() {
        boolean flag = true;

        if ((regNO.getText()).isEmpty()) {
            regNO.setPromptText("You can't leave this field empty.");
            regNO.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((contact.getText()).isEmpty()) {
            contact.setPromptText("You can't leave this field empty.");
            contact.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((sname.getText()).isEmpty()) {
            sname.setPromptText("You can't leave this field empty.");
            sname.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((course1_code.getText()).isEmpty()) {
            course1_code.setPromptText("You can't leave this field empty.");
            course1_code.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((course1_name.getText()).isEmpty()) {
            course1_name.setPromptText("You can't leave this field empty.");
            course1_name.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((course1_credtHrs.getText()).isEmpty()) {
            course1_credtHrs.setPromptText("You can't leave this field empty.");
            course1_credtHrs.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((course2_code.getText()).isEmpty()) {
            course2_code.setPromptText("You can't leave this field empty.");
            course2_code.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((course2_name.getText()).isEmpty()) {
            course2_name.setPromptText("You can't leave this field empty.");
            course2_name.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((cur_address.getText()).isEmpty()) {
            cur_address.setPromptText("You can't leave this field empty.");
            cur_address.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((batch.getText()).isEmpty()) {
            batch.setPromptText("You can't leave this field empty.");
            batch.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((degreeeProg.getText()).isEmpty()) {
            degreeeProg.setPromptText("You can't leave this field empty.");
            degreeeProg.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((date.getText()).isEmpty()) {
            date.setPromptText("You can't leave this field empty.");
            date.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }

        if (flag == true) {
            try {
                pst = null;
                String query = "update Course_Registered set Reg_No=?,"
                        + "Name=?,"
                        + "Session=?,"
                        + "Semester=?,"
                        + "Batch_Year=?,"
                        + "Degree_Prog=?,"
                        + "Date=?,"
                        + "Contact=?,"
                        + "Father_Contact=?,"
                        + "Current_Address=?,"
                        + "Course1_Code=?,"
                        + "Course1_Name=?,"
                        + "Course1_CreditHrs=?,"
                        + "Course2_Code=?,"
                        + "Course2_Name=?,"
                        + "Course2_CreditHrs=?,"
                        + "Course3_Code=?,"
                        + "Course3_Name=?,"
                        + "Course3_CreditHrs=?,"
                        + "Course4_Code=?,"
                        + "Course4_Name=?,"
                        + "Course4_CreditHrs=?,"
                        + "Course5_Code=?,"
                        + "Course5_Name=?,"
                        + "Course5_CreditHrs=?,"
                        + "Course6_Code=?,"
                        + "Course6_Name=?,"
                        + "Course6_CreditHrs=?,"
                        + "Course7_Code=?,"
                        + "Course7_Name=?,"
                        + "Course7_CreditHrs=?"
                        + "WHERE Reg_No= '" + findReg.getText() + "'";
                pst = conn.prepareStatement(query);

                pst.setString(1, regNO.getText());
                pst.setString(2, sname.getText());
                pst.setString(3, session);
                pst.setString(4, semester);
                pst.setString(5, batch.getText());
                pst.setString(6, degreeeProg.getText());
                pst.setString(7, date.getText());
                pst.setString(8, contact.getText());
                pst.setString(9, father_contact.getText());
                pst.setString(10, cur_address.getText());
                pst.setString(11, course1_code.getText());
                pst.setString(12, course1_name.getText());
                pst.setString(13, course1_credtHrs.getText());
                pst.setString(14, course2_code.getText());
                pst.setString(15, course2_name.getText());
                pst.setString(16, course2_credtHrs.getText());
                pst.setString(17, course3_code.getText());
                pst.setString(18, course3_name.getText());
                pst.setString(19, course3_credtHrs.getText());
                pst.setString(20, course4_code.getText());
                pst.setString(21, course4_name.getText());
                pst.setString(22, course4_credtHrs.getText());
                pst.setString(23, course5_code.getText());
                pst.setString(24, course5_name.getText());
                pst.setString(25, course5_credtHrs.getText());
                pst.setString(26, course6_code.getText());
                pst.setString(27, course6_name.getText());
                pst.setString(28, course6_credtHrs.getText());
                pst.setString(29, course7_code.getText());
                pst.setString(30, course7_name.getText());
                pst.setString(31, course7_credtHrs.getText());

                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Data has been successfully updated");
                alert.showAndWait();

                chang_scene_method("EditCourseRegistered.fxml");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
        }
    }

    @FXML
    private void handle_cancleBtn(ActionEvent event) {
        chang_scene_method("Menu_Student.fxml");
    }

    @FXML
    private void handle_findRegInDB(ActionEvent event) {
        loadDtaFromDatabase_setToForm();
    }

    @FXML
    private void handle_enter_pressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            loadDtaFromDatabase_setToForm();
        }
    }

    private void loadDtaFromDatabase_setToForm() {
        String query = "select * from Course_Registered where Reg_No = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, findReg.getText());
            rs = pst.executeQuery();

            while (rs.next()) {
                regNO.setText(rs.getString("Reg_No"));
                sname.setText(rs.getString("Name"));
                session = rs.getString("Session");
                semester = rs.getString("Semester");
                batch.setText(rs.getString("Batch_Year"));
                degreeeProg.setText(rs.getString("Degree_Prog"));
                date.setText(rs.getString("Date"));
                contact.setText(rs.getString("Contact"));
                father_contact.setText(rs.getString("Father_Contact"));
                cur_address.setText(rs.getString("Current_Address"));
                course1_code.setText(rs.getString("Course1_Code"));
                course1_name.setText(rs.getString("Course1_Name"));
                course1_credtHrs.setText(rs.getString("Course1_CreditHrs"));
                course2_code.setText(rs.getString("Course2_Code"));
                course2_name.setText(rs.getString("Course2_Name"));
                course2_credtHrs.setText(rs.getString("Course2_CreditHrs"));
                course3_code.setText(rs.getString("Course3_Code"));
                course3_name.setText(rs.getString("Course3_Name"));
                course3_credtHrs.setText(rs.getString("Course3_CreditHrs"));
                course4_code.setText(rs.getString("Course4_Code"));
                course4_name.setText(rs.getString("Course4_Name"));
                course4_credtHrs.setText(rs.getString("Course4_CreditHrs"));
                course5_code.setText(rs.getString("Course5_Code"));
                course5_name.setText(rs.getString("Course5_Name"));
                course5_credtHrs.setText(rs.getString("Course5_CreditHrs"));
                course6_code.setText(rs.getString("Course6_Code"));
                course6_name.setText(rs.getString("Course6_Name"));
                course6_credtHrs.setText(rs.getString("Course6_CreditHrs"));
                course7_code.setText(rs.getString("Course7_Code"));
                course7_name.setText(rs.getString("Course7_Name"));
                course7_credtHrs.setText(rs.getString("Course7_CreditHrs"));
                switch (session) {
                    case "Fall":
                        fall.setSelected(true);
                        break;
                    case "Spring":
                        spring.setSelected(true);
                        break;
                    case "Summer":
                        summer.setSelected(true);
                        break;
                    default:
                        break;
                }
            }

            pst.close();
            rs.close();
            if ((regNO.getText()).isEmpty() || (regNO.getText()) == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Reg number not found.");
                alert.showAndWait();

                chang_scene_method("EditCourseRegistered.fxml");
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
    private void handle_findCancle(ActionEvent event) {
        chang_scene_method("Menu_Student.fxml");
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
