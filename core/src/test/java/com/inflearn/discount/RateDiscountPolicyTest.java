package com.inflearn.discount;

import com.inflearn.member.Grade;
import com.inflearn.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    // static import???

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o() {

        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인이 적용되지 말아야 한다.")
    void vip_x() {
        // given
        Member member = new Member(2L, "memberBASIC", Grade.Basic);
        // when
        int discount = discountPolicy.discount(member, 10000);
        // then
        assertThat(discount).isEqualTo(0);
    }

    @Test
    void abd(){
        assertThat(1+1).isEqualTo(2);
    }
}
