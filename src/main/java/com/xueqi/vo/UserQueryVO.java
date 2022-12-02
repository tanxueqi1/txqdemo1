package com.xueqi.vo;

import com.xueqi.model.Orders;
import com.xueqi.model.User;

public class UserQueryVO {

    private User user;
    private Orders orders;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "UserQueryVO{" +
                "user=" + user +
                ", orders=" + orders +
                '}';
    }
}
