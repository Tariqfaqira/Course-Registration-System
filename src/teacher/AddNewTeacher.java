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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import database.sql_connect;

public class AddNewTeacher implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    private Button saveBtn;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = sql_connect.ConnectcrDB();
        int i = 1;
        String query = "select ID from Teacher";
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                rs.getString("ID");
                i++;
            }
            id.setText("" + i);
            JOptionPane.showMessageDialog(null, "Id: "+i);
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("SQL Database Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Error in database: " + e);
            alert.showAndWait();
        }
    }

    @FXML
    private void handle_saveBtn(ActionEvent event) {
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
//        if ((id.getText()).isEmpty()) {
//            id.setPromptText("You can't leave this field empty.");
//            id.setStyle("-fx-prompt-text-fill: ff8080");
//            flag = false;
//        }
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
                String query = "insert into Teacher values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?, ?)";
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
                pst.execute();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Teacher has been successfully added");
                alert.showAndWait();
                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("AddNewTeacher.fxml"));
                    anchorPane.getChildren().setAll(pane);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e);
                }
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Teacher addition failed: " + e);
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void handle_cancleBtn(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Menu_Teacher.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
}
