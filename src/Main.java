import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Banco J");
        System.out.print("Digite o tipo da conta (corrente/poupanca): ");
        String tipo = scanner.nextLine().toLowerCase();

        Conta conta = null;

        if (tipo.equals("corrente")) {
            conta = criarContaCorrente(scanner);
        } else if (tipo.equals("poupanca")) {
            conta = criarContaPoupanca(scanner);
        } else {
            System.out.println("Tipo de conta inválido.");
        }

        if (conta != null) {
            executarMenu(scanner, conta);
        }

        scanner.close();
    }

    // Método para criar conta corrente
    private static ContaCorrente criarContaCorrente(Scanner scanner) {
        System.out.print("Agência: ");
        String agencia = scanner.nextLine();
        System.out.print("Número da conta: ");
        String numero = scanner.nextLine();
        System.out.print("Titular: ");
        String titular = scanner.nextLine();
        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine(); // consome o Enter
        System.out.print("Cheque especial: ");
        double chequeEspecial = scanner.nextDouble();
        scanner.nextLine(); // consome o Enter

        return new ContaCorrente(agencia, numero, titular, saldo, chequeEspecial);
    }

    // Método para criar conta poupança
    private static ContaPoupanca criarContaPoupanca(Scanner scanner) {
        System.out.print("Agência: ");
        String agencia = scanner.nextLine();
        System.out.print("Número da conta: ");
        String numero = scanner.nextLine();
        System.out.print("Titular: ");
        String titular = scanner.nextLine();
        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine(); // consome o Enter
        System.out.print("Taxa de rendimento (ex: 0.05 para 5%): ");
        double taxa = scanner.nextDouble();
        scanner.nextLine(); // consome o Enter

        return new ContaPoupanca(agencia, numero, titular, saldo, taxa);
    }

    // Método para executar o menu
    private static void executarMenu(Scanner scanner, Conta conta) {
        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            if (conta instanceof ContaPoupanca) {
                System.out.println("5 - Aplicar Rendimento");
            }
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(conta.consultarSaldo());
                    break;
                case 2:
                    System.out.print("Valor do depósito: ");
                    double dep = scanner.nextDouble();
                    conta.depositar(dep);
                    break;
                case 3:
                    System.out.print("Valor do saque: ");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;
                case 4:
                    System.out.print("Valor da transferência: ");
                    double transf = scanner.nextDouble();
                    conta.transferir(transf);
                    break;
                case 5:
                    if (conta instanceof ContaPoupanca) {
                        ((ContaPoupanca) conta).aplicarRendimento();
                    }
                    break;
                case 0:
                    System.out.println("Encerrando aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
