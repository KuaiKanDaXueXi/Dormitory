package com.xian.controller;

import com.xian.pojo.Floor;
import com.xian.pojo.User;
import com.xian.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/floor")
public class FloorController {
    @Autowired
    private FloorService floorService;
    @GetMapping("/findAll")
    public List<Map<String,Object>> findAll(){
        return floorService.findAll();
    }
    @PostMapping("/search")
    public List<Map<String,Object>> search(@RequestBody Floor floor){
        return floorService.searchFloor(floor);
    }
    @PostMapping("/add")
    public Boolean add(@RequestBody Floor floor){
        return floorService.addFloor(floor);
    }
    @DeleteMapping("/del/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return floorService.deleteFloor(id);
    }
    @GetMapping("/getFloor")
    public List<Integer> getFloorNum(){return floorService.getFloorNum();}
}
