import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {
    private Connection conexao;

    public TransacaoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void salvar(int contaId, Transacao t) throws SQLException {
        String sql = "INSERT INTO transacoes (conta_id, tipo, valor, data_hora) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, contaId);
            stmt.setString(2, t.getTipo());
            stmt.setDouble(3, t.getValor());
            stmt.setString(4, t.getDataHora().toString());
            stmt.executeUpdate();
        }
    }

    public List<Transacao> buscarPorConta(int contaId) throws SQLException {
        List<Transacao> transacoes = new ArrayList<>();
        String sql = "SELECT * FROM transacoes WHERE conta_id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, contaId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                transacoes.add(new Transacao(
                    rs.getString("tipo"),
                    rs.getDouble("valor"),
                    LocalDateTime.parse(rs.getString("data_hora"))
                ));
            }
        }
        return transacoes;
    }
}
