import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

@SuppressWarnings("unchecked") // Remove o aviso do varargs ao adicionar colunas
public class TabelaFactory {

    private Banco banco;

    public TabelaFactory(Banco banco) {
        this.banco = banco;
    }

    public void mostrarTabela(Stage stage) {
        TableView<Conta> tabela = new TableView<>();

        TableColumn<Conta, String> colunaTitular = new TableColumn<>("Titular");
        colunaTitular.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));

        TableColumn<Conta, String> colunaTipo = new TableColumn<>("Tipo");
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipoConta"));

        TableColumn<Conta, Double> colunaSaldo = new TableColumn<>("Saldo");
        colunaSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));

        tabela.getColumns().addAll(colunaTitular, colunaTipo, colunaSaldo);
        tabela.setItems(FXCollections.observableArrayList(banco.getContas()));

        Label titulo = new Label("Contas do " + banco.getNome());
        titulo.setFont(new Font("Helvetica Neue", 24));

        BorderPane layout = new BorderPane();
        layout.setTop(titulo);
        BorderPane.setMargin(titulo, new Insets(20));
        layout.setCenter(tabela);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #F5F5F7;");

        Scene scene = new Scene(layout, 600, 400);
        scene.getStylesheets().add("estilo.css");

        stage.setTitle("Banco Digital");
        stage.setScene(scene);
        stage.show();
    }
}
