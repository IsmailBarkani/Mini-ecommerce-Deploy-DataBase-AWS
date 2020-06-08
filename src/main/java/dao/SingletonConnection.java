package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {

    private static Connection myConnection;


    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");// pour charger le driver JDBC
            //String url = "jdbc:mysql://" + System.getenv("DB_URL") + ":3306/mydb";
            //String username = System.getenv("DB_USERNAME");
            //String password = System.getenv("DB_PASSWORD");
            myConnection = DriverManager.getConnection("jdbc:mysql://terraform-20200607120446622500000002.cna5xi486vmk.eu-west-3.rds.amazonaws.com:3306/db_catal","root","rootroot");

        }catch(ClassNotFoundException | SQLException e){             
            e.printStackTrace();
        }
    }

    public Connection getMyConnection(){
        return myConnection;
    }
}
