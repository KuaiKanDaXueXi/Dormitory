package com.xian.mapper;

import com.xian.pojo.Vistor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VistorMapper {
    @Select("select * from tb_vistor")
    List<Vistor> findAll();
    List<Vistor> searchVistor(Vistor vistor);
    @Insert("insert into tb_vistor values(default,#{v_name},#{date})")
    int addVistor(Vistor vistor);
    int modify(Vistor vistor);
    @Delete("delete from tb_vistor where id=#{id}")
    int deleteVistor(Integer id);
}
