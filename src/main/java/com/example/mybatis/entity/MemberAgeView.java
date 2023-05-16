package com.example.mybatis.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Hoxton
 * @since 1.3.0
 **/

@Entity
@Immutable
@Table(name = "member_age_summary")
@Subselect("select * from member")
@Getter
@Setter
public class MemberAgeView {

    @Id
    private Long id;

    private int age;

}
