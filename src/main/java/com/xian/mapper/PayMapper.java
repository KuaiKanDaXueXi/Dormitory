package com.xian.mapper;

import com.xian.pojo.Pay;
import com.xian.pojo.Room;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayMapper {
    @Select("select * from tb_pay")
    List<Pay> findAll();
    @Select("select * from tb_room where id=#{r_id}")
    Room queryFloorNum(Integer r_id);
    @Insert("insert into tb_pay values(default,#{r_id},#{note},#{amount},#{date})")
    int addPay(Pay pay);
    int updatePay(Pay pay);
    @Delete("delete from tb_pay where id=#{id}")
    int deletePay(Integer id);
}
