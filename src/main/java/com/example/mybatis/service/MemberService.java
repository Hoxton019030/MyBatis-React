package com.example.mybatis.service;

import com.example.mybatis.dao.MemberAgeSummaryDao;
import com.example.mybatis.dao.MemberDao;
import com.example.mybatis.entity.MemberAgeView;
import com.example.mybatis.exception.TargetNotFoundException;
import com.example.mybatis.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    final MemberAgeSummaryDao memberAgeSummaryDao;
//    final MemberPageRepository<Member,Integer> memberPageRepository;


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

    public List<MemberAgeView> getMemberAgeView(){
        return memberAgeSummaryDao.findAll();
    }

    public Page<Member> findAll(Pageable pageable){
        return memberDao.findAll(pageable);
    }

}
