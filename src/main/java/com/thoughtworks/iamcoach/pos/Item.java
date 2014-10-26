package com.thoughtworks.iamcoach.pos;

public class Item {
    private String barcode;
    private String name;
    private double price;
    private String unit;

    public Item(String barcode, String name, double price, String unit) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

}
