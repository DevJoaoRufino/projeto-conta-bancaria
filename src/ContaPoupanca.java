package com.bankaccount.accounts;
public class ContaPoupanca extends Account {
    private double taxaRendimento;

    public ContaPoupanca(String agencia, String numero, String titular, double saldo, double taxaRendimento) {
        super(agencia, numero, titular, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void transferir(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Transferência de R$ " + valor + " realizada!");
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    public void aplicarRendimento() {
        double rendimento = saldo * taxaRendimento;
        saldo += rendimento;
        System.out.println("Rendimento aplicado: R$ " + rendimento + ". Saldo atualizado: R$ " + saldo);
    }
}
