package com.xian.mapper;

import com.xian.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Select("select * from tb_user where name = #{name}")
    List<User> checkLoginUser(User user);
    @Insert("insert into tb_user values(default,#{name},#{pass_word},default)")
    int registe(User user);
    @Select("select * from tb_user")
    List<User> findAll();
    List<User> searchUser(User user);
    @Update("update tb_user set name=#{name},power=#{power},realname=#{realname},pass_word=#{pass_word} where id=#{id}")
    int update(User user);
    @Delete("delete from tb_user where id=#{id}")
    int deleteUser(Integer id);
    @Insert("insert into tb_user values(default,#{name},#{pass_word},default,#{realname})")
    int add(User user);
}
