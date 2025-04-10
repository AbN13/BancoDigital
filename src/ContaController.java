import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;

public class ContaController {

    @SuppressWarnings("unchecked") // Remove o aviso de segurança de tipos
    public void exibirContas(Stage stage, Banco banco) {
        TableView<Conta> tabela = new TableView<>();

        TableColumn<Conta, String> colunaTitular = new TableColumn<>("Titular");
        colunaTitular.setCellValueFactory(data ->
            new SimpleStringProperty(data.getValue().getNomeCliente())
        );

        TableColumn<Conta, String> colunaTipo = new TableColumn<>("Tipo");
        colunaTipo.setCellValueFactory(data ->
            new SimpleStringProperty(data.getValue().getClass().getSimpleName())
        );

        TableColumn<Conta, String> colunaSaldo = new TableColumn<>("Saldo");
        colunaSaldo.setCellValueFactory(data ->
            new SimpleStringProperty(String.format("R$ %.2f", data.getValue().getSaldo()))
        );

        tabela.getColumns().addAll(colunaTitular, colunaTipo, colunaSaldo);
        tabela.setItems(FXCollections.observableArrayList(banco.getContas()));

        VBox layout = new VBox(tabela);
        Scene cena = new Scene(layout, 500, 400);
        stage.setScene(cena);
        stage.setTitle("Contas Bancárias");
        stage.show();
    }
}
