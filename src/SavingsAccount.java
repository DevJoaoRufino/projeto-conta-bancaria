package com.bankaccount.accounts;
public class SavingsAccount extends Account {
    private double savingsRate;

    public SavingsAccount(String agency, String number, String holder, double balance, double savingsRate) {
        super(agency, number, holder, balance);
        this.savingsRate = savingsRate;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Saque de R$ " + amount + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void transfer(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Transferência de R$ " + amount + " realizada!");
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    public void applyInterest() {
        double interest = balance * savingsRate;
        balance += interest;
        System.out.println("Rendimento aplicado: R$ " + interest + ". Saldo atualizado: R$ " + balance);
    }
}
