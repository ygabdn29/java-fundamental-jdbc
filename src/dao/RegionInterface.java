package dao;

import java.util.List;

import models.Region;

public interface RegionInterface {
  public List<Region> get();
  public Region get(Integer id);
  public boolean insert(Region region);
  public Integer update(Region region);
  public Integer delete(Integer id);
}
