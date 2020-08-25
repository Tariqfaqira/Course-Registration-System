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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;
import course.Course_CurSemester;
import database.sql_connect;

public class Menu_Report_CoursePermitionForm implements Initializable {

    Connection conn = sql_connect.ConnectcrDB();
    PreparedStatement pst = null;
    ResultSet rs = null;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField searchTxt;
    @FXML
    private ListView<String> listView;

    // Current Semester:
    @FXML
    private TableView<Course_CurSemester> C_tableView;

    @FXML
    private TableColumn<Course_CurSemester, String> C_code;
    @FXML
    private TableColumn<Course_CurSemester, String> C_name;
    @FXML
    private TableColumn<Course_CurSemester, String> C_creditHrs;

    // Previous Semesters record:
    @FXML
    private TableView<Course_CurSemester> tableView1;

    @FXML
    private TableColumn<Course_CurSemester, String> code1;
    @FXML
    private TableColumn<Course_CurSemester, String> name1;
    @FXML
    private TableColumn<Course_CurSemester, String> creditHrs1;
    @FXML
    private Label gpa1;
    @FXML
    private Label cgpa1;
    @FXML
    private Label cr_attempt1;
    @FXML
    private Label cr_passed1;
    @FXML
    private VBox vbox;
    @FXML
    private TableView<Course_CurSemester> tableView11;
    @FXML
    private TableColumn<Course_CurSemester, String> code11;
    @FXML
    private TableColumn<Course_CurSemester, String> name11;
    @FXML
    private TableColumn<Course_CurSemester, String> creditHrs11;
    @FXML
    private Label gpa2;
    @FXML
    private Label cgpa2;
    @FXML
    private Label cr_attempt2;
    @FXML
    private Label cr_passed2;
    @FXML
    private TableView<Course_CurSemester> tableView111;
    @FXML
    private TableColumn<Course_CurSemester, String> code111;
    @FXML
    private TableColumn<Course_CurSemester, String> name111;
    @FXML
    private TableColumn<Course_CurSemester, String> creditHrs111;
    @FXML
    private Label gpa21;
    @FXML
    private Label cgpa21;
    @FXML
    private Label cr_attempt21;
    @FXML
    private Label cr_passed21;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        allReg__listView_load_method();
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
            JOptionPane.showMessageDialog(null, "Error in load all regNo: " + e);
        }
    }

    @FXML
    private void handle_onmouseClicked_lReg_istView(MouseEvent event) {
        load_previousSemesters_data1();
        load_currentSemesterCourses();
    }
    int i = 1;

    // Load Current se,esters data into table view:
    private void load_currentSemesterCourses() {
        C_code.setCellValueFactory(new PropertyValueFactory<Course_CurSemester, String>("code"));
        C_name.setCellValueFactory(new PropertyValueFactory<Course_CurSemester, String>("name"));
        C_creditHrs.setCellValueFactory(new PropertyValueFactory<Course_CurSemester, String>("creditHrs"));

        ObservableList<Course_CurSemester> data = FXCollections.observableArrayList();
        String R_query = "select * from Course_Registered where ReG_No = ? and Semester = ?";
        try {
            pst = conn.prepareStatement(R_query);
            pst.setString(1, listView.getSelectionModel().getSelectedItem());
            pst.setString(2, "" + i);
            rs = pst.executeQuery();
            while (rs.next()) {
                for (int i = 1; i < 8; i++) {
                    data.add(new Course_CurSemester(1, rs.getString("Course" + i + "_Code"),
                            rs.getString("Course" + i + "_Name"),
                            rs.getString("Course" + i + "_CreditHrs")));
                    C_tableView.setItems(data);
                }
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in load current semester courses: " + e);
        }
    }
    int count = 0;
    int cr_attempt = 0;
    int cr_passed = 0;

    double gpa = 0.0;
    double cgpa = 0.0;

    // Load Previous se,esters data into table view:
    private void load_previousSemesters_data1() {
        code1.setCellValueFactory(new PropertyValueFactory<Course_CurSemester, String>("code"));
        name1.setCellValueFactory(new PropertyValueFactory<Course_CurSemester, String>("name"));
        creditHrs1.setCellValueFactory(new PropertyValueFactory<Course_CurSemester, String>("creditHrs"));

        code11.setCellValueFactory(new PropertyValueFactory<Course_CurSemester, String>("code"));
        name11.setCellValueFactory(new PropertyValueFactory<Course_CurSemester, String>("name"));
        creditHrs11.setCellValueFactory(new PropertyValueFactory<Course_CurSemester, String>("creditHrs"));

        code111.setCellValueFactory(new PropertyValueFactory<Course_CurSemester, String>("code"));
        name111.setCellValueFactory(new PropertyValueFactory<Course_CurSemester, String>("name"));
        creditHrs111.setCellValueFactory(new PropertyValueFactory<Course_CurSemester, String>("creditHrs"));

        count++;
        ObservableList<Course_CurSemester> data = FXCollections.observableArrayList();
        String R_query = "select * from Course_Registered where ReG_No = ? and Semester = ?";
        String str = "";
        try {
            pst = conn.prepareStatement(R_query);
            for (int j = 0; j < 8; j++) {
                pst.setString(1, listView.getSelectionModel().getSelectedItem());
                pst.setString(2, "" + j);
                rs = pst.executeQuery();

                while (rs.next()) {
                    str = rs.getString("Semester");
                    data.add(new Course_CurSemester(1, (rs.getString("Course1_Code")),
                            rs.getString("Course1_Name"),
                            rs.getString("Course1_Grade")));
                    String cr1 = rs.getString("Course1_CreditHrs");
                    data.add(new Course_CurSemester(1, rs.getString("Course2_Code"),
                            rs.getString("Course2_Name"),
                            rs.getString("Course2_Grade")));
                    data.add(new Course_CurSemester(1, rs.getString("Course3_Code"),
                            rs.getString("Course3_Name"),
                            rs.getString("Course3_Grade")));
                    data.add(new Course_CurSemester(1, rs.getString("Course4_Code"),
                            rs.getString("Course4_Name"),
                            rs.getString("Course4_Grade")));
                    data.add(new Course_CurSemester(1, rs.getString("Course5_Code"),
                            rs.getString("Course5_Name"),
                            rs.getString("Course5_Grade")));
                    data.add(new Course_CurSemester(1, rs.getString("Course6_Code"),
                            rs.getString("Course6_Name"),
                            rs.getString("Course6_Grade")));
                    data.add(new Course_CurSemester(1, rs.getString("Course7_Code"),
                            rs.getString("Course7_Name"),
                            rs.getString("Course7_Grade")));
                    switch (j) {
                        case 0:
                            tableView1.setItems(data);
                            break;
                        case 1:
                            tableView11.setItems(data);
                            break;
                        case 2:
                            tableView11.setItems(data);
                            break;
                        default:
                            break;
                    }
                    if (str != null && !str.isEmpty()) {
                        if ((Integer.parseInt(str)) >= i) {
                            i = Integer.parseInt(str);
                        }
                    }
                }
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in load previous smester's data: " + e);

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
            JOptionPane.showMessageDialog(null, "Error in search: " + e);
        }
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

    @FXML
    private void handle_StudentInfo(ActionEvent event) {
        chang_scene_method("Menu_Report_Student.fxml");
    }

    @FXML
    private void handle_coursePermitionForm(ActionEvent event) {
        chang_scene_method("Menu_Report_CoursePermitionForm.fxl");
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
