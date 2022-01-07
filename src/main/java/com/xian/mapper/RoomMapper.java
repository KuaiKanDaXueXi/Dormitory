package com.xian.mapper;

import com.xian.pojo.Room;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomMapper {
    @Select("select * from tb_room")
    List<Room> findAll();
    @Select("select b_num from tb_room_build where r_id = #{id}")
    Integer queryFloorNum(Integer id);
    List<Room> queryRoom(@Param("b_num") Integer b_num,@Param("r_id") Integer r_id);
    void addRoom(Room room);
    @Insert("insert into tb_room_build values(default,#{r_id},#{b_num})")
    Integer addRoomFloorRelation(@Param("b_num") Integer b_num,@Param("r_id") Integer r_id);
    @Delete("delete from tb_room where id=#{id}")
    Integer deleteRoom(Integer id);
    @Select("select * from tb_room where id=#{id}")
    Room queryRoomById(Integer id);
    void updateRoom(Room room);
    int updateRoomFloorRelation(@Param("b_num") Integer b_num,@Param("id") Integer id);
    @Select("select id from tb_room where r_id=#{r_id}")
    Integer queryRoomId(Integer r_id);
    List<Room> getNoFullRoom(Integer id);
    @Update("update tb_room set r_use = r_use+1 where id = #{r_id}")
    void addUser(Integer r_id);
    @Update("update tb_room set r_use = r_use-1 where id = #{r_id}")
    void delUser(Integer r_id);
    @Delete("delete from tb_room_build where r_id=#{id}")
    int delRoomBuildRelation(Integer id);
}
