package com.bankaccount.accounts;
public class ContaCorrente extends Account {
    private double chequeEspecial;

    public ContaCorrente(String agencia, String numero, String titular, double saldo, double chequeEspecial) {
        super(agencia, numero, titular, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo + chequeEspecial) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente (mesmo com cheque especial).");
        }
    }

    @Override
    public void transferir(double valor) {
        if (valor <= saldo + chequeEspecial) {
            saldo -= valor;
            System.out.println("Transferência de R$ " + valor + " realizada!");
        } else {
            System.out.println("Saldo insuficiente para transferência (mesmo com cheque especial).");
        }
    }
}
