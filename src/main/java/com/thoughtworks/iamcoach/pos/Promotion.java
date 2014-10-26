package com.thoughtworks.iamcoach.pos;

public class Promotion {
    private String barcode;
    private double discount;

    public Promotion(String barcode) {
        this.barcode = barcode;

    }

    public Promotion(String barcode, double discount) {
        this.barcode = barcode;
        this.discount = discount;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getDiscount() {
        return discount;
    }

}
