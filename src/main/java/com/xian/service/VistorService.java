package com.xian.service;

import com.xian.pojo.Vistor;

import java.util.List;

public interface VistorService {
    List<Vistor> findAll();

    List<Vistor> searchVistor(Vistor vistor);

    Boolean addVistor(Vistor vistor);

    Boolean modify(Vistor vistor);

    Boolean deleteVistor(Integer id);
}
