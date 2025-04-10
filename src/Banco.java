import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    // 👉 Construtor com apenas o nome
    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    // 👉 Construtor completo, com lista de contas
    public Banco(String nome, List<Conta> contas) {
        this.nome = nome;
        this.contas = contas;
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }
}
