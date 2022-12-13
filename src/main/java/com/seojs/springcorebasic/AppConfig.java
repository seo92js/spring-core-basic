package com.seojs.springcorebasic;

import com.seojs.springcorebasic.discount.FixDiscountPolicy;
import com.seojs.springcorebasic.member.MemberService;
import com.seojs.springcorebasic.member.MemberServiceImpl;
import com.seojs.springcorebasic.member.MemoryMemberRepository;
import com.seojs.springcorebasic.order.OrderService;
import com.seojs.springcorebasic.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
