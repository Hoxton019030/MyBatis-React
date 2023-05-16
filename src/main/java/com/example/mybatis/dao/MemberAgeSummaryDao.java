package com.example.mybatis.dao;

import com.example.mybatis.entity.MemberAgeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 * @author Hoxton
 * @since 1.3.0
 **/

public interface MemberAgeSummaryDao extends ReadOnlyRepository<MemberAgeView,Long> {
}
