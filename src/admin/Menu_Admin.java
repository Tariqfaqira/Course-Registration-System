package admin;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import course.CourseRegistered;
import course.Courses;
import student.Student;
import teacher.Teacher;
import database.sql_connect;

public class Menu_Admin implements Initializable {

    Connection conn = sql_connect.ConnectcrDB();
    PreparedStatement pst;
    ResultSet rs;
    @FXML
    private AnchorPane admin_anchorPane;

    @FXML
    private TextField T_searchTxt;
    @FXML
    private TextField T_deleteTxt;
    @FXML
    private TableView<Teacher> T_tableView;
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

    @FXML
    private TextField S_search;
    @FXML
    private TextField S_delete;
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
    private TableColumn<Student, String> S_cnic;
    @FXML
    private TableColumn<Student, String> S_gender;
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

    @FXML
    private TextField C_search;
    @FXML
    private TextField C_Delete;
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

    @FXML
    private TextField CR_search;
    @FXML
    private TextField CR_delete;
    @FXML
    private TableView<CourseRegistered> R_tableView;
    @FXML
    private TableColumn<CourseRegistered, Integer> R_sNo;
    @FXML
    private TableColumn<CourseRegistered, String> R_regNo;
    @FXML
    private TableColumn<CourseRegistered, String> R_name;
    @FXML
    private TableColumn<CourseRegistered, String> R_session;
    @FXML
    private TableColumn<CourseRegistered, String> R_semester;
    @FXML
    private TableColumn<CourseRegistered, String> R_batch;
    @FXML
    private TableColumn<CourseRegistered, String> R_degreeProg;
    @FXML
    private TableColumn<CourseRegistered, String> R_date;
    @FXML
    private TableColumn<CourseRegistered, String> R_contact;
    @FXML
    private TableColumn<CourseRegistered, String> R_father_contact;
    @FXML
    private TableColumn<CourseRegistered, String> R_cur_address;
    @FXML
    private TableColumn<CourseRegistered, String> R_Ccode1;
    @FXML
    private TableColumn<CourseRegistered, String> R_Cname1;
    @FXML
    private TableColumn<CourseRegistered, String> R_CcreditHrs1;
    @FXML
    private TableColumn<CourseRegistered, String> R_Ccode2;
    @FXML
    private TableColumn<CourseRegistered, String> R_Cname2;
    @FXML
    private TableColumn<CourseRegistered, String> R_CcreditHrs2;
    @FXML
    private TableColumn<CourseRegistered, String> R_Ccode3;
    @FXML
    private TableColumn<CourseRegistered, String> R_Cname3;
    @FXML
    private TableColumn<CourseRegistered, String> R_CcreditHrs3;
    @FXML
    private TableColumn<CourseRegistered, String> R_Ccode4;
    @FXML
    private TableColumn<CourseRegistered, String> R_Cname4;
    @FXML
    private TableColumn<CourseRegistered, String> R_CcreditHrs4;
    @FXML
    private TableColumn<CourseRegistered, String> R_Ccode5;
    @FXML
    private TableColumn<CourseRegistered, String> R_Cname5;
    @FXML
    private TableColumn<CourseRegistered, String> R_CcreditHrs5;
    @FXML
    private TableColumn<CourseRegistered, String> R_Ccode6;
    @FXML
    private TableColumn<CourseRegistered, String> R_Cname6;
    @FXML
    private TableColumn<CourseRegistered, String> R_CcreditHrs6;
    @FXML
    private TableColumn<CourseRegistered, String> R_Ccode7;
    @FXML
    private TableColumn<CourseRegistered, String> R_Cname7;
    @FXML
    private TableColumn<CourseRegistered, String> R_CcreditHrs7;
    ///////
    int i; //Used for counter.
    String str = " "; //Used to store value returened by DB, for check purpose..
    @FXML
    private TextField CR_Smstr_delete;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTeacherData();
        loadStudentdata();
        loadCoursesdata();
        loadCourseRegistereddate();
    }

    public void loadTeacherData() {
        ObservableList<Teacher> T_data = FXCollections.observableArrayList();

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

        i = 1;
        pst = null;
        rs = null;
        String T_query = "select * from Teacher";
        try {
            pst = conn.prepareStatement(T_query);
            rs = pst.executeQuery();
            while (rs.next()) {
                T_data.add(new Teacher(i++,
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
                T_tableView.setItems(T_data);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    //Event handler for Admin to delete data from database:
    @FXML
    private void handle_T_DeleteTxt_EnterePressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            teacher_delete();
        }
    }

    @FXML
    private void T_delete(ActionEvent event) {
        teacher_delete();
    }

    private void teacher_delete() {
        pst = null;
        try {
            String sql = "DELETE FROM Teacher WHERE ID = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, T_deleteTxt.getText());
            pst.execute();

            loadTeacherData();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Teacher deletion failed.");
            alert.showAndWait();
        }
    }

    //Event handler for Admin to search data from database:
    @FXML
    private void handle_T_searchTxt_EnterPressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            teacher_search_method();
        }
    }

    @FXML
    private void T_searchBtn(ActionEvent event) {
        teacher_search_method();
    }

    private void teacher_search_method() {
        ObservableList<Teacher> T_data = FXCollections.observableArrayList();
        String query = "select * from Teacher where ID = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, T_searchTxt.getText());
            rs = pst.executeQuery();
            i = 1;
            while (rs.next()) {
                T_data.add(new Teacher(i++,
                        str = rs.getString("ID"),
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
                T_tableView.setItems(T_data);
            }
            pst.close();
            rs.close();
            if (str.equals(" ")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Teacher ID not found.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Not found." + e);
        }
    }

    @FXML
    private void T_goBackToList(ActionEvent event) {
        loadTeacherData();
    }
    // End of the Teacher data.
////////////////////////////////////////////////////////////////////////
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//  Student Data

    private void loadStudentdata() {
        ObservableList<Student> S_data = FXCollections.observableArrayList();

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

        i = 1;
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
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    ///////////////////////   Student Delete, Events and functions   ////////////////////////////////
    @FXML
    private void handle_S_delete_EnterPressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            student_delete();
        }
    }

    @FXML
    private void S_delete(ActionEvent event) {
        student_delete();
    }

    private void student_delete() {
        pst = null;
        try {
            String sql = "DELETE FROM Student WHERE Reg_No = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, S_delete.getText());
            pst.execute();

            loadStudentdata();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Student deletion failed.");
            alert.showAndWait();
        }
    }

    ///////////////////////   Student Search, Events and functions   ////////////////////////////////
    @FXML
    private void S_search(ActionEvent event) {
        student_search_method();
    }

    @FXML
    private void handle_S_searchEnterPressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            student_search_method();
        }
    }

    private void student_search_method() {
        ObservableList<Student> S_data = FXCollections.observableArrayList();
        String query = "select * from Student where Reg_No = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, S_search.getText());
            rs = pst.executeQuery();
            i = 1;
            while (rs.next()) {
                S_data.add(new Student(i++,
                        str = rs.getString("Reg_No"),
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
            if (str.equals(" ")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Student not found.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Not found." + e);
        }
    }

    @FXML
    private void S_goBackToList(ActionEvent event) {
        loadStudentdata();
    }

    //
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//  Course Data
    public void loadCoursesdata() {
        ObservableList<Courses> C_data = FXCollections.observableArrayList();
        C_sNo.setCellValueFactory(new PropertyValueFactory<Courses, Integer>("sNo"));
        C_code.setCellValueFactory(new PropertyValueFactory<Courses, String>("code"));
        C_name.setCellValueFactory(new PropertyValueFactory<Courses, String>("name"));
        C_creditHrs.setCellValueFactory(new PropertyValueFactory<Courses, String>("creditHrs"));

        i = 1;
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
    ///////////////////////   Course Delete, Events and functions   ////////////////////////////////

    @FXML
    private void handle_C_delete_EnterPressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            courses_delete();
        }
    }

    @FXML
    private void C_delete(ActionEvent event) {
        courses_delete();
    }

    private void courses_delete() {
        pst = null;
        try {
            String sql = "DELETE FROM Courses WHERE Course_Code = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, C_Delete.getText());
            pst.execute();

            loadCoursesdata();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Course deletion failed");
            alert.showAndWait();
        }

    }

    ///////////////////////   Courses Search, Events and functions   ////////////////////////////////
    @FXML
    private void handle_C_search_EnterPressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            course_search_method();
        }
    }

    @FXML
    private void C_search(ActionEvent event) {
        course_search_method();
    }

    private void course_search_method() {
        ObservableList<Courses> C_data = FXCollections.observableArrayList();
        String query = "select * from Courses where Course_Code = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, C_search.getText());
            rs = pst.executeQuery();

            while (rs.next()) {
                C_data.add(new Courses(i++,
                        str = rs.getString("Course_Code"),
                        rs.getString("Course_Name"),
                        rs.getString("Course_CreditHrs")
                ));
                C_tableView.setItems(C_data);
            }
            pst.close();
            rs.close();
            if (str.equals(" ")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Course not found.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Not found." + e);
        }
    }

    @FXML
    private void C_goBackToList(ActionEvent event) {
        loadCoursesdata();
    }

    ////
    /////
    ////////
/////
    ////////
    /////////
    //////
///////
    private void loadCourseRegistereddate() {
        ObservableList<CourseRegistered> R_data = FXCollections.observableArrayList();

        R_sNo.setCellValueFactory(new PropertyValueFactory<CourseRegistered, Integer>("sNo"));
        R_regNo.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("regNo"));
        R_name.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("name"));
        R_session.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("session"));
        R_semester.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("semester"));
        R_batch.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("batch"));
        R_degreeProg.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("degreeProg"));
        R_date.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("date"));
        R_contact.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("contact"));
        R_father_contact.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("father_contact"));
        R_cur_address.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("cur_address"));
        R_Ccode1.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Ccode1"));
        R_Cname1.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Cname1"));
        R_CcreditHrs1.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("CcreditHrs1"));
        R_Ccode2.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Ccode2"));
        R_Cname2.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Cname2"));
        R_CcreditHrs2.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("CcreditHrs2"));
        R_Ccode3.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Ccode3"));
        R_Cname3.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Cname3"));
        R_CcreditHrs3.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("CcreditHrs3"));
        R_Ccode4.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Ccode4"));
        R_Cname4.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Cname4"));
        R_CcreditHrs4.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("CcreditHrs4"));
        R_Ccode5.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Ccode5"));
        R_Cname5.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Cname5"));
        R_CcreditHrs5.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("CcreditHrs5"));
        R_Ccode6.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Ccode6"));
        R_Cname6.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Cname6"));
        R_CcreditHrs6.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("CcreditHrs6"));
        R_Ccode7.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Ccode7"));
        R_Cname7.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Cname7"));
        R_CcreditHrs7.setCellValueFactory(new PropertyValueFactory<CourseRegistered, String>("Ccredithrs7"));

        i = 1;
        pst = null;
        rs = null;
        String T_query = "select * from Course_Registered";
        try {
            pst = conn.prepareStatement(T_query);
            rs = pst.executeQuery();
            while (rs.next()) {
                R_data.add(new CourseRegistered(i++,
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
                R_tableView.setItems(R_data);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    ///////////////////////   Course registered Delete, Events and functions   ////////////////////////////////
    @FXML
    private void handle_CR_delete_EnterPressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            coursesRegistered_delete();
        }
    }

    @FXML
    private void CR_delete(ActionEvent event) {
        coursesRegistered_delete();
    }

    private void coursesRegistered_delete() {
        pst = null;
        try {
            String sql = "DELETE FROM Course_Registered WHERE Reg_No = ? and Semester = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, CR_delete.getText());
            pst.setString(2, CR_Smstr_delete.getText());
            pst.execute();
            i = 1;
            loadCourseRegistereddate();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Successfuly deleted.");
            alert.showAndWait();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Data deletion failed." + e);
            alert.showAndWait();
        }
    }

    ///////////////////////   Course registered Search, Events and functions   ////////////////////////////////
    @FXML
    private void handle_CR_search_EnterPressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            courseRegister_search_method();
        }
    }

    @FXML
    private void CR_search(ActionEvent event) {
        courseRegister_search_method();
    }

    private void courseRegister_search_method() {
        ObservableList<CourseRegistered> R_data = FXCollections.observableArrayList();
        String query = "select * from Course_Registered where Reg_No = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, CR_search.getText());
            rs = pst.executeQuery();
            i = 1;
            while (rs.next()) {
                R_data.add(new CourseRegistered(i++,
                        str = rs.getString("Reg_No"),
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
                R_tableView.setItems(R_data);
            }
            pst.close();
            rs.close();
            if (str == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Reg number not found.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Not found." + e);
        }
    }

    @FXML
    private void CR_goBackToList(ActionEvent event) {
        loadCourseRegistereddate();
    }

}
/*
    void chang_scene_method(String FXML_Name) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(FXML_Name));
            admin_anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
 */
