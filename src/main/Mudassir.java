package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Mudassir extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/login/Login_Page.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("/report/Menu_Report_Student.fxml"));

        stage.setTitle("Student Joining & Course Registration");
        Scene scene = new Scene(root);
        stage.setScene(scene);
//        stage.initStyle(StageStyle.TRANSPARENT);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
