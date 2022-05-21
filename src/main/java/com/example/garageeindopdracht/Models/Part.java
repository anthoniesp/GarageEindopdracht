package com.example.garageeindopdracht.Models;

public class Part {
    private String partName;
    private String partPrice;

    public Part(String name, String price) {
        this.partName = name;
        this.partPrice = price;
    }

    public String getPartName() {
        return partName;
    }

    public String getPartPrice() {
        return partPrice;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setPartPrice(String partPrice) {
        this.partPrice = partPrice;
    }
}
