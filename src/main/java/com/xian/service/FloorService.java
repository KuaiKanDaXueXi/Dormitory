package com.xian.service;

import com.xian.pojo.Floor;
import com.xian.pojo.User;

import java.util.List;
import java.util.Map;

public interface FloorService {
    List<Map<String,Object>> findAll();

    List<Map<String,Object>> searchFloor(Floor floor);

    Boolean addFloor(Floor floor);

    boolean deleteFloor(Integer id);

    List<Integer> getFloorNum();
}
