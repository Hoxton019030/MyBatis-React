package com.example.mybatis.dao;

import com.example.mybatis.entity.Member;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Hoxton
 * @version 0.1.0
 * @since 0.1.0
 **/
@Repository
public interface MemberDao extends JpaRepository<Member, Integer> {
    @Query(value = "SELECT * FROM member", nativeQuery = true)
    Optional<List<Member>> getMemberList();

    @Query(value = "SELECT id,username,age FROM member WHERE id = :id", nativeQuery = true)
    Optional<Member> getMemberById(@Param("id") int id);

    @Query(value = "DELETE FROM MEMBER  WHERE ID = :id", nativeQuery = true)
    int delete(@Param("id") int id);

    @Override
    Page<Member> findAll(Pageable pageable);
}
