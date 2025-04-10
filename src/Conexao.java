import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:sqlite:C:/Users/Abner-leandro/Desktop/banco.db";

    public static Connection conectar() throws SQLException {
        System.out.println("🟢 Conectando ao banco em: " + URL);
        return DriverManager.getConnection(URL);
    }
}
