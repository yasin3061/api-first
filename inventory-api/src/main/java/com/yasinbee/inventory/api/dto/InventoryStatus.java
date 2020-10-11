package com.yasinbee.inventory.api.dto;

import java.util.StringJoiner;

public class InventoryStatus {
    private Long uniqueItemId;
    private String itemName;
    private String itemDescription;
    private int availableQuantity;

    public Long getUniqueItemId() {
        return uniqueItemId;
    }

    public void setUniqueItemId(Long uniqueItemId) {
        this.uniqueItemId = uniqueItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", InventoryStatus.class.getSimpleName() + "[", "]")
                .add("uniqueItemId=" + uniqueItemId)
                .add("itemName='" + itemName + "'")
                .add("itemDescription='" + itemDescription + "'")
                .add("availableQuantity=" + availableQuantity)
                .toString();
    }
}
