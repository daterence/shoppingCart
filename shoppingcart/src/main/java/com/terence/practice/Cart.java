package com.terence.practice;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<String> cart = new ArrayList<>();

    public String listCart() {
        return cart.toString();
    }

    public int numberOfItemsInCart() {
        return cart.size();
    }

    public void addItem(String item) {
        cart.add(item);
    }

    public boolean isItemInCart(String item) {
        return cart.contains(item);
    }

    public String deleteItem(int i) {
        if (i > cart.size()) {
            return "Incorrect item index";
        }
        if (!cart.isEmpty()) {
            return cart.remove(i);
        }
        return "Your cart is empty";
    }
    public List<String> getCart() {
        return cart;
    }
}
