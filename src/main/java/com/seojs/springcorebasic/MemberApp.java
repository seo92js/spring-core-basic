package com.seojs.springcorebasic;

import com.seojs.springcorebasic.member.Grade;
import com.seojs.springcorebasic.member.Member;
import com.seojs.springcorebasic.member.MemberService;
import com.seojs.springcorebasic.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
