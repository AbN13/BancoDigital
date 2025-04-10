import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        ContaDAO dao = new ContaDAO();
        Banco banco = new Banco("Banco Digital"); // Agora sem contas direto

        // 👉 Carregando contas do banco de dados
        for (Conta conta : dao.listarTodos()) {
            banco.adicionarConta(conta);
        }

        TabelaFactory tabelaFactory = new TabelaFactory(banco);
        tabelaFactory.mostrarTabela(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
