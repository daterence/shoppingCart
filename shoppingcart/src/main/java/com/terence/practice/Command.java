package com.terence.practice;

public class Command {
    private Cart cart;

    public Command() {
        cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public void add(String items) {
        String[] strArray = items.trim().split(",");

        for (int i = 0; i < strArray.length; i++) {
            if (cart.getCart().contains(strArray[i].trim())) {
                System.out.println("You have " + strArray[i].trim() + " in your cart");
                continue;
            }
            cart.addItem(strArray[i].trim());
            System.out.println(strArray[i].trim() + " added to the cart");
        }
    }

    public void delete(String arguments) {

        int position = -1;

        try {
            position = Integer.parseInt(arguments.trim());
        } catch (NumberFormatException nfe) {
            System.out.println("Please provide a number");
        }
        // int position = Integer.parseInt(arguments.trim());
        position -= 1;

        if (!(position < 0) && position < cart.numberOfItemsInCart()) {
            String item = cart.deleteItem(position);
            System.out.println(item + " removed from cart");
        } else {
            System.out.println("Incorrect item index");
        }

    }

    public void list() {
        if (cart.numberOfItemsInCart() == 0) {
            System.out.println("Your cart is empty");
        }
        for (int i = 0; i < cart.getCart().size(); i++) {
            System.out.println("" + (i + 1) + ". " + cart.getCart().get(i));
        }
    }
}
