package com.terence.practice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to your shopping cart");
        System.out.println("Kindly select your option: ");
        System.out.println("<list> - to list contents of the cart");
        System.out.println("<add> - add one or more items to the cart. Use comma to seperated items");
        System.out.println("<delete> = delete an item from cart based on the items's index");

        Scanner scan = new Scanner(System.in);
        Command command = new Command();
        // choice = list/add/delete/close
        String choice = scan.next();
        // arguments only applies to add and delete
        String arguments = scan.nextLine().trim();

        // while loop - loop does not end unless user entered "close"
        while (!choice.equalsIgnoreCase("close")) {
            if (choice.equalsIgnoreCase("list")) {
                command.list();
            }
            if (choice.equalsIgnoreCase("add")) {
                command.add(arguments);
            }
            if (choice.equalsIgnoreCase("delete")) {
                command.delete(arguments);
            }
            choice = scan.next();
            arguments = scan.nextLine();
        }
        // if user entered "close"
        scan.close();
        System.out.println("Program has ended");
    }
}
