package com.seojs.springcorebasic.order;

import com.seojs.springcorebasic.discount.DiscountPolicy;
import com.seojs.springcorebasic.discount.RateDiscountPolicy;
import com.seojs.springcorebasic.member.Member;
import com.seojs.springcorebasic.member.MemberRepository;
import com.seojs.springcorebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
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
