package com.example.mybatis.mapper;

import com.example.mybatis.entity.Member;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hoxton
 * @version 0.1.0
 * @since 0.1.0
 **/
@Repository
public interface MemberDao extends JpaRepository<Member, Integer> {
    @Query(value = "SELECT id,username,age FROM member", nativeQuery = true)
    List<Member> getMemberList();

    @Query(value = "SELECT id,username,age FROM member WHERE id = :id", nativeQuery = true)
    Member getMemberById(@Param("id") int id);

    @Query(value = "DELETE FROM MEMBER  WHERE ID = :id", nativeQuery = true)
    int delete(@Param("id") int id);
}
