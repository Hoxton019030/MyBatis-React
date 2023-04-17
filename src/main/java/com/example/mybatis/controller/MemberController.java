package com.example.mybatis.controller;

import com.example.mybatis.entity.Member;
import com.example.mybatis.request.member.MemberRequestCreate;
import com.example.mybatis.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Hoxton
 * @version 0.1.0
 * @since 0.1.0
 **/
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    final MemberService memberService;

    @PostMapping("/")
    public ResponseEntity<String> createNewMember(@RequestBody MemberRequestCreate memberRequestCreate) {
        String name = memberRequestCreate.getUsername();
        int age = memberRequestCreate.getAge();
        Member member = Member.builder().username(name).age(age).build();
        memberService.addMember(member);
        return ResponseEntity.status(HttpStatus.OK).body("create Succeed!");
    }

    @GetMapping("/")
    public ResponseEntity<List<Member>> getAllMember(){
        List<Member> memberList = memberService.getMemberList();
        return ResponseEntity.status(HttpStatus.OK).body(memberList);
    }

    @GetMapping("/")
    public ResponseEntity<Member> getMember(@PathVariable("id") int id){
        memberService
    }
}
