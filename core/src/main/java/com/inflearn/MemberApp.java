package com.inflearn;

import com.AppConfig;
import com.inflearn.member.Grade;
import com.inflearn.member.Member;
import com.inflearn.member.MemberService;
import com.inflearn.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();// MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("find member = " + member.getName());
        System.out.println("new member = " + findMember.getName());

    }
}
