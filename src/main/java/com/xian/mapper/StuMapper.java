package com.xian.mapper;

import com.xian.pojo.Stu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StuMapper {
    @Select("select * from tb_stu")
    List<Stu> findAll();

    List<Stu> searchStuByInfo(@Param("s_num") String s_num,@Param("s_name") String s_name,@Param("s_class") String s_class,@Param("r_id") Integer r_id,@Param("b_num") Integer b_num);
    @Insert("insert into tb_stu values(default,#{s_num},#{s_name},#{s_class},null)")
    Integer addStu(Stu stu);
    @Delete("delete from tb_stu where id = #{id}")
    Integer deleteStu(Integer id);
    @Select("select * from tb_stu where r_id is null")
    List<Stu> findNoRoom();

    List<Stu> searchNoRoom(Stu stu);

    int update(Stu stu);

    int addStuRoomRelation(@Param("s_num")String s_num,@Param("r_id") Integer r_id,@Param("date") Date date);
    int delStuRoomRelation(@Param("s_num")String s_num,@Param("r_id") Integer r_id,@Param("date") Date date);

    List<Stu> searchStu(Stu stu);

    List<Stu> searchHaveRoom(Stu stu);
    @Select("select * from tb_stu where r_id is not null")
    List<Stu> findHaveRoom();
    void outRoom(Stu stu);
}
