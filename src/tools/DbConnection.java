package tools;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
  private Connection connection;
  private String dbURL = "jdbc:mysql://localhost:3306/db_hr";

  public Connection getConnection(){
      try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection(dbURL, "root", "Mysql29!");
      }
      catch(Exception e){
        System.out.println("Error " + e.getMessage());
      }

    return connection;
  }
  
}
