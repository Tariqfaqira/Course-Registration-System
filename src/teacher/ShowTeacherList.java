package teacher;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import database.sql_connect;

public class ShowTeacherList implements Initializable {

    Connection conn = sql_connect.ConnectcrDB();
    PreparedStatement pst;
    ResultSet rs;
    ObservableList<Teacher> data = FXCollections.observableArrayList();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableView<Teacher> tableView;
    @FXML
    private TableColumn<Teacher, Integer> T_sNo;
    @FXML
    private TableColumn<Teacher, String> T_id;
    @FXML
    private TableColumn<Teacher, String> T_name;
    @FXML
    private TableColumn<Teacher, String> T_father;
    @FXML
    private TableColumn<Teacher, String> T_gender;
    @FXML
    private TableColumn<Teacher, String> T_age;
    @FXML
    private TableColumn<Teacher, String> T_cnic;
    @FXML
    private TableColumn<Teacher, String> T_bachlar;
    @FXML
    private TableColumn<Teacher, String> T_master;
    @FXML
    private TableColumn<Teacher, String> T_phd;
    @FXML
    private TableColumn<Teacher, String> T_extra_qualfication1;
    @FXML
    private TableColumn<Teacher, String> T_extra_qualfication2;
    @FXML
    private TableColumn<Teacher, String> T_teaching_sub1;
    @FXML
    private TableColumn<Teacher, String> T_teaching_sub2;
    @FXML
    private TableColumn<Teacher, String> T_teaching_sub3;
    @FXML
    private TableColumn<Teacher, String> T_teaching_sub4;
    @FXML
    private TableColumn<Teacher, String> T_teaching_sub5;
    @FXML
    private TableColumn<Teacher, String> T_date;
    @FXML
    private TableColumn<Teacher, String> T_contact;
    @FXML
    private TableColumn<Teacher, String> T_cur_addresss;
    @FXML
    private TableColumn<Teacher, String> T_per_address;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        T_sNo.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("sNo"));
        T_id.setCellValueFactory(new PropertyValueFactory<Teacher, String>("id"));
        T_name.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
        T_father.setCellValueFactory(new PropertyValueFactory<Teacher, String>("father"));
        T_gender.setCellValueFactory(new PropertyValueFactory<Teacher, String>("gender"));
        T_age.setCellValueFactory(new PropertyValueFactory<Teacher, String>("age"));
        T_cnic.setCellValueFactory(new PropertyValueFactory<Teacher, String>("cnic"));
        T_bachlar.setCellValueFactory(new PropertyValueFactory<Teacher, String>("bachlar"));
        T_master.setCellValueFactory(new PropertyValueFactory<Teacher, String>("master"));
        T_phd.setCellValueFactory(new PropertyValueFactory<Teacher, String>("phd"));
        T_extra_qualfication1.setCellValueFactory(new PropertyValueFactory<Teacher, String>("extra_qualification1"));
        T_extra_qualfication2.setCellValueFactory(new PropertyValueFactory<Teacher, String>("extra_qualification2"));
        T_teaching_sub1.setCellValueFactory(new PropertyValueFactory<Teacher, String>("teaching_sub1"));
        T_teaching_sub2.setCellValueFactory(new PropertyValueFactory<Teacher, String>("teaching_sub2"));
        T_teaching_sub3.setCellValueFactory(new PropertyValueFactory<Teacher, String>("teaching_sub3"));
        T_teaching_sub4.setCellValueFactory(new PropertyValueFactory<Teacher, String>("teaching_sub4"));
        T_teaching_sub5.setCellValueFactory(new PropertyValueFactory<Teacher, String>("teaching_sub5"));
        T_date.setCellValueFactory(new PropertyValueFactory<Teacher, String>("date"));
        T_contact.setCellValueFactory(new PropertyValueFactory<Teacher, String>("contact"));
        T_cur_addresss.setCellValueFactory(new PropertyValueFactory<Teacher, String>("cAddress"));
        T_per_address.setCellValueFactory(new PropertyValueFactory<Teacher, String>("pAddress"));

        int i = 1;
        pst = null;
        rs = null;
        String T_query = "select * from Teacher";
        try {
            pst = conn.prepareStatement(T_query);
            rs = pst.executeQuery();
            while (rs.next()) {
                data.add(new Teacher(i++,
                        rs.getString("ID"),
                        rs.getString("Name"),
                        rs.getString("Father_Name"),
                        rs.getString("Gender"),
                        rs.getString("Age"),
                        rs.getString("CNIC_Number"),
                        rs.getString("Bachlar_Degree"),
                        rs.getString("Master_Degree"),
                        rs.getString("PHD_Degree"),
                        rs.getString("Extra_Qualification_1"),
                        rs.getString("Extra_Qualification_2"),
                        rs.getString("Teaching_Subject_1"),
                        rs.getString("Teaching_Subject_2"),
                        rs.getString("Teaching_Subject_3"),
                        rs.getString("Teaching_Subject_4"),
                        rs.getString("Teaching_Subject_5"),
                        rs.getString("Date"),
                        rs.getString("Contact_Number"),
                        rs.getString("Current_Address"),
                        rs.getString("Permanent_Address")
                ));
                tableView.setItems(data);
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
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Menu_Teacher.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
}
