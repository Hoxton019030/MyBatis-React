package com.example.mybatis.controller;

import com.example.mybatis.entity.Member;
import com.example.mybatis.request.member.MemberRequestCreate;
import com.example.mybatis.request.member.MemberRequestUpdate;
import com.example.mybatis.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@CrossOrigin(value = {"http://localhost:3000"})

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

    @PatchMapping("/")
    public ResponseEntity<String> updateMember(@RequestBody MemberRequestUpdate memberRequestUpdate) {
        int id = memberRequestUpdate.getId();
        String username = memberRequestUpdate.getUsername();
        int age = memberRequestUpdate.getAge();
        Member team = Member.builder().id(id).username(username).age(age).build();

        memberService.update(team);
        return ResponseEntity.status(HttpStatus.OK).body("update Succeed");
    }

    @GetMapping("/")
    public ResponseEntity<List<Member>> getAllMember() {
        List<Member> memberList = memberService.getMemberList();
        return ResponseEntity.status(HttpStatus.OK).body(memberList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable("id") int id) {
        Member member = memberService.getMember(id);
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMemberById(@PathVariable("id")int id){
        memberService.deleteMember(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete Succeed");
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Member>> findAllPage(Pageable pageable){
        Page<Member> page = memberService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }
}
