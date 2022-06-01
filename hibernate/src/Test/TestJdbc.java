package Test;


import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/Guna?useSSL=false";

        String user="root";
        String pass="Guna@5444";

        try{

            System.out.println("Connection to database:" + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);

            System.out.println("Connection successful");

        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }
}

