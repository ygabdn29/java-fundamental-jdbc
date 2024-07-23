import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.RegionInterface;
import dao.implementation.RegionDAO;
import models.Region;
import tools.DbConnection;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Test JDBC");

        DbConnection connection = new DbConnection();
        // System.out.println(connection.getConnection());

        // RegionDAO rdao = new RegionDAO(connection.getConnection());
        // for(Region region : rdao.getAll()){
        //     System.out.println(region.getRegionId());
        //     System.out.println(region.getRegionName());
        // }

        // RegionDAO rdao = new RegionDAO(connection.getConnection());
        // Region region = new Region(12, "Antartica");
        // System.out.println(rdao.insert(region));

        // RegionDAO rdao = new RegionDAO(connection.getConnection());
        // Region region = rdao.getById(14);
        // if(region != null){
        //     System.out.println(region.getRegionId() + " " +  region.getRegionName());
        // }
        // else{
        //     System.out.println("Not Found");
        // }
        // System.out.println(rdao.update(12, "Amerika"));
        // System.out.println(rdao.getData(12));

        // Region regionById = region.getData(10);
        // System.out.println(regionById.getId() + " "+ regionById.getName());
        // Region newRegion = new Region(20, "Amerika");
        // region.insert(newRegion);

        // region.delete(11);
        // Parameter untuk insert dan update menggunakan object saja agar bisa generic
        RegionInterface region = new RegionDAO(connection.getConnection());
        Region updateRegion = new Region(109, "SEA");
        System.out.println("Affected row: " + region.update(updateRegion));

        ///////////////////////////////////////
        // Statement sqlSt; // runs SQL
        // String useSql = new String("use db_asset_management");
        // String output;
        // ResultSet result; // holds the output from the SQL
        // String SQL = "SELECT * FROM countries";

        // try{
        //     Class.forName("com.mysql.cj.jdbc.Driver");
        //     String dbURL = "jdbc:mysql://localhost:3306/db_hr";
        //     Connection dbConnect = DriverManager.getConnection(dbURL, "root", "Mysql29!");

        //     sqlSt = dbConnect.createStatement(); // allows SQL to be executed
        //     result = sqlSt.executeQuery(SQL);
        //     // result holds the output from the SQL
        //     // might be harmful if the db is big enough
        //     while(result.next() != false){
        //         output = result.getString("country_name");
        //         System.out.println(output);
        //     }
        //     // if leave open is not safe
        //     sqlSt.close();
        // }
        // catch(ClassNotFoundException ex){
        //     Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        //     System.out.println("Class not found, check the JAR");
        // }
        // catch(SQLException ex){
        //     Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        //     System.out.println("SQL is BAD " + ex.getMessage());
        // }
    }
}
