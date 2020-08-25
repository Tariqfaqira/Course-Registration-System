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

public class EditStudent implements Initializable {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String sesion;

    @FXML
    private TextField regNo;
    @FXML
    private TextField domicile;
    @FXML
    private TextField name;
    @FXML
    private TextField dob;
    @FXML
    private TextField fName;
    @FXML
    private TextField cnic;
    @FXML
    private TextField per_address;
    @FXML
    private TextField cur_address;
    @FXML
    private TextField batch_year;
    @FXML
    private TextField degreeProg;
    @FXML
    private TextField contact;
    @FXML
    private TextField gender;
    @FXML
    private TextField fContact;
    @FXML
    private TextField degreeYear;
    @FXML
    private TextField date;
    @FXML
    private TextField email;
    @FXML
    private CheckBox fall;
    @FXML
    private CheckBox spring;

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private AnchorPane anchorPane_hide_main;
    @FXML
    private AnchorPane anchorPane_hide_Btns;
    @FXML
    private AnchorPane find_anchorPane;
    @FXML
    private TextField findReg;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = sql_connect.ConnectcrDB();
    }

    @FXML
    private void handle_fallBox(ActionEvent event) {
        sesion = "Fall";
    }

    @FXML
    private void handle_SpringBox(ActionEvent event) {
        sesion = "Spring";
    }

    @FXML
    private void handle_updateBtn(ActionEvent event) {
        updateDataIntoDataBase();
    }

    @FXML
    private void handle_EnterPressed_UpdateForm(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            updateDataIntoDataBase();
        }
    }

    private void updateDataIntoDataBase() {
        boolean flag = true;

        if ((regNo.getText()).isEmpty()) {
            regNo.setPromptText("You can't leave this field empty.");
            regNo.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((domicile.getText()).isEmpty()) {
            domicile.setPromptText("You can't leave this field empty.");
            domicile.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((name.getText()).isEmpty()) {
            name.setPromptText("You can't leave this field empty.");
            name.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((dob.getText()).isEmpty()) {
            dob.setPromptText("You can't leave this field empty.");
            dob.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((fName.getText()).isEmpty()) {
            fName.setPromptText("You can't leave this field empty.");
            fName.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((cnic.getText()).isEmpty()) {
            cnic.setPromptText("You can't leave this field empty.");
            cnic.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((per_address.getText()).isEmpty()) {
            per_address.setPromptText("You can't leave this field empty.");
            per_address.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((cur_address.getText()).isEmpty()) {
            cur_address.setPromptText("You can't leave this field empty.");
            cur_address.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((batch_year.getText()).isEmpty()) {
            batch_year.setPromptText("You can't leave this field empty.");
            batch_year.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((degreeProg.getText()).isEmpty()) {
            degreeProg.setPromptText("You can't leave this field empty.");
            degreeProg.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((contact.getText()).isEmpty()) {
            contact.setPromptText("You can't leave this field empty.");
            contact.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((gender.getText()).isEmpty()) {
            gender.setPromptText("You can't leave this field empty.");
            gender.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((degreeYear.getText()).isEmpty()) {
            degreeYear.setPromptText("You can't leave this field empty.");
            degreeYear.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((date.getText()).isEmpty()) {
            date.setPromptText("You can't leave this field empty.");
            date.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }

        if (flag == true) {
            try {
                String query = "update Student set Reg_No=?,"
                        + "Name=?,"
                        + "Father_Name=?,"
                        + "DOB=?,"
                        + "Gender=?,"
                        + "CNIC=?,"
                        + "Batch_Year=?,"
                        + "Session=?,"
                        + "Degree_Prog=?,"
                        + "Degree_Year=?,"
                        + "Date=?,"
                        + "Contact=?,"
                        + "Father_contact=?,"
                        + "Email=?,"
                        + "Domicile=?,"
                        + "Permanent_Address=?,"
                        + "Current_Address=?"
                        + "where Reg_No='" + findReg.getText() + "'";
                pst = conn.prepareStatement(query);

                pst.setString(1, (regNo.getText()));
                pst.setString(2, name.getText());
                pst.setString(3, fName.getText());
                pst.setString(4, dob.getText());
                pst.setString(5, gender.getText());
                pst.setString(6, cnic.getText());
                pst.setString(7, batch_year.getText());
                pst.setString(8, sesion);
                pst.setString(9, degreeProg.getText());
                pst.setString(10, degreeYear.getText());
                pst.setString(11, date.getText());
                pst.setString(12, contact.getText());
                pst.setString(13, fContact.getText());
                pst.setString(14, email.getText());
                pst.setString(15, domicile.getText());
                pst.setString(16, cur_address.getText());
                pst.setString(17, per_address.getText());

                pst.execute();

                String query1 = "update Course_Registered set Reg_No=?,"
                        + "Name=?,"
                        + "Batch_Year=?,"
                        + "Session=?,"
                        + "Degree_Prog=?,"
                        + "Date=?,"
                        + "Contact=?,"
                        + "Father_contact=?,"
                        + "Current_Address=?"
                        + "where Reg_No='" + findReg.getText() + "'";
                pst = conn.prepareStatement(query1);
                pst.setString(1, (regNo.getText()));
                pst.setString(2, name.getText());
                pst.setString(3, batch_year.getText());
                pst.setString(4, sesion);
                pst.setString(5, degreeProg.getText());
                pst.setString(6, date.getText());
                pst.setString(7, contact.getText());
                pst.setString(8, fContact.getText());
                pst.setString(9, cur_address.getText());

                pst.execute();
                pst.close();
                conn.close();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Data has been successfully updated");
                alert.showAndWait();

                chang_scene_method("EditStudent.fxml");
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Data updation failed.");
                alert.showAndWait();
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
    private void handle_enter_presser(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            loadDtaFromDatabase_setToForm();
        }
    }

    private void loadDtaFromDatabase_setToForm() {
        String T_query = "select * from Student where Reg_No = ?";
        try {
            pst = conn.prepareStatement(T_query);
            pst.setString(1, findReg.getText());
            rs = pst.executeQuery();

            while (rs.next()) {
                regNo.setText(rs.getString("Reg_No"));
                name.setText(rs.getString("Name"));
                fName.setText(rs.getString("Father_Name"));
                dob.setText(rs.getString("DOB"));
                gender.setText(rs.getString("Gender"));
                cnic.setText(rs.getString("CNIC"));
                batch_year.setText(rs.getString("Batch_Year"));
                sesion = rs.getString("Session");
                degreeProg.setText(rs.getString("Degree_Prog"));
                degreeYear.setText(rs.getString("Degree_Year"));
                date.setText(rs.getString("Date"));
                contact.setText(rs.getString("Contact"));
                fContact.setText(rs.getString("Father_Contact"));
                email.setText(rs.getString("Email"));
                domicile.setText(rs.getString("Domicile"));
                cur_address.setText(rs.getString("Current_Address"));
                per_address.setText(rs.getString("Permanent_Address"));
                if (sesion.equals("Fall")) {
                    fall.setSelected(true);
                } else if (sesion.equals("Spring")) {
                    spring.setSelected(true);
                }
            }

            pst.close();
            rs.close();
            if ((regNo.getText()).isEmpty() || (regNo.getText()) == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Reg number not found.");
                alert.showAndWait();
                chang_scene_method("EditStudent.fxml");
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
