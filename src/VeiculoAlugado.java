import java.util.GregorianCalendar;

public class VeiculoAlugado {
    private Veiculo veiculo; //verificar
    private int dataInicio;
    private int dataFinal;
    private Cliente cliente; //verificar
    private static int total;

    public VeiculoAlugado(int dataInicio, int dataFinal){
        total++;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }
}

