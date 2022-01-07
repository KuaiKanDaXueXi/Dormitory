package com.xian.service;

import com.xian.pojo.Pay;
import com.xian.pojo.Room;

import java.util.List;
import java.util.Map;

public interface PayService {
    List<Map<String, Object>> findAll();

    Boolean addPay(Pay pay, Room room);

    Boolean modify(Pay pay);

    boolean deletePay(Integer id);
}
