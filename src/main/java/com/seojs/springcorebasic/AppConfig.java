package com.seojs.springcorebasic;

import com.seojs.springcorebasic.discount.DiscountPolicy;
import com.seojs.springcorebasic.discount.FixDiscountPolicy;
import com.seojs.springcorebasic.discount.RateDiscountPolicy;
import com.seojs.springcorebasic.member.MemberRepository;
import com.seojs.springcorebasic.member.MemberService;
import com.seojs.springcorebasic.member.MemberServiceImpl;
import com.seojs.springcorebasic.member.MemoryMemberRepository;
import com.seojs.springcorebasic.order.OrderService;
import com.seojs.springcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
