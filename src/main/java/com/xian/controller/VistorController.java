package com.xian.controller;

import com.xian.pojo.Bto;
import com.xian.pojo.Stu;
import com.xian.pojo.Vistor;
import com.xian.service.VistorService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vistor")
public class VistorController {
    @Autowired
    private VistorService vistorService;
    @GetMapping("/findAll")
    public List<Vistor> findAll(){
        return vistorService.findAll();
    }
    @PostMapping("/search")
    public List<Vistor> search(@RequestBody Vistor vistor){
        return vistorService.searchVistor(vistor);
    }
    @PostMapping("/add")
    public Boolean add(@RequestBody Vistor vistor){
        return vistorService.addVistor(vistor);
    }
    @PostMapping("/modify")
    public Boolean modify(@RequestBody Vistor vistor){return vistorService.modify(vistor);}
    @DeleteMapping("/del/{id}")
    public Boolean delete(@PathVariable("id") Integer id){
        return vistorService.deleteVistor(id);
    }
}
