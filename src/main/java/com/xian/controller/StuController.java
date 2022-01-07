package com.xian.controller;

import com.xian.pojo.Bto;
import com.xian.pojo.Stu;
import com.xian.pojo.User;
import com.xian.service.StuService;
import com.xian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stu")
public class StuController {
    @Autowired
    private StuService stuService;
    @GetMapping("/findAll")
    public List<Map<String,Object>> findAll(){
        return stuService.findAll();
    }
    @GetMapping("/searchByInfo")
    public List<Map<String,Object>> searchByInfo(@RequestBody Bto bto){
        return stuService.searchStuByInfo(bto.getStu(),bto.getRoom(),bto.getFloor());
    }
    @PostMapping("/search")
    public List<Map<String,Object>> search(@RequestBody Stu stu){
        return stuService.searchStu(stu);
    }
    @PostMapping("/add")
    public Boolean add(@RequestBody Stu stu){
        return stuService.addStu(stu);
    }
    @DeleteMapping("/del/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return stuService.deleteStu(id);
    }
    @GetMapping("/findNoRoom")
    public List<Stu> findNoRoom(){return stuService.findNoRoom();}
    @GetMapping("/findHaveRoom")
    public List<Stu> findHaveRoom(){return stuService.findHaveRoom();}
    @PostMapping("/searchNoRoom")
    public List<Stu> searchNoRoom(@RequestBody Stu stu){return stuService.searchNoRoom(stu);}
    @PostMapping("/searchHaveRoom")
    public List<Stu> searchHaveRoom(@RequestBody Stu stu){return stuService.searchHaveRoom(stu);}
    @PostMapping("/in")
    public boolean in(@RequestBody Bto bto){
        return stuService.inRoom(bto.getStu(),bto.getRoom().getId(),bto.getFloor().getB_num());
    }
    @PostMapping("/out")
    public boolean out(@RequestBody Stu stu){
        return stuService.outRoom(stu);
    }
    /**
     * 修改
     */
    @PostMapping("/modify")
    public Boolean modify(@RequestBody Stu stu){return stuService.modify(stu);}
}
