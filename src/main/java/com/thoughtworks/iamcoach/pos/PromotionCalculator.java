package com.thoughtworks.iamcoach.pos;

import java.util.List;

public class PromotionCalculator {

    PromotionProcessor promotionProcessor = new PromotionProcessor();

    public double calculateOneFree(CartItem cartItem) {

        double oneFreeMoney = 0.0;

        if (hasExistPromotion(cartItem, promotionProcessor.freeProcess())) {
            oneFreeMoney = ((int) (cartItem.getCount() / 3) * 2 + cartItem.getCount() % 3) * cartItem.getItem().getPrice();
        }
        return oneFreeMoney;
    }

    public double calculateDiscount(CartItem cartItem) {

        double discountMoney = 0.0;

        if (hasExistPromotion(cartItem, promotionProcessor.discountProcess())) {
            double basicMoney = cartItem.getItem().getPrice() * cartItem.getCount();
            discountMoney = basicMoney * getDiscount(cartItem.getItem().getBarcode());
        }
        return discountMoney;
    }

    public double calculateSecondHalf(CartItem cartItem) {

        double secondHalfMoney = 0.0;

        if (hasExistPromotion(cartItem, promotionProcessor.halfProcess())) {
            secondHalfMoney = cartItem.getCount() * cartItem.getItem().getPrice() - (int) (cartItem.getCount() / 3) * cartItem.getItem().getPrice() / 2;
        }
        return secondHalfMoney;
    }

    private double getDiscount(String barcode) {

        PromotionProcessor promotionProcessor = new PromotionProcessor();
        List<Promotion> discountList = promotionProcessor.discountProcess();

        for (Promotion aDiscountList : discountList) {

            if (barcode.equals(aDiscountList.getBarcode())) {
                return aDiscountList.getDiscount() / 100;
            }
        }
        return 0.0;
    }

    private boolean hasExistPromotion(CartItem cartItem, List<Promotion> promotionCartItems) {

        for (Promotion promotionCartItem : promotionCartItems) {
            if (promotionCartItem.getBarcode().equals(cartItem.getItem().getBarcode())) {
                return true;
            }
        }
        return false;
    }

}
