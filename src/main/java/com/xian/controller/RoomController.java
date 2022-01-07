package com.xian.controller;

import com.xian.pojo.*;
import com.xian.service.RoomService;
import com.xian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @GetMapping("/findAll")
    public List<Map<String,Object>> findAll(){
        return roomService.findAll();
    }
    @PostMapping("/search")
    public List<Map<String,Object>> search(@RequestBody Ato ato){
        return roomService.searchRoom(ato.getFloor().getB_num(),ato.getRoom().getR_id());
    }
    @PostMapping("/add")
    public Boolean add(@RequestBody Ato ato){
        return roomService.addRoom(ato.getFloor().getB_num(),ato.getRoom());
    }
    @PostMapping("/modify")
    public Boolean modify(@RequestBody Ato ato){
        return roomService.modify(ato.getFloor().getB_num(),ato.getRoom());
    }
    @DeleteMapping("/del/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return roomService.deleteRoom(id);
    }
    @GetMapping("/getNoFullRoom/{id}")
    public List<Room> getNoFullRoom(@PathVariable("id") Integer id){
        return roomService.getNoFullRoom(id);
    }
}
