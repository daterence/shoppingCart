package com.terence.practice;

import java.io.File;
import java.util.Scanner;

public class File1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String path = "";

        if (!(name.isEmpty())) {
            path = "shoppingcart/" + name;
            File dir = new File(path);

            if (!dir.exists()) {
                dir.mkdir();
                System.out.println(path + " created");
            } else {
                System.out.println(path + " already existed");
            }
        } else {
            path = "shoppingcart/db";
            File dir = new File(path);

            if (!dir.exists()) {
                dir.mkdir();
                System.out.println("db created");
            } else {
                System.out.println("db already existed");
            }
        }

    }
}