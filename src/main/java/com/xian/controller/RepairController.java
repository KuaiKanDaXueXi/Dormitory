package com.xian.controller;

import com.xian.pojo.Ato;
import com.xian.pojo.Cto;
import com.xian.pojo.Room;
import com.xian.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/repair")
public class RepairController {
    @Autowired
    private RepairService repairService;
    @GetMapping("/findAll")
    public List<Map<String,Object>> findAll(){
        return repairService.findAll();
    }
    @PostMapping("/add")
    public Boolean add(@RequestBody Cto cto){
        return repairService.addRepair(cto.getRepair(),cto.getRoom());
    }
    @PostMapping("/modify")
    public Boolean modify(@RequestBody Cto cto){
        return repairService.modify(cto.getRepair());
    }
    @DeleteMapping("/del/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return repairService.deleteRepair(id);
    }

}
