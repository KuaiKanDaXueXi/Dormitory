package com.xian.service;

import com.xian.pojo.Repair;
import com.xian.pojo.Room;

import java.util.List;
import java.util.Map;

public interface RepairService {
    List<Map<String, Object>> findAll();

    Boolean addRepair(Repair repair, Room room);

    Boolean modify(Repair repair);

    boolean deleteRepair(Integer id);
}
