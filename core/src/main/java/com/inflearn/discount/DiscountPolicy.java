package com.inflearn.discount;

import com.inflearn.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @return
     */
    int discount(Member member, int price);
}
