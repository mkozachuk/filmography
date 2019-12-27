package mkozachuk.filmography;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306";
        String username = "root";
        String pass = "***";
        System.out.println("Connecting...");

        try(Connection connection = DriverManager.getConnection(url,username,pass)){
            System.out.println("Connection SUCCESSFUL!");
        }catch (SQLException e){
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
