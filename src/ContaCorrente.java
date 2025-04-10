public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.saldo = 1500.0;
    }

    @Override
    public String getTipoConta() {
        return "Corrente";
    }
}
	