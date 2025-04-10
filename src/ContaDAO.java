import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    private static final String URL = "jdbc:sqlite:C:/Users/Abner-leandro/Desktop/banco.db";

    public void salvar(Conta conta) {
        try (Connection conn = DriverManager.getConnection(URL)) {
            String sql = "INSERT INTO contas (titular, tipo, saldo) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, conta.getNomeCliente());
            stmt.setString(2, conta.getTipoConta());
            stmt.setDouble(3, conta.getSaldo());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Conta> listarTodos() {
        List<Conta> contas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL)) {
            String sql = "SELECT * FROM contas";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String nome = rs.getString("titular");
                String tipo = rs.getString("tipo");
                double saldo = rs.getDouble("saldo");

                Cliente cliente = new Cliente(nome);
                Conta conta;

                switch (tipo) {
                    case "Corrente":
                        conta = new ContaCorrente(cliente);
                        break;
                    case "Poupança":
                        conta = new ContaPoupanca(cliente);
                        break;
                    case "Investimento":
                        conta = new ContaInvestimento(cliente);
                        break;
                    default:
                        continue;
                }

                conta.definirSaldo(saldo); // 👈 agora não usa depositar
                contas.add(conta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return contas;
    }
}
