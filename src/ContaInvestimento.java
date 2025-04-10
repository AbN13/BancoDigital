public class ContaInvestimento extends Conta {
    public ContaInvestimento(Cliente cliente) {
        super(cliente);
        this.saldo = 8000.0;
    }

    @Override
    public String getTipoConta() {
        return "Investimento";
    }
}
