package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Region;

public class RegionDAO {
  private Connection connection;

  public RegionDAO(Connection connection) {
    this.connection = connection;
  }

  public List<Region> getAll(){
    List<Region> regions = new ArrayList<Region>();
    String query = "SELECT * FROM regions";

    try{
      ResultSet result = connection.prepareStatement(query).executeQuery();

      while (result.next()){
        Region region = new Region(result.getInt("region_id"), result.getString("region_name"));
        regions.add(region);
      }

      result.close();
    }
    catch(SQLException e){
      System.out.println("BAD SQL: " + e.getMessage());
    }
    return regions;
  }

  public boolean insert(Region region){
    Integer count;

    try{
      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO regions(region_id, region_name) VALUES(?, ?)");

      preparedStatement.setInt(1, region.getRegionId());
      preparedStatement.setString(2, region.getRegionName());
      count = preparedStatement.executeUpdate();
      System.out.println(count);
      return true;
    }
    catch (SQLException e){
      System.out.println("SQL SALAH: " + e.getMessage());
    }
    return false;
  }


  public Region getById(Integer id){
    Region region = null;
    String query = "SELECT * FROM regions WHERE region_id = ?";

    try{
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, id);

      ResultSet result = preparedStatement.executeQuery();

      if(result.next()){
        region = new Region(result.getInt("region_id"), result.getString("region_name"));
      }
     return region;
    }
    catch(SQLException e){
      System.out.println("BAD SQL: " + e.getMessage());
    }

    return region;
  }

  public String update(Integer id, String new_country_name){
    Region region = this.getById(id);
    Integer count = 0;
    String query = "UPDATE regions SET region_name = ? WHERE region_id = ?";

    if(region == null) return "Region tidak ditemukan";

    try{
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, new_country_name);
      preparedStatement.setInt(2, id);
      count = preparedStatement.executeUpdate();
      return "Affected row: " + count;
    }
    catch(SQLException e){
      System.out.println("BAD SQL: " + e.getMessage());
    }
    
    return "Tidak ada data yang diupdate";
  }

  public String delete(Integer id){
    Integer count;
    Region region = this.getById(id);
    String query = "DELETE FROM regions WHERE region_id = ?";

    if(region == null) return "Region tidak ditemukan";
    
    try{
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, id);
      count = preparedStatement.executeUpdate();
      return "Affected row: " + count;
    }
    catch(SQLException e){
      System.out.println("BAD SQL: " + e.getMessage());
    }
    return "Tidak ada data yang dihapus";
  }

}
