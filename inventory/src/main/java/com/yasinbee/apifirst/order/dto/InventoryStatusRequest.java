package com.yasinbee.apifirst.order.dto;

import java.util.StringJoiner;

public class InventoryStatusRequest {
    private Long itemId;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", InventoryStatusRequest.class.getSimpleName() + "[", "]")
                .add("itemId=" + itemId)
                .toString();
    }
}
