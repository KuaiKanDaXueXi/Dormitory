package com.xian.service;

import com.xian.pojo.Room;

import java.util.List;
import java.util.Map;

public interface RoomService {
    List<Map<String,Object>> findAll();

    List<Map<String,Object>> searchRoom(Integer b_num, Integer r_id);

    Boolean addRoom(Integer b_num,Room room);

    Boolean deleteRoom(Integer id);

    Boolean modify(Integer b_num, Room room);

    List<Room> getNoFullRoom(Integer id);
}
