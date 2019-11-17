package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {

    private static Connection myConnection;


    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");// pour charger le driver JDBC
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_catal","root","");
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getMyConnection(){
        return myConnection;
    }
}
