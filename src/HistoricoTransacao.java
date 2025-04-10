import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoricoTransacao {
    private String tipo;
    private double valor;
    private LocalDateTime dataHora;

    public HistoricoTransacao(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getDataHoraFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataHora.format(formatter);
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
