package com.aditya;

public class AccountOperations {
    Account account;
    AccountOperations(Account account){
        this.account = account;
    }
    public Account deposit(double amount){
        double balance = account.getBalance();
        balance = balance + amount;
        account.setBalance(balance);
        return account;
    }

    public Account withdraw(double amount){
        double balance = account.getBalance();
        balance = balance - amount;
        account.setBalance(balance);
        return account;
    }
}
