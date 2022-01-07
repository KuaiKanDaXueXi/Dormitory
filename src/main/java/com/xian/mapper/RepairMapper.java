package com.xian.mapper;

import com.xian.pojo.Repair;
import com.xian.pojo.Room;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairMapper {
    @Select("select * from tb_fix")
    List<Repair> findAll();
    @Select("select * from tb_room where id=#{r_id}")
    Room queryFloorNum(Integer r_id);
    @Insert("insert into tb_fix values(default,#{r_id},#{note},#{date})")
    int addRepair(Repair repair);
    int updateRepair(Repair repair);
    @Delete("delete from tb_fix where id=#{id}")
    int deleteRepair(Integer id);
}
