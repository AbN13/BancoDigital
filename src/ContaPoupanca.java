public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        this.saldo = 3000.0;
    }

    @Override
    public String getTipoConta() {
        return "Poupança";
    }
}
