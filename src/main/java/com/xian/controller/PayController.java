package com.xian.controller;

import com.xian.pojo.Cto;
import com.xian.pojo.Dto;
import com.xian.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private PayService payService;
    @GetMapping("/findAll")
    public List<Map<String,Object>> findAll(){
        return payService.findAll();
    }
    @PostMapping("/add")
    public Boolean add(@RequestBody Dto dto){
        return payService.addPay(dto.getPay(),dto.getRoom());
    }
    @PostMapping("/modify")
    public Boolean modify(@RequestBody Dto dto){
        return payService.modify(dto.getPay());
    }
    @DeleteMapping("/del/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return payService.deletePay(id);
    }
}
