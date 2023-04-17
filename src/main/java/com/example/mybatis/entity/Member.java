package com.example.mybatis.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author Hoxton
 * @version 0.1.0
 * @since 0.1.0
 **/
@Entity(name = "member")
@RequiredArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "username")
    private String username;
    @Column(name = "age")
    private int age;

}
