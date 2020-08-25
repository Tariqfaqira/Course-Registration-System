package report;

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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import course.Course_CurSemester;
import database.sql_connect;

public class Menu_Report_CurrentSemester implements Initializable {

    Connection conn = sql_connect.ConnectcrDB();
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    private ListView<String> listView;
    @FXML
    private ListView<String> Student_list_1;
    @FXML
    private ListView<String> Student_list_2;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField searchTxt;
    @FXML
    private TableView<Course_CurSemester> tableView;
    @FXML
    private TableColumn<Course_CurSemester, Integer> C_sNo;
    @FXML
    private TableColumn<Course_CurSemester, String> C_code;
    @FXML
    private TableColumn<Course_CurSemester, String> C_name;
    @FXML
    private TableColumn<Course_CurSemester, String> C_creditHrs;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        allReg__listView_load_method();
        C_sNo.setCellValueFactory(new PropertyValueFactory<Course_CurSemester, Integer>("sNo"));
        C_code.setCellValueFactory(new PropertyValueFactory<Course_CurSemester, String>("code"));
        C_name.setCellValueFactory(new PropertyValueFactory<Course_CurSemester, String>("name"));
        C_creditHrs.setCellValueFactory(new PropertyValueFactory<Course_CurSemester, String>("creditHrs"));
    }

    private void allReg__listView_load_method() {
        ObservableList<String> items = FXCollections.observableArrayList();
        String R_query = "select Reg_No from Student";

        try {
            pst = conn.prepareStatement(R_query);
            rs = pst.executeQuery();
            while (rs.next()) {
                items.add(rs.getString("Reg_No"));

                listView.setItems(items);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    @FXML
    private void handle_onmouseClicked_lReg_istView(MouseEvent event) {
        ObservableList<String> items1 = FXCollections.observableArrayList();
        ObservableList<String> items2 = FXCollections.observableArrayList();
        ObservableList<Course_CurSemester> tabel_Data = FXCollections.observableArrayList();

        String query = "select Semester from Course_Registered where ReG_No = ?";
        int s = 1;
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, listView.getSelectionModel().getSelectedItem());
            rs = pst.executeQuery();
            while (rs.next()) {
                int s1 = Integer.parseInt(rs.getString("Semester"));
                if (s < s1) {
                    s = s1;
                }
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

        String R_query = "select * from Course_Registered where ReG_No = ? and Semester = ?";
        int j = 1;
        try {
            pst = conn.prepareStatement(R_query);
            pst.setString(1, listView.getSelectionModel().getSelectedItem());
            pst.setString(2, "" + s);
            rs = pst.executeQuery();
            while (rs.next()) {
                items1.addAll(
                        rs.getString("Reg_No"),
                        rs.getString("Name"),
                        rs.getString("Contact"),
                        rs.getString("Father_Contact"),
                        rs.getString("Current_Address"));
                Student_list_1.setItems(items1);

                items2.addAll(
                        rs.getString("Degree_Prog"),
                        rs.getString("Batch_Year"),
                        rs.getString("Session"),
                        rs.getString("Semester"),
                        rs.getString("Date"));
                Student_list_2.setItems(items2);

                for (int i = 1; i < 8; i++) {
                    tabel_Data.add(new Course_CurSemester(1, rs.getString("Course" + i + "_Code"),
                            rs.getString("Course" + i + "_Name"),
                            rs.getString("Course" + i + "_CreditHrs")));
                    tableView.setItems(tabel_Data);
                }
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    @FXML
    private void handle_EnterPressed_SearchTxt(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            searchReg__listView_method();
        }
    }

    @FXML
    private void handle_search(ActionEvent event) {
        searchReg__listView_method();

    }

    private void searchReg__listView_method() {
        ObservableList<String> items = FXCollections.observableArrayList();
        String R_query = "select Reg_No from Student where Reg_No = ?";
        String str = "";
        try {
            pst = conn.prepareStatement(R_query);
            pst.setString(1, searchTxt.getText());
            rs = pst.executeQuery();
            while (rs.next()) {
                items.add(str = rs.getString("Reg_No"));
                listView.setItems(items);
            }
            if ((str == null) || str.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Student not found.");
                alert.showAndWait();

                chang_scene_method("Menu_Report_CurrentSemester.fxml");
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    @FXML
    private void handle_StudentInfo(ActionEvent event) {
        chang_scene_method("Menu_Report_Student.fxml");
    }

    @FXML
    private void handle_coursePermitionForm(ActionEvent event) {
        chang_scene_method("Menu_Report_CoursePermitionForm.fxml");
    }

    @FXML
    private void handle_ShowGrades(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Sorry no grade is assign to any one");
    }

    @FXML
    private void handle_CurrentSemester(ActionEvent event) {
        chang_scene_method("Menu_Report_CurrentSemester.fxml");
    }

    @FXML
    private void handle_Print(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Printer is not connected. Please conect printer first.");
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

    @FXML
    private void handle_KeyPressed(KeyEvent event) {
    }
}
