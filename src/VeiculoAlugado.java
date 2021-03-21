public class VeiculoAlugado {
    private String placa;
    private int dataInicio;
    private int dataFinal;
    private int cpfCliente;
    private static int total;

    public VeiculoAlugado(String placa, int dataInicio, int dataFinal){
        total++;
        this.placa = placa;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    public String getPlaca() {
        return placa;
    }
}
