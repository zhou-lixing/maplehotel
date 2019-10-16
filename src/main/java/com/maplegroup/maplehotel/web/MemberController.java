package com.maplegroup.maplehotel.web;

import com.maplegroup.maplehotel.entity.Member;
import com.maplegroup.maplehotel.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @RequestMapping("/memberView")
    public ModelAndView member() {
        return new ModelAndView("member/member");
    }

    @ResponseBody
    @RequestMapping("/findMemberAll")
    public List<Member> findMemberAll() {
        return memberService.findMemberAll();
    }

    @ResponseBody
    @RequestMapping("/findMember")
    public Member findMemberDo(@RequestParam Map<String,Object> map) {
        String memberName = (String)map.get("memberName");
        return memberService.findMemberByName(memberName);
    }

    @ResponseBody
    @RequestMapping("/deleteMember/{memberName}")
    public boolean deleteMember(@PathVariable("memberName") String memberName) {
        return memberService.deleteMember(memberName);
    }
}
