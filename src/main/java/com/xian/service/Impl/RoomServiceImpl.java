package com.xian.service.Impl;

import com.xian.mapper.RoomMapper;
import com.xian.pojo.Floor;
import com.xian.pojo.Room;
import com.xian.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public List<Map<String,Object>> findAll() {
        List<Map<String,Object>> roomList = new ArrayList<>();
        for (Room room : roomMapper.findAll()) {
            HashMap<String, Object> roomMap = new HashMap<>();
            roomMap.put("room",room);
            Floor floor = new Floor();
            floor.setB_num(roomMapper.queryFloorNum(room.getId()));
            roomMap.put("floor",floor);
            roomList.add(roomMap);
        }
        return roomList;
    }

    @Override
    public List<Map<String,Object>> searchRoom(Integer b_num, Integer r_id) {
        List<Map<String,Object>> roomList = new ArrayList<>();
        Integer id = r_id!=null?roomMapper.queryRoomId(r_id):null;
        if ((r_id!=null) && id==null && b_num==null)
            return roomList;
        else {
            for (Room room : roomMapper.queryRoom(b_num, id)) {
                HashMap<String, Object> roomMap = new HashMap<>();
                roomMap.put("room", room);
                Floor floor = new Floor();
                floor.setB_num(roomMapper.queryFloorNum(room.getId()));
                roomMap.put("floor", floor);
                roomList.add(roomMap);
            }
            return roomList;
        }
    }

    @Override
    public Boolean addRoom(Integer b_num,Room room) {
        roomMapper.addRoom(room);
        return roomMapper.addRoomFloorRelation(b_num,room.getId())>0;
    }

    @Override
    public Boolean deleteRoom(Integer id) {
        roomMapper.delRoomBuildRelation(id);
        return roomMapper.deleteRoom(id)>0;
    }

    @Override
    public Boolean modify(Integer b_num, Room room) {
        roomMapper.updateRoom(room);
        return roomMapper.updateRoomFloorRelation(b_num,room.getId())>0;
    }

    @Override
    public List<Room> getNoFullRoom(Integer id) {
        return roomMapper.getNoFullRoom(id);
    }
}
