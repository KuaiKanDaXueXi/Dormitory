package com.xian.service.Impl;

import com.xian.mapper.RepairMapper;
import com.xian.pojo.Floor;
import com.xian.pojo.Repair;
import com.xian.pojo.Room;
import com.xian.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairMapper repairMapper;
    @Override
    public List<Map<String, Object>> findAll() {
        List<Map<String,Object>> repairList = new ArrayList<>();
        for (Repair repair : repairMapper.findAll()) {
            HashMap<String, Object> repairMap = new HashMap<>();
            repairMap.put("repair",repair);
            repairMap.put("room",repairMapper.queryFloorNum(repair.getR_id()));
            repairList.add(repairMap);
        }
        return repairList;
    }

    @Override
    public Boolean addRepair(Repair repair, Room room) {
        repair.setR_id(room.getId());
        repair.setDate(new Date());
        return repairMapper.addRepair(repair)>0;
    }

    @Override
    public Boolean modify(Repair repair) {
        return repairMapper.updateRepair(repair)>0;
    }

    @Override
    public boolean deleteRepair(Integer id) {
        return repairMapper.deleteRepair(id)>0;
    }
}
