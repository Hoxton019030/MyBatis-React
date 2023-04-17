package com.example.mybatis.request.member;

import com.example.mybatis.request.Request;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Hoxton
 * @version 0.1.0
 * @since 0.1.0
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberRequestDelete extends Request {
    int id;
}
