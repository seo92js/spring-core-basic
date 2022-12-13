package com.seojs.springcorebasic.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
