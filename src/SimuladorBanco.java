import java.util.Arrays;

public class SimuladorBanco {
    public static Banco criarBancoComContas() {
        Cliente c1 = new Cliente("AbN");
        Cliente c2 = new Cliente("Ceguinho");
        Cliente c3 = new Cliente("Juneco");

        Conta cc = new ContaCorrente(c1);
        Conta cp = new ContaPoupanca(c2);
        Conta ci = new ContaInvestimento(c3);

        return new Banco("Banco Flash", Arrays.asList(cc, cp, ci));
    }
}
