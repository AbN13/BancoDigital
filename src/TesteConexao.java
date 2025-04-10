import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TesteConexao {
    public static void main(String[] args) {
        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table';");

            System.out.println("Tabelas encontradas:");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
