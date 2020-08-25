
package database;

import java.awt.HeadlessException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;

public class sql_connect {
    Connection conn = null;
    public static Connection ConnectcrDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/user/Desktop/Projects NB/Data Base/UMS_DataBase.db");
            //JOptionPane.showMessageDialog(null, "Successful");
            return conn;
        }catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
