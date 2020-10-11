package com.yasinbee.apifirst.order.dto;

import java.util.StringJoiner;

public class OrderResponse {
    private long id;
    private String item;
    private String quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderResponse.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("item='" + item + "'")
                .add("quantity='" + quantity + "'")
                .toString();
    }
}
