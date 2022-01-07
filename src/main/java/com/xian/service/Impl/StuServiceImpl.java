package com.xian.service.Impl;

import com.xian.mapper.FloorMapper;
import com.xian.mapper.RoomMapper;
import com.xian.mapper.StuMapper;
import com.xian.pojo.Floor;
import com.xian.pojo.Room;
import com.xian.pojo.Stu;
import com.xian.service.FloorService;
import com.xian.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private StuMapper stuMapper;
    @Autowired
    private FloorMapper floorMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public List<Map<String,Object>> findAll() {
        List<Map<String,Object>> stuList = new ArrayList<>();
        for (Stu stu:stuMapper.findAll()) {
            HashMap<String, Object> stuMap = new HashMap<>();
            stuMap.put("stu",stu);
            stuMap.put("room",roomMapper.queryRoomById(stu.getR_id()));
            Floor floor = new Floor();
            floor.setB_num(roomMapper.queryFloorNum(stu.getR_id()));
            stuMap.put("floor",floorMapper.searchFloor(floor).get(0));
            stuList.add(stuMap);
        }
        return stuList;
    }

    @Override
    public List<Map<String, Object>> searchStuByInfo(Stu stu, Room room, Floor floor) {
        List<Map<String,Object>> stuList = new ArrayList<>();
        for (Stu stu1:stuMapper.searchStuByInfo(stu.getS_num(),stu.getS_name(),stu.getS_class(),room.getR_id(),floor.getB_num())) {
            HashMap<String, Object> stuMap = new HashMap<>();
            stuMap.put("stu",stu);
            stuMap.put("room",roomMapper.queryRoomById(stu.getR_id()));
            Floor floor1 = new Floor();
            floor1.setId(stu.getId());
            stuMap.put("floor",floorMapper.searchFloor(floor1).get(0));
            stuList.add(stuMap);
        }
        return stuList;
    }

    @Override
    public Boolean addStu(Stu stu) {
        return stuMapper.addStu(stu)>0;
    }

    @Override
    public boolean deleteStu(Integer id) {
        return stuMapper.deleteStu(id)>0;
    }

    @Override
    public List<Stu> findNoRoom() {
        return stuMapper.findNoRoom();
    }

    @Override
    public List<Stu> searchNoRoom(Stu stu) {
        return stuMapper.searchNoRoom(stu);
    }

    @Override
    public boolean inRoom(Stu stu, Integer r_id, Integer b_num) {
        stu.setR_id(r_id);
        stuMapper.update(stu);
        roomMapper.addUser(r_id);
        return stuMapper.addStuRoomRelation(stu.getS_num(),r_id,new Date())>0;
    }

    @Override
    public boolean outRoom(Stu stu) {
        stuMapper.outRoom(stu);
        roomMapper.delUser(stu.getR_id());
        return stuMapper.delStuRoomRelation(stu.getS_num(),stu.getR_id(),new Date())>0;
    }

    @Override
    public Boolean modify(Stu stu) {
        return stuMapper.update(stu)>0;
    }

    @Override
    public List<Map<String, Object>> searchStu(Stu stu) {
        List<Map<String,Object>> stuList = new ArrayList<>();
        for (Stu stu1:stuMapper.searchStu(stu)) {
            HashMap<String, Object> stuMap = new HashMap<>();
            stuMap.put("stu",stu1);
            stuMap.put("room",roomMapper.queryRoomById(stu.getR_id()));
            Floor floor1 = new Floor();
            floor1.setId(stu1.getId());
            stuMap.put("floor",floorMapper.searchFloor(floor1).get(0));
            stuList.add(stuMap);
        }
        return stuList;
    }

    @Override
    public List<Stu> searchHaveRoom(Stu stu) {
        return stuMapper.searchHaveRoom(stu);
    }

    @Override
    public List<Stu> findHaveRoom() {
        return stuMapper.findHaveRoom();
    }
}
