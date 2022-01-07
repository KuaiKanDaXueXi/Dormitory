package com.xian.service.Impl;

import com.xian.mapper.VistorMapper;
import com.xian.pojo.Vistor;
import com.xian.service.VistorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VistorServiceImpl implements VistorService {
    @Autowired
    private VistorMapper vistorMapper;
    @Override
    public List<Vistor> findAll() {
        return vistorMapper.findAll();
    }

    @Override
    public List<Vistor> searchVistor(Vistor vistor) {
        return vistorMapper.searchVistor(vistor);
    }

    @Override
    public Boolean addVistor(Vistor vistor) {
        vistor.setDate(new Date());
        return vistorMapper.addVistor(vistor)>0;
    }

    @Override
    public Boolean modify(Vistor vistor) {
        return vistorMapper.modify(vistor)>0;
    }

    @Override
    public Boolean deleteVistor(Integer id) {
        return vistorMapper.deleteVistor(id)>0;
    }
}
