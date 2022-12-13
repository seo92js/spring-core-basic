package com.seojs.springcorebasic.order;

import com.seojs.springcorebasic.discount.DiscountPolicy;
import com.seojs.springcorebasic.discount.RateDiscountPolicy;
import com.seojs.springcorebasic.member.Member;
import com.seojs.springcorebasic.member.MemberRepository;
import com.seojs.springcorebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}