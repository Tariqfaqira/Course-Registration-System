package teacher;

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

public class EditTeacher implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    private TextField contactNo;
    @FXML
    private TextField name;
    @FXML
    private TextField cnic;
    @FXML
    private TextField cur_address;
    @FXML
    private TextField per_address;
    @FXML
    private TextField teaching_subject1;
    @FXML
    private TextField teaching_subject2;
    @FXML
    private TextField teaching_subject3;
    @FXML
    private TextField teaching_subject4;
    @FXML
    private TextField teaching_subject5;
    @FXML
    private TextField bachlar;
    @FXML
    private TextField master;
    @FXML
    private TextField phd;
    @FXML
    private TextField extra_colification1;
    @FXML
    private TextField extra_colification2;
    @FXML
    private TextField gender;
    @FXML
    private TextField id;
    @FXML
    private TextField fName;
    @FXML
    private TextField date;
    @FXML
    private TextField aage;
    @FXML
    private AnchorPane anchorPane_hide_main;
    @FXML
    private AnchorPane anchorPane_hide_Btns;
    @FXML
    private AnchorPane find_anchorPane;
    @FXML
    private TextField findID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = sql_connect.ConnectcrDB();
    }

    @FXML
    private void handle_updateCancelBtn(ActionEvent event) {
        chang_scene_method("EditTeacher.fxml");
    }

    @FXML
    private void handle_EnterPresed_AllTxtFields(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            updateDataIntoDataBase();
        }
    }

    @FXML
    private void handle_updateBtn(ActionEvent event) {
        updateDataIntoDataBase();
    }

    void updateDataIntoDataBase() {
        boolean flag = true;
        if ((contactNo.getText()).isEmpty()) {
            contactNo.setPromptText("You can't leave this field empty.");
            contactNo.setStyle("-fx-prompt-text-fill: #ff8080;");
            flag = false;
        }
        if ((name.getText()).isEmpty()) {
            name.setPromptText("You can't leave this field empty.");
            name.setStyle("-fx-prompt-text-fill: #ff8080");
            flag = false;
        }
        if ((cnic.getText()).isEmpty()) {
            cnic.setPromptText("You can't leave this field empty.");
            cnic.setStyle("-fx-prompt-text-fill: #ff8080");
            flag = false;
        }
        if ((cur_address.getText()).isEmpty()) {
            cur_address.setPromptText("You can't leave this field empty.");
            cur_address.setStyle("-fx-prompt-text-fill: #ff8080");
            flag = false;
        }
        if ((per_address.getText()).isEmpty()) {
            per_address.setPromptText("You can't leave this field empty.");
            per_address.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((teaching_subject1.getText()).isEmpty()) {
            teaching_subject1.setPromptText("You can't leave this field empty.");
            teaching_subject1.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((bachlar.getText()).isEmpty()) {
            bachlar.setPromptText("You can't leave this field empty.");
            bachlar.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((master.getText()).isEmpty()) {
            master.setPromptText("You can't leave this field empty.");
            master.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((gender.getText()).isEmpty()) {
            gender.setPromptText("You can't leave this field empty.");
            gender.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((id.getText()).isEmpty()) {
            id.setPromptText("You can't leave this field empty.");
            id.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((fName.getText()).isEmpty()) {
            fName.setPromptText("You can't leave this field empty.");
            fName.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((date.getText()).isEmpty()) {
            date.setPromptText("You can't leave this field empty.");
            date.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if ((aage.getText()).isEmpty()) {
            aage.setPromptText("You can't leave this field empty.");
            aage.setStyle("-fx-prompt-text-fill: ff8080");
            flag = false;
        }
        if (flag == true) {
            try {
                pst = null;
                String query = "update Teacher set ID=?,"
                        + "Name=?,"
                        + "Father_Name=?,"
                        + "Gender=?,"
                        + "Age=?,"
                        + "CNIC_Number=?,"
                        + "Bachlar_Degree=?,"
                        + "Master_Degree=?,"
                        + "PHD_Degree=?,"
                        + "Extra_Qualification_1=?,"
                        + "Extra_Qualification_2=?,"
                        + "Teaching_Subject_1=?,"
                        + "Teaching_Subject_2=?,"
                        + "Teaching_Subject_3=?,"
                        + "Teaching_Subject_4=?,"
                        + "Teaching_Subject_5=?,"
                        + "Date=?,"
                        + "Contact_Number=?,"
                        + "Current_Address=?,"
                        + "Permanent_Address=?"
                        + "where ID='" + findID.getText() + "'";
                pst = conn.prepareStatement(query);

                pst.setString(1, id.getText());
                pst.setString(2, name.getText());
                pst.setString(3, fName.getText());
                pst.setString(4, gender.getText());
                pst.setString(5, aage.getText());
                pst.setString(6, cnic.getText());
                pst.setString(7, bachlar.getText());
                pst.setString(8, master.getText());
                pst.setString(9, phd.getText());
                pst.setString(10, extra_colification1.getText());
                pst.setString(11, extra_colification2.getText());
                pst.setString(12, teaching_subject1.getText());
                pst.setString(13, teaching_subject2.getText());
                pst.setString(14, teaching_subject3.getText());
                pst.setString(15, teaching_subject4.getText());
                pst.setString(16, teaching_subject5.getText());
                pst.setString(17, date.getText());
                pst.setString(18, contactNo.getText());
                pst.setString(19, cur_address.getText());
                pst.setString(20, per_address.getText());

                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Data has been successfully updated");
                alert.showAndWait();

                chang_scene_method("EditTeacher.fxml");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
        }
    }

    @FXML
    private void handle_findEnter_pressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            loadDtaFromDatabase_setToForm();
        }
    }

    @FXML
    private void handle_findIDinDB(ActionEvent event) {
        loadDtaFromDatabase_setToForm();
    }

    @FXML
    private void handle_findCancle(ActionEvent event) {
        chang_scene_method("Menu_Teacher.fxml");
    }

    private void loadDtaFromDatabase_setToForm() {
        String query = "select * from Teacher where ID = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, findID.getText());
            rs = pst.executeQuery();

            while (rs.next()) {
                id.setText(rs.getString("ID"));
                name.setText(rs.getString("Name"));
                fName.setText(rs.getString("Father_Name"));
                gender.setText(rs.getString("Gender"));
                aage.setText(rs.getString("Age"));
                cnic.setText(rs.getString("CNIC_Number"));
                bachlar.setText(rs.getString("Bachlar_Degree"));
                master.setText(rs.getString("Master_Degree"));
                phd.setText(rs.getString("PHD_Degree"));
                extra_colification1.setText(rs.getString("Extra_Qualification_1"));
                extra_colification2.setText(rs.getString("Extra_Qualification_2"));
                teaching_subject1.setText(rs.getString("Teaching_Subject_1"));
                teaching_subject2.setText(rs.getString("Teaching_Subject_2"));
                teaching_subject3.setText(rs.getString("Teaching_Subject_3"));
                teaching_subject4.setText(rs.getString("Teaching_Subject_4"));
                teaching_subject5.setText(rs.getString("Teaching_Subject_5"));
                date.setText(rs.getString("Date"));
                contactNo.setText(rs.getString("Contact_Number"));
                cur_address.setText(rs.getString("Current_Address"));
                per_address.setText(rs.getString("Permanent_Address"));
            }

            pst.close();
            rs.close();
            if ((id.getText()).isEmpty() || (id.getText()) == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("ID not found.");
                alert.showAndWait();

                chang_scene_method("EditTeacher.fxml");
            } else {
                find_anchorPane.setVisible(false);
                anchorPane_hide_main.setVisible(true);
                anchorPane_hide_Btns.setVisible(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Not found." + e);
        }
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
