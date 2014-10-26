package com.thoughtworks.iamcoach.pos;

import java.util.*;

public class Scanner {

    public List<CartItem> process() {

        List<CartItem> cartItems = new ArrayList<CartItem>();
        List<String> cartList = FileProcessor.readFile("cart.txt");

        for (String aCartList : cartList) {
            if (aCartList.length() > 10) {
                String stringBarcode = aCartList.split("-")[0];
                String stringCount = aCartList.substring(11);
                CartItem cartItem = new CartItem(getItem(stringBarcode), Double.parseDouble(stringCount));
                cartItems.add(cartItem);
            }
        }

        Set<String> uniqueBarcode = new HashSet<String>(cartList);
        for (String barcode : uniqueBarcode) {
            if (barcode.length() <= 10) {
                CartItem cartItem = new CartItem(getItem(barcode), Collections.frequency(cartList, barcode));
                cartItems.add(cartItem);
            }
        }
        return cartItems;
    }

    private Item getItem(String barcode) {
        ItemProcessor itemProcessor = new ItemProcessor();
        List<Item> items = itemProcessor.process();

        for (Item item : items) {
            if (item.getBarcode().equals(barcode)) {
                return item;
            }
        }
        return null;
    }

}

