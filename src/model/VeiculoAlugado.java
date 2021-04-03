package model;

public class VeiculoAlugado {

    private String placaVeiculo; //verificar
    private String dataInicio;
    private String dataFinal;
    private String cpfCliente; //verificar
    private boolean statusLocacao;
    private static int total;

    public VeiculoAlugado(String placaVeiculo, String cpfCliente, String dataInicio, String dataFinal, boolean statusLocacao){
        this.placaVeiculo = placaVeiculo;
        this.cpfCliente = cpfCliente;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.statusLocacao = statusLocacao;
        total++;
        System.out.println("Veiculo Alugado!");
    }
}

