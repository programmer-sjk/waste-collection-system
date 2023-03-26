package com.waste.partner_company.dto;

public class CollectionAmountResponse {
    private String name;
    private String location;
    private int amount;
    private int boxCount;

    private CollectionAmountResponse() {}

    public CollectionAmountResponse(String name, String location, int amount, int boxCount) {
        this.name = name;
        this.location = location;
        this.amount = amount;
        this.boxCount = boxCount;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getAmount() {
        return amount;
    }

    public int getBoxCount() {
        return boxCount;
    }
}
