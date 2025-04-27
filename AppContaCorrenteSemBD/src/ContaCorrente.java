public class ContaCorrente {
    private String titular;
    private int numeroConta;
    private double saldo;

    public ContaCorrente(String titular, int numeroConta) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getDadosConta() {
        return "Titular: " + titular +
               "\nNúmero da Conta: " + numeroConta +
               "\nSaldo atual: R$ " + String.format("%.2f", saldo);
    }
}
