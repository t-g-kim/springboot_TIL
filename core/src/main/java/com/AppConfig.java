package com;

import com.inflearn.discount.DiscountPolicy;
import com.inflearn.discount.FixDiscountPolicy;
import com.inflearn.discount.RateDiscountPolicy;
import com.inflearn.member.MemberRepository;
import com.inflearn.member.MemberService;
import com.inflearn.member.MemberServiceImpl;
import com.inflearn.member.MemoryMemberRepository;
import com.inflearn.order.OrderService;
import com.inflearn.order.OrderServiceImpl;

public class AppConfig {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
