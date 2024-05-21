package com.aditya.services;

import com.aditya.exceptions.InsufficientBalanceException;
import com.aditya.interfaces.AccountOperationsInterface;

public class AccountOperations implements AccountOperationsInterface {
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

    public Account withdraw(double amount) throws InsufficientBalanceException{
        double balance = account.getBalance();
        if(balance < amount){
            throw new InsufficientBalanceException(account.getName());
        }
        balance = balance - amount;
        account.setBalance(balance);
        return account;
    }
}
