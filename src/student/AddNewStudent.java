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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import database.sql_connect;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.CheckBox;

public class AddNewStudent implements Initializable {

    @FXML
    private AnchorPane Add_NewStd_anchorPane;

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

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String sesion;
    @FXML
    private CheckBox fallCheckBox;
    @FXML
    private CheckBox springCheckBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = sql_connect.ConnectcrDB();
    }

    @FXML
    private void handle_fallBox(ActionEvent event) {
        if(springCheckBox.isSelected()){
            springCheckBox.setSelected(false);
        }
        sesion = "Fall";
    }

    @FXML
    private void handle_SpringBox(ActionEvent event) {
        if(fallCheckBox.isSelected()){
            fallCheckBox.setSelected(false);
        }
        sesion = "Spring";
    }

    @FXML
    private void handle_saveBtn(ActionEvent event) {
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
                String query = "insert into Student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Student has been successfully added");
                alert.showAndWait();
                AnchorPane pane = FXMLLoader.load(getClass().getResource("AddNewStudent.fxml"));
                Add_NewStd_anchorPane.getChildren().setAll(pane);

            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Student addition failed: " + e);
                alert.showAndWait();
            } catch (IOException ex) {
                Logger.getLogger(AddNewStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void handle_cancleBtn(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Menu_Student.fxml"));
            Add_NewStd_anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
}
