package student;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import database.sql_connect;

public class ShowAllStudentList implements Initializable {

    @FXML
    private TableView<Student> S_tableView;
    @FXML
    private TableColumn<Student, Integer> S_sNO;
    @FXML
    private TableColumn<Student, String> S_regNo;
    @FXML
    private TableColumn<Student, String> S_name;
    @FXML
    private TableColumn<Student, String> S_fName;
    @FXML
    private TableColumn<Student, String> S_dob;
    @FXML
    private TableColumn<Student, String> S_gender;
    @FXML
    private TableColumn<Student, String> S_cnic;
    @FXML
    private TableColumn<Student, String> S_batch;
    @FXML
    private TableColumn<Student, String> S_session;
    @FXML
    private TableColumn<Student, String> S_degreeProg;
    @FXML
    private TableColumn<Student, String> S_degreeYear;
    @FXML
    private TableColumn<Student, String> S_date;
    @FXML
    private TableColumn<Student, String> S_contact;
    @FXML
    private TableColumn<Student, String> S_Father_contact;
    @FXML
    private TableColumn<Student, String> S_email;
    @FXML
    private TableColumn<Student, String> S_domicile;
    @FXML
    private TableColumn<Student, String> S_cur_Address;
    @FXML
    private TableColumn<Student, String> S_per_Address;

    ObservableList<Student> S_data = FXCollections.observableArrayList();
    Connection conn = sql_connect.ConnectcrDB();
    PreparedStatement pst;
    ResultSet rs;
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
        S_sNO.setCellValueFactory(new PropertyValueFactory<Student, Integer>("sNO"));
        S_regNo.setCellValueFactory(new PropertyValueFactory<Student, String>("regNo"));
        S_name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        S_fName.setCellValueFactory(new PropertyValueFactory<Student, String>("fName"));
        S_dob.setCellValueFactory(new PropertyValueFactory<Student, String>("dob"));
        S_gender.setCellValueFactory(new PropertyValueFactory<Student, String>("gender"));
        S_cnic.setCellValueFactory(new PropertyValueFactory<Student, String>("cnic"));
        S_batch.setCellValueFactory(new PropertyValueFactory<Student, String>("batch"));
        S_session.setCellValueFactory(new PropertyValueFactory<Student, String>("session"));
        S_degreeProg.setCellValueFactory(new PropertyValueFactory<Student, String>("degreeProg"));
        S_degreeYear.setCellValueFactory(new PropertyValueFactory<Student, String>("degreeYear"));
        S_date.setCellValueFactory(new PropertyValueFactory<Student, String>("date"));
        S_contact.setCellValueFactory(new PropertyValueFactory<Student, String>("contact"));
        S_Father_contact.setCellValueFactory(new PropertyValueFactory<Student, String>("Father_contact"));
        S_email.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        S_domicile.setCellValueFactory(new PropertyValueFactory<Student, String>("domicile"));
        S_cur_Address.setCellValueFactory(new PropertyValueFactory<Student, String>("cur_Address"));
        S_per_Address.setCellValueFactory(new PropertyValueFactory<Student, String>("per_Address"));

        int i = 1;
        pst = null;
        rs = null;
        String S_query = "select * from Student";
        try {
            pst = conn.prepareStatement(S_query);
            rs = pst.executeQuery();
            while (rs.next()) {
                S_data.add(new Student(i++,
                        rs.getString("Reg_No"),
                        rs.getString("Name"),
                        rs.getString("Father_Name"),
                        rs.getString("DOB"),
                        rs.getString("Gender"),
                        rs.getString("CNIC"),
                        rs.getString("Batch_Year"),
                        rs.getString("Session"),
                        rs.getString("Degree_Prog"),
                        rs.getString("Degree_Year"),
                        rs.getString("Date"),
                        rs.getString("Contact"),
                        rs.getString("Father_contact"),
                        rs.getString("Email"),
                        rs.getString("Domicile"),
                        rs.getString("Permanent_Address"),
                        rs.getString("Current_Address")
                ));
                S_tableView.setItems(S_data);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Reg number not found.");
            alert.showAndWait();
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Menu_Student.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
}
