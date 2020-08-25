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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import database.sql_connect;

public class Menu_Report_Student implements Initializable {

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

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = sql_connect.ConnectcrDB();
        allReg__listView_method();
    }

    private void allReg__listView_method() {
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

    // Search Methods
    @FXML
    private void handle_search(ActionEvent event) {
        searchReg__listView_method();
    }

    @FXML
    private void handle_EnterPressed_SearchTxt(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            searchReg__listView_method();
        }
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

                chang_scene_method("Menu_Report_Student.fxml");
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    // Handle List view clicked.
    @FXML
    private void handle_onmouseClicked_lReg_istView(MouseEvent event) {
        method((listView.getSelectionModel().getSelectedIndex()));
    }

    @FXML
    private void handle_Keys(KeyEvent event) {
        if (event.getCode().equals(KeyCode.DOWN)) {
            method((listView.getSelectionModel().getSelectedIndex() + 1));
        }
        if (event.getCode().equals(KeyCode.UP)) {
            method((listView.getSelectionModel().getSelectedIndex() - 1));
        }
    }

    private void method(int index) {
        ObservableList<String> items1 = FXCollections.observableArrayList();
        ObservableList<String> items2 = FXCollections.observableArrayList();
        String R_query = "select * from Student where ReG_No = ?";
        try {
            pst = conn.prepareStatement(R_query);
            pst.setString(1, listView.getItems().get(index));
            rs = pst.executeQuery();
            while (rs.next()) {
                items1.addAll(
                        rs.getString("Reg_No"),
                        rs.getString("Name"),
                        rs.getString("Father_Name"),
                        rs.getString("DOB"),
                        rs.getString("Gender"),
                        rs.getString("CNIC"),
                        rs.getString("Contact"),
                        rs.getString("Father_contact"),
                        rs.getString("Email"),
                        rs.getString("Domicile"),
                        rs.getString("Current_Address"),
                        rs.getString("Permanent_Address"));
                items2.addAll(
                        rs.getString("Degree_Prog"),
                        rs.getString("Session"),
                        rs.getString("Degree_Year"),
                        rs.getString("Date"));

                Student_list_1.setItems(items1);
                Student_list_2.setItems(items2);
            }

            pst.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    @FXML
    private void handle_StudentInfo(ActionEvent event) {

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
}
