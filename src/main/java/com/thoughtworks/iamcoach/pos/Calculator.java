package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {

    public double getSubtotal(CartItem cartItem) {

        PromotionCalculator promotionCalculator = new PromotionCalculator();

        double discountPrice = promotionCalculator.calculateDiscount(cartItem);
        double oneFreePrice = promotionCalculator.calculateOneFree(cartItem);
        double secondHalfPrice = promotionCalculator.calculateSecondHalf(cartItem);
        double subtotal;

        if (discountPrice == 0 && oneFreePrice == 0 && secondHalfPrice == 0) {
            subtotal = cartItem.getCount() * cartItem.getItem().getPrice();

        } else {

            List<Double> promotionList = new ArrayList<Double>();

            if (discountPrice > 0) {
                promotionList.add(discountPrice);
            }

            if (oneFreePrice > 0) {
                promotionList.add(oneFreePrice);
            }

            if (secondHalfPrice > 0) {
                promotionList.add(secondHalfPrice);
            }

            subtotal = Collections.min(promotionList);

        }
        return subtotal;

    }

    public double getTotalMoney() {

        double totalMoney = 0.0;

        Scanner scanner = new Scanner();
        List<CartItem> cartItems = scanner.process();

        for (CartItem cartItem : cartItems) {

            totalMoney += cartItem.getItem().getPrice() * cartItem.getCount();
        }
        return totalMoney;
    }

    public double getTotalMoneyAfterPromoting() {

        double totalMoneyAfterPromoting = 0;

        Scanner scanner = new Scanner();
        List<CartItem> cartItems = scanner.process();

        for (CartItem cartItem : cartItems) {

            totalMoneyAfterPromoting += getSubtotal(cartItem);
        }

        return totalMoneyAfterPromoting;
    }

    public double getSavedMoney() {

        return getTotalMoney() - getTotalMoneyAfterPromoting();
    }
}
