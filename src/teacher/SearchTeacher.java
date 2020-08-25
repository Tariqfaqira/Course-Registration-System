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

public class SearchTeacher implements Initializable {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField contactNo;
    @FXML
    private TextField aage;
    @FXML
    private TextField cnic;
    @FXML
    private TextField gender;
    @FXML
    private TextField cur_address;
    @FXML
    private TextField per_address;
    @FXML
    private TextField id;
    @FXML
    private TextField fName;
    @FXML
    private TextField name;
    @FXML
    private TextField date;
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
    private TextField phd;
    @FXML
    private TextField extra_colification2;
    @FXML
    private TextField extra_colification21;
    @FXML
    private TextField bachlar;
    @FXML
    private TextField master;
    @FXML
    private TextField extra_colification1;
    @FXML
    private TextField findID;

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
    private void EnterPressed_searchTextField(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            loadDtaFromDatabase_setToForm();
        }
    }

    @FXML
    private void handle_searchBtn(ActionEvent event) {
        loadDtaFromDatabase_setToForm();
    }

    @FXML
    private void handle_gobackBtn(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Menu_Teacher.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
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

                chang_scene_method("SearchTeacher.fxml");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Not found." + e);
        }
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
