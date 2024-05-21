package com.aditya.exceptions;

public class InsufficientBalanceException extends Exception{
    final String errorMessage;
    public InsufficientBalanceException(String errorMessage){
        this.errorMessage = errorMessage;
    }
    public String toString(){
        return ("Insufficient Balance in Account: "+errorMessage);
    }

}
