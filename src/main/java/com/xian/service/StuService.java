package com.xian.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xian.pojo.Floor;
import com.xian.pojo.Room;
import com.xian.pojo.Stu;

import java.util.List;
import java.util.Map;

public interface StuService {
    List<Map<String,Object>> findAll();

    List<Map<String, Object>> searchStuByInfo(Stu stu, Room room, Floor floor);

    Boolean addStu(Stu stu);

    boolean deleteStu(Integer id);

    List<Stu> findNoRoom();

    List<Stu> searchNoRoom(Stu stu);

    boolean inRoom(Stu stu, Integer r_id, Integer b_num);

    boolean outRoom(Stu stu);

    Boolean modify(Stu stu);

    List<Map<String, Object>> searchStu(Stu stu);

    List<Stu> searchHaveRoom(Stu stu);

    List<Stu> findHaveRoom();
}
