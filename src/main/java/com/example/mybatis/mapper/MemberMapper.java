package com.example.mybatis.mapper;

import com.example.mybatis.entity.Member;
import org.apache.ibatis.annotations.*;

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
    public Member getMemberById(@Param("id") int id);
    @Update("UPDATE member SET username = #{username},age=#{age} WHERE id=#{id}")
    public int update(int id, String username, int age);
    @Delete("DELETE  member WHERE id=#{id}}")
    public int delete(int id);
}
