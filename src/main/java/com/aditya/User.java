package com.aditya;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class User {
    Scanner input = new Scanner(System.in);
    void userOptions(Main main) {
        boolean exit = true;
        while(exit){
        System.out.println("Enter your choice:");
        System.out.println("1. Create Account");
        System.out.println("2. Delete Account");
        System.out.println("3. List Accounts");
        System.out.println("4. Check Balance");
        System.out.println("5. Deposit");
        System.out.println("6. Withdraw");
        System.out.println("7. Back to main menu...C");
        int choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Account created successfully with customer id:" + createAccount(main));
                    break;
                case 2:
                    if (deleteAccount(main)) {
                        System.out.println("Account deleted successfully");
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 3:
                    listAccounts(main);
                    break;
                case 4:
                    checkBalance(main);
                    break;
                case 5:
                    System.out.println("Deposit");
                    depositAmount(main);
                    break;
                case 6:
                    System.out.println("Withdraw");
                    withdrawAmount(main);
                    break;
                case 7:
                    exit = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private Integer createAccount(Main main){
        System.out.println("Enter your name:");
        String name = input.nextLine();
        Account account = new Account(name);
        Random rand = new Random();
        Integer custId= rand.nextInt(10000000);
        main.customerList.put(custId,account);
        return custId;
    }
    private Boolean deleteAccount(Main main){
        System.out.println("Enter your customer id:");
        int customerId = Integer.parseInt(input.nextLine());
        Account account = main.customerList.get(customerId);
        if(account == null){
            return false;
        }
        else{
            main.customerList.remove(customerId);
            return true;
        }
    }

    private void checkBalance(Main main){
        System.out.println("Enter your customer id:");
        int customerId = Integer.parseInt(input.nextLine());
        Account account = main.customerList.get(customerId);
        if(account == null){
            System.out.println("Account not found");
        }else{
            System.out.println("Account balance for Customer Id :"+ customerId + " is:" + account.getBalance());
        }
    }

    private void listAccounts(Main main){
        System.out.println("List of accounts:");
        for (Map.Entry<Integer, Account> entry : main.customerList.entrySet()) {
            System.out.println("Customer Id : " + entry.getKey() + " Name : " + entry.getValue().getName() + " Balance : " + entry.getValue().getBalance());
        }
    }
    private void depositAmount(Main main){
        System.out.println("Enter your customer id:");
        int customerId = Integer.parseInt(input.nextLine());
        Account account = main.customerList.get(customerId);
        System.out.println("Enter the amount to deposit:");
        double amount = Double.parseDouble(input.nextLine());
        AccountOperations accountOperations = new AccountOperations(account);
        main.customerList.put(customerId,accountOperations.deposit(amount));
        System.out.println("Amount deposited successfully");
    }

    private void withdrawAmount(Main main){
        System.out.println("Enter your customer id:");
        int customerId = Integer.parseInt(input.nextLine());
        Account account = main.customerList.get(customerId);
        System.out.println("Enter the amount to withdraw:");
        double amount = Double.parseDouble(input.nextLine());
        if(account.getBalance() < amount){
            System.out.println("Insufficient balance");
            return;
        }
        AccountOperations accountOperations = new AccountOperations(account);
        main.customerList.put(customerId,accountOperations.deposit(amount));
        System.out.println("Amount deposited successfully");
    }
}
