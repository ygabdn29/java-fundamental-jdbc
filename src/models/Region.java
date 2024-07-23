package models;

public class Region {
  private int regionId;
  private String regionName;
  
  public int getRegionId() {
    return regionId;
  }
  public void setRegionId(int regionId) {
    this.regionId = regionId;
  }
  public String getRegionName() {
    return regionName;
  }
  public void setRegionName(String regionName) {
    this.regionName = regionName;
  }
  
  public Region(int regionId, String regionName) {
    this.regionId = regionId;
    this.regionName = regionName;
  }
  
}
