package com.aditya;
import com.aditya.Account;
import java.util.*;

public class Main {
    Map<Integer,Account> customerList = new HashMap<>();
    public static void main(String[] args) {
        Main main = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Banking Application:");
        boolean exit = true;
        while (exit){
            System.out.println("Enter your choice:");
            System.out.println("1. User");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("User");
                    User user = new User();
                    user.userOptions(main);
                    break;
                case 2:
                    CustomerOperations customerOperations = new CustomerOperations();
                    customerOperations.customerLogin(main);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    exit = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}