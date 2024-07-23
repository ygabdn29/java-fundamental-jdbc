package dao.implementation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.RegionInterface;
import models.Region;

public class RegionDAO implements RegionInterface {
  private Connection connection;

  public RegionDAO(Connection connection) {
    this.connection = connection;
  }
  
  @Override
  public List<Region> get(){
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

  @Override
  public boolean insert(Region region){
    Integer count;

    try{
      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO regions(region_id, region_name) VALUES(?, ?)");

      preparedStatement.setInt(1, region.getId());
      preparedStatement.setString(2, region.getName());
      count = preparedStatement.executeUpdate();
      System.out.println(count);
      return true;
    }
    catch (SQLException e){
      System.out.println("SQL SALAH: " + e.getMessage());
    }
    return false;
  }

  @Override
  public Region get(Integer id){
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

  @Override
  public Integer update(Region updateRegion){
    Region region = get(updateRegion.getId());
    Integer count = 0;

    String query = "UPDATE regions SET region_name = ? WHERE region_id = ?";

    if(region == null) return count;

    try{
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, updateRegion.getName());
      preparedStatement.setInt(2, updateRegion.getId());
      count = preparedStatement.executeUpdate();
      return count;
    }
    catch(SQLException e){
      System.out.println("BAD SQL: " + e.getMessage());
    }
    
    return count;
  }

  @Override
  public Integer delete(Integer id){
    Integer count = 0;
    Region region = get(id);
    String query = "DELETE FROM regions WHERE region_id = ?";

    if(region == null) return count;
    
    try{
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, id);
      count = preparedStatement.executeUpdate();
      return count;
    }
    catch(SQLException e){
      System.out.println("BAD SQL: " + e.getMessage());
    }
    return count;
  }

}
