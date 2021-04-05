package model;

import java.util.Date;

public class VeiculoAlugado {

    private Veiculo veiculo; //verificar
    private Cliente cliente; //verificar
    private Date dataInicio;
    private Date dataFinal;
    private double valorLocacao;
    private boolean statusLocacao;
    private static int total;

    public VeiculoAlugado(Veiculo veiculo, Cliente cliente, Date dataInicio, Date dataFinal, double valorLocacao){
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.valorLocacao = valorLocacao;
        this.statusLocacao = true;
        total++;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public boolean isStatusLocacao() {
        return statusLocacao;
    }

    public void setStatusLocacao(boolean statusLocacao) {
        this.statusLocacao = statusLocacao;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        VeiculoAlugado.total = total;
    }

    @Override
    public String toString() {
        return "VeiculoAlugado: " +
                "Placa do veiculo = " + veiculo.getPlaca() +
                ", Cpf do cliente = " + cliente.getCpf() +
                ", dataInicio = " + dataInicio +
                ", dataFinal = " + dataFinal +
                ", valorLocacao = " + valorLocacao +
                ", statusLocacao = " + statusLocacao;
    }

    //DESTA FORMA, ESTA CHAMANDO TODOS OS ATRIBUTOS DO OBJETO VEICULO E TODOS DO OBJETO CLIENTE. INTERESSANTE, MAS MUITO EXTENSO
//    @Override
//    public String toString() {
//        return "VeiculoAlugado: " +
//                "veiculo = " + veiculo +
//                ", cliente = " + cliente +
//                ", dataInicio = " + dataInicio +
//                ", dataFinal = " + dataFinal +
//                ", valorLocacao = " + valorLocacao +
//                ", statusLocacao = " + statusLocacao;
//    }
}

