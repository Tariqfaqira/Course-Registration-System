package course;

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

public class ShowCourses implements Initializable {

    Connection conn = sql_connect.ConnectcrDB();
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TableView<Courses> C_tableView;
    @FXML
    private TableColumn<Courses, Integer> C_sNo;
    @FXML
    private TableColumn<Courses, String> C_code;
    @FXML
    private TableColumn<Courses, String> C_name;
    @FXML
    private TableColumn<Courses, String> C_creditHrs;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        loadCoursesdata();
    }

    public void loadCoursesdata() {
        ObservableList<Courses> C_data = FXCollections.observableArrayList();
        C_sNo.setCellValueFactory(new PropertyValueFactory<Courses, Integer>("sNo"));
        C_code.setCellValueFactory(new PropertyValueFactory<Courses, String>("code"));
        C_name.setCellValueFactory(new PropertyValueFactory<Courses, String>("name"));
        C_creditHrs.setCellValueFactory(new PropertyValueFactory<Courses, String>("creditHrs"));

        int i = 1;
        pst = null;
        rs = null;
        String R_query = "select * from Courses";
        try {
            pst = conn.prepareStatement(R_query);
            rs = pst.executeQuery();
            while (rs.next()) {
                C_data.add(new Courses(i++,
                        rs.getString("Course_Code"),
                        rs.getString("Course_Name"),
                        rs.getString("Course_CreditHrs")
                ));
                C_tableView.setItems(C_data);
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
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Menu_Courses.fxml"));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
}
