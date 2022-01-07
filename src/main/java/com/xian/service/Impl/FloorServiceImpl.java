package com.xian.service.Impl;

import com.xian.mapper.FloorMapper;
import com.xian.pojo.Floor;
import com.xian.pojo.User;
import com.xian.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FloorServiceImpl implements FloorService {
    @Autowired
    private FloorMapper floorMapper;
    @Override
    public List<Map<String,Object>> findAll() {
        List<Map<String,Object>> floorList = new ArrayList<>();
        for (Floor floor : floorMapper.findAll()) {
            HashMap<String, Object> floorMap = new HashMap<>();
            floorMap.put("floor",floor);
            floorMap.put("count",floorMapper.queryRoomCount(floor.getB_num()));
            floorList.add(floorMap);
        }
        return floorList;
    }

    @Override
    public List<Map<String,Object>> searchFloor(Floor floor) {
        List<Map<String,Object>> floorList = new ArrayList<>();
        for(Floor floor1 : floorMapper.searchFloor(floor)) {
            HashMap<String, Object> floorMap = new HashMap<>();
            floorMap.put("floor",floor1);
            floorMap.put("count",floorMapper.queryRoomCount(floor1.getId()));
            floorList.add(floorMap);
        }

        return floorList;
    }

    @Override
    public Boolean addFloor(Floor floor) {
        return floorMapper.addFloor(floor)>0;
    }

    @Override
    public boolean deleteFloor(Integer id) {
        return floorMapper.deleteFloor(id)>0;
    }

    @Override
    public List<Integer> getFloorNum() {
        return floorMapper.getFloorNum();
    }
}
