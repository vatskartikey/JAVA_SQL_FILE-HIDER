package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Myconnection {

    public static Connection connection=null;
    public static Connection getConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FileHider?useSSL=false","root","kartikey");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        System.out.println("Well! Connection is done");
        return connection;
    }
    public static void closeConnection(){
        if(connection !=null) {
            try {
                connection.close();
            } catch( SQLException e) {
                e.printStackTrace();
            }
            }
        }


}
