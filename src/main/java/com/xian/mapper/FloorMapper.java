package com.xian.mapper;

import com.xian.pojo.Floor;
import com.xian.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorMapper {
    @Select("select * from tb_build")
    List<Floor> findAll();
    @Select("select count(*) from tb_room_build where b_num=#{id}")
    int queryRoomCount(Integer id);
    List<Floor> searchFloor(Floor floor);
    @Insert("insert into tb_build values(default,#{b_num})")
    int addFloor(Floor floor);
    @Delete("delete from tb_build where id = #{id}")
    int deleteFloor(Integer id);
    @Select("select b_num from tb_build")
    List<Integer> getFloorNum();
}
