package com.example.mybatis.mapper;

import com.example.mybatis.entity.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Hoxton
 * @version 0.1.0
 * @since 0.1.0
 **/
@Mapper
public interface MemberMapper {

    @Insert("INSERT INTO Member(username,age) VALUES (#{username},#{age})")
    public int addMember(Member member);


    @Select("SELECT id,username,age FROM member")
    public List<Member> getMemberList();

    @Select("SELECT id,username,age FROM member WHERE id = #{id}")
    public List<Member> getMemberById(@Param("id") int id);

}
