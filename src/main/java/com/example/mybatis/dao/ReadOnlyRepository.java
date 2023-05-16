package com.example.mybatis.dao;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Hoxton
 * @since 1.3.0
 **/
@NoRepositoryBean
public interface ReadOnlyRepository<T,I> extends Repository<T,I> {
    Optional<T> findById(I id);
    List<T> findAll();

}
