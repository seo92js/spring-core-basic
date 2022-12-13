package com.seojs.springcorebasic;

import com.seojs.springcorebasic.member.Grade;
import com.seojs.springcorebasic.member.Member;
import com.seojs.springcorebasic.member.MemberService;
import com.seojs.springcorebasic.member.MemberServiceImpl;
import com.seojs.springcorebasic.order.Order;
import com.seojs.springcorebasic.order.OrderService;
import com.seojs.springcorebasic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
