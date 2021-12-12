package com.terence.practice;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Command command = new Command();

        System.out.println("Kindly choose your directory");
        System.out.println("If empty, access directory - 'db'");
        Scanner scan1 = new Scanner(System.in);
        command.dirPath(scan1);

        System.out.println("Welcome to your shopping cart");
        System.out.println("Kindly select your option: ");
        System.out.println("<login> - load specified user's database file from selected directory");
        System.out.println("<list> - to list contents of the cart");
        System.out.println("<add> - add one or more items to the cart. Use comma to seperated items");
        System.out.println("<delete> - delete an item from cart based on the items's index");
        System.out.println("<users> - list all users in the directory");
        System.out.println("<close> - exit program");

        Scanner scan = new Scanner(System.in);
        
        // choice = list/add/delete/close
        String choice = scan.next();
        // arguments only applies to add and delete
        String arguments = scan.nextLine().trim();

        // while loop - loop does not end unless user entered "close"
        while (!choice.equalsIgnoreCase("close")) {

            if(choice.equalsIgnoreCase("login")){
                try {
                    command.login(arguments);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (choice.equalsIgnoreCase("list")) {
                command.list();
            }
            if (choice.equalsIgnoreCase("add")) {
                command.add(arguments);
            }
            if (choice.equalsIgnoreCase("delete")) {
                command.delete(arguments);
            }
            if(choice.equalsIgnoreCase("save")){
                try {
                    command.save();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(choice.equalsIgnoreCase("users")){
                command.users();
            }
            choice = scan.next();
            arguments = scan.nextLine();
        }
        // if user entered "close"
        scan.close();
        System.out.println("Program has ended");
    }
}
