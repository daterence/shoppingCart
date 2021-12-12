package com.terence.practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.print.attribute.standard.Sides;

public class Command {
    private Cart cart;
    private boolean login = false;
    private String userName = "";
    private String path = "";

    public Command() {
        cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public String dirPath(Scanner scan) {
        String name = scan.nextLine();

        if (!(name.isEmpty())) {
            path = "shoppingcart/" + name;
            File dir = new File(path);

            if (!dir.exists()) {
                dir.mkdir();
                System.out.println(path + " created\n");
            } else {
                System.out.println(path + " already existed\n");
            }
        } else {
            path = "shoppingcart/db";
            File dir = new File(path);

            if (!dir.exists()) {
                dir.mkdir();
                System.out.println(path + " created\n");
            } else {
                System.out.println(path + " already existed\n");
            }
        }
        return path;
    }

    public void login(String arguments) throws IOException {
        userName = arguments.trim();

        if (!userName.equalsIgnoreCase(""))
            login = true;
        else
            return;

        String fileName = path + "/" + userName + ".db";
        File file = new File(fileName);

        if (!file.exists()) {
            file.createNewFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                String[] dirArray = path.split("/");
                String dirName = dirArray[1];
                writer.write(dirName + "/" + userName);
                writer.newLine();
                System.out.println(fileName + " created successfully");
                System.out.println(userName + ", your cart is empty");
            }
        } else {
            System.out.println(userName + ", your cart contains the following items");
            for (int i = 0; i < cart.getCart().size(); i++) {
                System.out.println("" + (i + 1) + ". " + cart.getCart().get(i));
            }
        }
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

    public void save() throws IOException {
        if (login == false) {
            System.out.println("Need to log in first before saving to cart!");
            return;
        }
        String fileName = path + "/" + userName + ".db";

        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
                String[] dirArray = path.split("/");
                String dirName = dirArray[1];
                writer.write(dirName + "/" + userName);
                writer.newLine();
                for (String s : cart.getCart()) {
                    writer.write(s);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Opops.. cannot write to file");
        }
        System.out.println("Items saved in file.");
    }

    public void users(){
        File file = Paths.get(path).toFile();
        int i = 1;
        for(File f: file.listFiles()){
            String[] fileNames = f.getName().split("\\.");
            System.out.println(i + ". " + fileNames[0]);
            i++;
        }
    }
}
