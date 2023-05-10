package com.example.mybatis.request.member;

import com.example.mybatis.request.Request;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Hoxton
 * @version 0.1.0
 * @since 0.1.0
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberRequestCreate extends Request {
    @NotNull(message = "名字不得為空")
    @Size(min = 1,message = "名字不得為空")
    private String username;
    @Min(value = 0)
    @Max(value = 100)
    private int age;
}
