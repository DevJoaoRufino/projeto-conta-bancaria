public abstract class Conta {
    protected String agencia;
    protected String numero;
    protected String titular;
    protected double saldo;

    public Conta(String agencia, String numero, String titular, double saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String consultarSaldo() {
        return "Saldo atual: R$ " + String.format("%.2f", saldo);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public abstract void sacar(double valor);
    public abstract void transferir(double valor);
}
