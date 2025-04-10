import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    protected Cliente cliente;
    protected double saldo;
    protected int id;
    protected List<Transacao> historico = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        saldo += valor;
        historico.add(new Transacao("Depósito", valor, LocalDateTime.now()));
    }

    public void sacar(double valor) {
        saldo -= valor;
        historico.add(new Transacao("Saque", valor, LocalDateTime.now()));
    }

    public void definirSaldo(double valor) {
        this.saldo = valor;
    }

    public List<Transacao> getHistorico() {
        return historico;
    }

    public String getNomeCliente() {
        return cliente.getNome();
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract String getTipoConta();
}
