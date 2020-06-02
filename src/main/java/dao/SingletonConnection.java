package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {

    private static Connection myConnection;


    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");// pour charger le driver JDBC
            String url = "jdbc:mysql://" + System.getenv("DB_URL") + ":" + System.getenv("DB_PORT") + "/db_catal";
            String username = System.getenv("DB_USERNAME");
            String password = System.getenv("DB_PASSWORD");
            myConnection = DriverManager.getConnection(url,username,password);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getMyConnection(){
        return myConnection;
    }
}
