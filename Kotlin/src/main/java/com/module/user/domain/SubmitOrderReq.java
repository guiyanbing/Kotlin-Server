package com.module.user.domain;

import com.module.user.model.Order;

public class SubmitOrderReq {
    private Order order;

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
