package com.aditya.interfaces;

import com.aditya.exceptions.InsufficientBalanceException;
import com.aditya.services.Account;

public interface AccountOperationsInterface {
    public Account deposit(double amount);
    public Account withdraw(double amount) throws InsufficientBalanceException;
}
