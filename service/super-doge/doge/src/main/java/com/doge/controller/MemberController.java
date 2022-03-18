package com.doge.controller;

import com.doge.mapper.MemberMapper;
import com.doge.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberMapper memberMapper;

    @CrossOrigin(origins = "*")
    @GetMapping("/members")
    @ResponseBody
    public List<Member> getAllProducts() {
        List<Member> members = memberMapper.getMembers();
        return members;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/points/{mid}/{points}")
    @ResponseBody
    public String updatePoints(@PathVariable Integer mid, @PathVariable Integer points) {
        memberMapper.updateMemberPoint(mid, points);
        return "successful";
    }

}