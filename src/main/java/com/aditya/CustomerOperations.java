package com.aditya;

import java.util.Scanner;

public class CustomerOperations {
    Scanner input = new Scanner(System.in);
    public void customerLogin(Main main){
        System.out.println("Enter your customer ID:");
        int customerId = Integer.parseInt(input.nextLine());
        Account account = main.customerList.get(customerId);
        if(account == null){
            System.out.println("Customer not found");
            return;
        }else{
            System.out.println("Welcome " + account.getName());
            customerMenu(account,customerId);
        }
    }
    private void customerMenu(Account account,Integer customerId){
        AccountOperations accountOperations = new AccountOperations(account);
        boolean exit = true;
        while (exit){
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Logout");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Balance: " + account.getBalance());
                    break;
                case 5:
                    System.out.println("Enter amount to deposit:");
                    accountOperations.deposit(Double.parseDouble(input.nextLine()));
                    break;
                case 6:
                    System.out.println("Enter Amount to Withdraw");
                    accountOperations.withdraw(Double.parseDouble(input.nextLine()));
                    break;
                case 7:
                    exit = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
