package com.example.mybatis.service;

import com.example.mybatis.entity.Member;
import com.example.mybatis.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Hoxton
 * @version 0.1.0
 * @since 0.1.0
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    final MemberMapper memberMapper;


    public int addMember(Member member){
        memberMapper.addMember(member);
        return 1;
    }
    public List<Member> getMemberList(){
        return memberMapper.getMemberList();
    }
    public Member getMember(int id){
        return memberMapper.getMemberById(id);
    }
    public int update(Member member){
        String username = member.getUsername();
        int age = member.getAge();
        int id = member.getId();
        return memberMapper.update(id, username, age);
    }

    public int deleteMember(int id){
        return memberMapper.delete(id);
    }

}
