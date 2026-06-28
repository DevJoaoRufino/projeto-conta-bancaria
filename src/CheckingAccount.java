package com.bankaccount.accounts;
public class CheckingAccount extends Account {
    private double overdraft;

    public CheckingAccount(String agency, String number, String holder, double balance, double overdraft) {
        super(agency, number, holder, balance);
        this.overdraft = overdraft;
    }

    public void withdraw(double amount) {
        if (amount <= balance + overdraft) {
            balance -= amount;
            System.out.println("Saque de R$ " + amount + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente (mesmo com cheque especial).");
        }
    }

    public void transfer(double amount) {
        if (amount <= balance + overdraft) {
            balance -= amount;
            System.out.println("Transferência de R$ " + amount + " realizada!");
        } else {
            System.out.println("Saldo insuficiente para transferência (mesmo com cheque especial).");
        }
    }
}
