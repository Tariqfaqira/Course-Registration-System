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
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import database.sql_connect;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterCourse implements Initializable {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    private TextField regNO;
    @FXML
    private TextField contact;
    @FXML
    private TextField sname;
    @FXML
    private TextField course1_code;
    @FXML
    private TextField course1_name;
    @FXML
    private TextField cur_address;
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
    private TextField batch;
    @FXML
    private TextField degreeeProg;
    @FXML
    private TextField date;
    @FXML
    private AnchorPane anchorPane;

    String semester;
    String session;
    @FXML
    private TextField father_contact;
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
    }

    @FXML
    private void handle_Summer(ActionEvent event) {
        fall.setSelected(false);
        spring.setSelected(false);
        session = "Summer";
    }

    @FXML
    private void handle_Fall(ActionEvent event) {
        summer.setSelected(false);
        spring.setSelected(false);
        session = "Fall";
    }

    @FXML
    private void handle_Spring(ActionEvent event) {
        fall.setSelected(false);
        summer.setSelected(false);
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
    private void handle_saveBtn(ActionEvent event) {
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
//        if ((course2_code.getText()).isEmpty()) {
//            course2_code.setPromptText("You can't leave this field empty.");
//            course2_code.setStyle("-fx-prompt-text-fill: ff8080");
//            flag = false;
//        }
//        if ((course2_name.getText()).isEmpty()) {
//            course2_name.setPromptText("You can't leave this field empty.");
//            course2_name.setStyle("-fx-prompt-text-fill: ff8080");
//            flag = false;
//        }
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
            boolean found = false;
            try {
                String query = "select Reg_No from Student where Reg_No = ?";
                pst = conn.prepareStatement(query);
                pst.setString(1, regNO.getText());
                rs = pst.executeQuery();

                while (rs.next()) {
                    if (rs.getString("Reg_No").equals(regNO.getText())) {
                        found = true;
                    }
                }

                if (found == false) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Student does not exists.");
                    alert.showAndWait();
                } else {

                    String query1 = "insert into Course_Registered values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    pst = conn.prepareStatement(query1);

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

                    pst.execute();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Course has been successfully registered");
                    alert.showAndWait();

                    AnchorPane pane = FXMLLoader.load(getClass().getResource("RegisterCourse.fxml"));
                    anchorPane.getChildren().setAll(pane);
                }
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Course registration failed: " + e);
                alert.showAndWait();
            } catch (IOException ex) {
                Logger.getLogger(RegisterCourse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void handle_cancleBtn(ActionEvent event
    ) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Menu_Student.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
}
