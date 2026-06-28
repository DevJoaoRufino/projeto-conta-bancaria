package com.bankaccount.accounts;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

System.out.println("Bem-vindo ao Banco JF");
        System.out.print("Digite o tipo da conta (corrente/poupanca): ");
        String type = scanner.nextLine().toLowerCase();

        Account account = null;

        if (type.equals("corrente")) {
            account = createCheckingAccount(scanner);
        } else if (type.equals("poupanca")) {
            account = createSavingsAccount(scanner);
        } else {
            System.out.println("Tipo de conta inválido.");
        }

        if (account != null) {
            runMenu(scanner, account);
        }

        scanner.close();
    }

    // Método para criar conta corrente
    private static CheckingAccount createCheckingAccount(Scanner scanner) {
        System.out.print("Agência: ");
        String agency = scanner.nextLine();
        System.out.print("Número da conta: ");
        String number = scanner.nextLine();
        System.out.print("Titular: ");
        String holder  = scanner.nextLine();
        System.out.print("Saldo inicial: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // consome o Enter
        System.out.print("Cheque especial: ");
        double overdraft = scanner.nextDouble();
        scanner.nextLine(); // consome o Enter

        return new CheckingAccount(agency, number, holder, balance, overdraft);
    }

    // Método para criar conta poupança
    private static SavingsAccount createSavingsAccount(Scanner scanner) {
        System.out.print("Agência: ");
        String agency = scanner.nextLine();
        System.out.print("Número da conta: ");
        String number = scanner.nextLine();
        System.out.print("Titular: ");
        String holder = scanner.nextLine();
        System.out.print("Saldo inicial: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // consome o Enter
        System.out.print("Taxa de rendimento (ex: 0.05 para 5%): ");
        double interestRate = scanner.nextDouble();
        scanner.nextLine(); // consome o Enter

        return new SavingsAccount(agency, number, holder, balance, interestRate);
    }

    // Método para executar o menu
    private static void runMenu(Scanner scanner, Account account) {
        int option;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            if (account instanceof SavingsAccount) {
                System.out.println("5 - Aplicar Rendimento");
            }
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println(account.checkBalance());
                    break;
                case 2:
                    System.out.print("Valor do depósito: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Valor do saque: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.print("Valor da transferência: ");
                    double transferAmount = scanner.nextDouble();
                    account.transfer(transferAmount);
                    break;
                case 5:
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).applyInterest();
                    }
                    break;
                case 0:
                    System.out.println("Encerrando aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);
    }
}
