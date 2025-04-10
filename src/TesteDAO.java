import java.util.List;

public class TesteDAO {
    public static void main(String[] args) {
        ContaDAO dao = new ContaDAO();

        // Criar cliente e conta teste
        Cliente cliente = new Cliente("Abner Leandro");
        ContaCorrente conta = new ContaCorrente(cliente);
        conta.depositar(500);

        // Salvar no banco
        dao.salvar(conta);

        // Listar do banco
        List<Conta> contas = dao.listarTodos();
        for (Conta c : contas) {
            System.out.println("Cliente: " + c.getNomeCliente());
            System.out.println("Tipo: " + c.getTipoConta());
            System.out.println("Saldo: R$ " + c.getSaldo());
            System.out.println("------");
        }
    }
}
