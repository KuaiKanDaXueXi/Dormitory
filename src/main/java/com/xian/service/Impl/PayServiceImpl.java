package com.xian.service.Impl;

import com.xian.mapper.PayMapper;
import com.xian.pojo.Pay;
import com.xian.pojo.Room;
import com.xian.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private PayMapper payMapper;
    @Override
    public List<Map<String, Object>> findAll() {
        List<Map<String,Object>> payList = new ArrayList<>();
        for (Pay pay : payMapper.findAll()) {
            HashMap<String, Object> payMap = new HashMap<>();
            payMap.put("pay",pay);
            payMap.put("room",payMapper.queryFloorNum(pay.getR_id()));
            payList.add(payMap);
        }
        return payList;
    }

    @Override
    public Boolean addPay(Pay pay, Room room) {
        pay.setR_id(room.getId());
        pay.setDate(new Date());
        return payMapper.addPay(pay)>0;
    }

    @Override
    public Boolean modify(Pay pay) {
        return payMapper.updatePay(pay)>0;
    }

    @Override
    public boolean deletePay(Integer id) {
        return payMapper.deletePay(id)>0;
    }
}
