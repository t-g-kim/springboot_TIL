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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Bean(name = "memberService")   // spring container에 등록이된다.
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
