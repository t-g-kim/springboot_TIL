package com.inflearn;

import com.AppConfig;
import com.inflearn.member.Grade;
import com.inflearn.member.Member;
import com.inflearn.member.MemberService;
import com.inflearn.member.MemberServiceImpl;
import com.inflearn.order.Order;
import com.inflearn.order.OrderService;
import com.inflearn.order.OrderServiceImpl;
import com.sun.tools.corba.se.idl.constExpr.Or;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}
