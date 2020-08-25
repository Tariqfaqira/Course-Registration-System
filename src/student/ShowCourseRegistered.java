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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import course.CourseRegistered;
import database.sql_connect;

public class ShowCourseRegistered implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TableView<CourseRegistered> CR_tableView;
    @FXML
    private TableColumn<CourseRegistered, Integer> CR_sNo;
    @FXML
    private TableColumn<CourseRegistered, String> CR_regNo;
    @FXML
    private TableColumn<CourseRegistered, String> CR_name;
    @FXML
    private TableColumn<CourseRegistered, String> CR_session;
    @FXML
    private TableColumn<CourseRegistered, String> CR_semester;
    @FXML
    private TableColumn<CourseRegistered, String> CR_batch;
    @FXML
    private TableColumn<CourseRegistered, String> CR_degreeProg;
    @FXML
    private TableColumn<CourseRegistered, String> CR_date;
    @FXML
    private TableColumn<CourseRegistered, String> CR_contact;
    @FXML
    private TableColumn<CourseRegistered, String> CR_father_contact;
    @FXML
    private TableColumn<CourseRegistered, String> CR_cur_address;
    @FXML
    private TableColumn<CourseRegistered, String> CR_Ccode1;
    @FXML
    private TableColumn<CourseRegistered, String> CR_Cname1;
    @FXML
    private TableColumn<CourseRegistered, String> CR_CcreditHrs1;
    @FXML
    private TableColumn<CourseRegistered, String> CR_Ccode2;
    @FXML
    private TableColumn<CourseRegistered, String> CR_Cname2;
    @FXML
    private TableColumn<CourseRegistered, String> CR_CcreditHrs2;
    @FXML
    private TableColumn<CourseRegistered, String> CR_Ccode3;
    @FXML
    private TableColumn<CourseRegistered, String> CR_Cname3;
    @FXML
    private TableColumn<CourseRegistered, String> CR_CcreditHrs3;
    @FXML
    private TableColumn<CourseRegistered, String> CR_Ccode4;
    @FXML
    private TableColumn<CourseRegistered, String> CR_Cname4;
    @FXML
    private TableColumn<CourseRegistered, String> CR_CcreditHrs4;
    @FXML
    private TableColumn<CourseRegistered, String> CR_Ccode5;
    @FXML
    private TableColumn<CourseRegistered, String> CR_Cname5;
    @FXML
    private TableColumn<CourseRegistered, String> CR_CcreditHrs5;
    @FXML
    private TableColumn<CourseRegistered, String> CR_Ccode6;
    @FXML
    private TableColumn<CourseRegistered, String> CR_Cname6;
    @FXML
    private TableColumn<CourseRegistered, String> CR_CcreditHrs6;
    @FXML
    private TableColumn<CourseRegistered, String> CR_Ccode7;
    @FXML
    private TableColumn<CourseRegistered, String> CR_Cname7;
    @FXML
    private TableColumn<CourseRegistered, String> CR_CcreditHrs7;

    ObservableList<CourseRegistered> CR_data = FXCollections.observableArrayList();
    Connection conn = sql_connect.ConnectcrDB();
    PreparedStatement pst;
    ResultSet rs;    

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CR_sNo.setCellValueFactory(new PropertyValueFactory<CourseRegistered, Integer>("sNo"));
        CR_regNo.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("regNo"));
        CR_name.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("name"));
        CR_session.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("session"));
        CR_semester.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("semester"));
        CR_batch.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("batch"));
        CR_degreeProg.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("degreeProg"));
        CR_date.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("date"));
        CR_contact.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("contact"));
        CR_father_contact.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("father_contact"));
        CR_cur_address.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("cur_address"));        
        CR_Ccode1.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Ccode1"));
        CR_Cname1.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Cname1"));
        CR_CcreditHrs1.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("CcreditHrs1"));
        CR_Ccode2.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Ccode2"));
        CR_Cname2.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Cname2"));
        CR_CcreditHrs2.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("CcreditHrs2"));
        CR_Ccode3.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Ccode3"));
        CR_Cname3.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Cname3"));
        CR_CcreditHrs3.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("CcreditHrs3"));
        CR_Ccode4.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Ccode4"));
        CR_Cname4.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Cname4"));
        CR_CcreditHrs4.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("CcreditHrs4"));
        CR_Ccode5.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Ccode5"));
        CR_Cname5.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Cname5"));
        CR_CcreditHrs5.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("CcreditHrs5"));
        CR_Ccode6.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Ccode6"));
        CR_Cname6.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Cname6"));
        CR_CcreditHrs6.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("CcreditHrs6"));
        CR_Ccode7.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Ccode7"));
        CR_Cname7.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Cname7"));
        CR_CcreditHrs7.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Ccredithrs7"));
        
        int i = 1;
        pst = null;
        rs = null;
        String T_query = "select * from Course_Registered";
        try {
            pst = conn.prepareStatement(T_query);
            rs = pst.executeQuery();
            while (rs.next()) {
                CR_data.add(new CourseRegistered(i++,
                        rs.getString("Reg_No"),
                        rs.getString("Name"),
                        rs.getString("Session"),
                        rs.getString("Semester"),
                        rs.getString("Batch_Year"),
                        rs.getString("Degree_Prog"),
                        rs.getString("Date"),
                        rs.getString("Contact"),
                        rs.getString("Father_Contact"),
                        rs.getString("Current_Address"),
                        rs.getString("Course1_Code"),
                        rs.getString("Course1_Name"),
                        rs.getString("Course1_CreditHrs"),
                        rs.getString("Course2_Code"),
                        rs.getString("Course2_Name"),
                        rs.getString("Course2_CreditHrs"),
                        rs.getString("Course3_Code"),
                        rs.getString("Course3_Name"),
                        rs.getString("Course3_CreditHrs"),
                        rs.getString("Course4_Code"),
                        rs.getString("Course4_Name"),
                        rs.getString("Course4_CreditHrs"),
                        rs.getString("Course5_Code"),
                        rs.getString("Course5_Name"),
                        rs.getString("Course5_CreditHrs"),
                        rs.getString("Course6_Code"),
                        rs.getString("Course6_Name"),
                        rs.getString("Course6_CreditHrs"),
                        rs.getString("Course7_Code"),
                        rs.getString("Course7_Name"),
                        rs.getString("Course7_CreditHrs")
                ));
                CR_tableView.setItems(CR_data);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
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
