package daos;


import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


class Connections {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static final String USER = "root";
    private static final String PASS = "password";




    public static Connection getConnection(){
        try{
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException exception) {
            throw new RuntimeException("Error connecting", exception);
        }
    }

    public static void closeConnection(){

    }



    public static void main(String[] args){
        Connection connection = getConnection();
    }


}
