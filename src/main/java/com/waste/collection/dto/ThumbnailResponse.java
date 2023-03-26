package com.waste.collection.dto;

public class ThumbnailResponse {
    private String fileName;
    private String location;
    private String businessName;
    private int amount;
    private int boxCount;

    public ThumbnailResponse(String fileName, String location, String businessName, int amount, int boxCount) {
        this.fileName = fileName;
        this.location = location;
        this.businessName = businessName;
        this.amount = amount;
        this.boxCount = boxCount;
    }

    public String getFileName() {
        return fileName;
    }

    public String getLocation() {
        return location;
    }

    public String getBusinessName() {
        return businessName;
    }

    public int getAmount() {
        return amount;
    }

    public int getBoxCount() {
        return boxCount;
    }
}
