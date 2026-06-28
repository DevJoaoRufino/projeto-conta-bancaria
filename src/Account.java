package com.bankaccount.accounts;
public abstract class Account {
    protected String agency;
    protected String number;
    protected String holder;
    protected double balance;

    public Account(String agency, String number, String holder, double balance) {
        this.agency = agency;
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public String checkBalance() {
        return "Saldo atual: R$ " + String.format("%.2f", balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Depósito de R$ " + amount + " realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public abstract void withdraw(double amount);
    public abstract void transfer(double amount);
}
