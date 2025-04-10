import java.sql.Connection;
import java.sql.Statement;

public class CriarTabela {

    public static void criar() {
        String sql = """
            CREATE TABLE IF NOT EXISTS contas (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                titular TEXT NOT NULL,
                tipo TEXT NOT NULL,
                saldo REAL NOT NULL
            );
        """;

        try (Connection conn = Conexao.conectar(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
