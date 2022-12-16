package com.seojs.springcorebasic.xml;

import com.seojs.springcorebasic.member.MemberService;
import com.seojs.springcorebasic.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class XmlAppContext {

    @Test
    void xmlAppContext(){
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

        OrderService orderService = ac.getBean("orderService", OrderService.class);
        assertThat(orderService).isInstanceOf(OrderService.class);
    }
}
