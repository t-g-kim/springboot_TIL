package com.inflearn.order;

import com.inflearn.discount.DiscountPolicy;
import com.inflearn.discount.FixDiscountPolicy;
import com.inflearn.discount.RateDiscountPolicy;
import com.inflearn.member.Member;
import com.inflearn.member.MemberRepository;
import com.inflearn.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    /*
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 코드를 수정했기 때문에 OCP 위반
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private DiscountPolicy discountPolicy; // 인터페이스에만 의존한다.

    // NPE : null 에 점찍으면 생긴다.!
    */

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

