package com.example.mybatis.service;

import com.example.mybatis.entity.Member;
import com.example.mybatis.dao.MemberDao;
import com.example.mybatis.exception.TargetNotFoundException;
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
    final MemberDao memberDao;


    public int addMember(Member member) {
        memberDao.save(member);
        return 1;
    }

    public List<Member> getMemberList() {
        return memberDao.getMemberList().orElseThrow(() -> new TargetNotFoundException("Not this Member"));
    }

    public Member getMember(int id) {
        return memberDao.getMemberById(id).orElseThrow(() -> new TargetNotFoundException("Not this Member"));
    }

    public void update(Member member) {
        memberDao.save(member);
    }

    public int deleteMember(int id) {
        return memberDao.delete(id);
    }

}
