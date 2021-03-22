import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.GregorianCalendar;

public abstract class Veiculo {

    private String marca;
    private String placa; //tratar entrada, receber maiusculo e formatado
    private String modelo;
    private int numeroPortas;
    private double valorVeiculo;
    private String cor;
    private int ano;
    private static int totalVeiculos;

    public Veiculo (String marca, String placa, double valorVeiculo){
        totalVeiculos++;
        this.marca = marca;
        this.placa = placa;
        this.valorVeiculo = valorVeiculo;
    }
    //USAR POLIMORFISMO, RECEBENDO UMA CLASSE VEICULO

    public void aluga (int numDiarias, Cliente cliente){
        //melhorar o texto de saida, e salvar a data atual
        //mostrar a data final
        GregorianCalendar data = new GregorianCalendar();
        data.add(Calendar.DAY_OF_MONTH, numDiarias);
        int diafinal = data.get(Calendar.DAY_OF_MONTH);
        //Date dataAdicionada = data.getTime(); apresenta a data ADICIONADA mas sem formatar, verifiar como formatar

        //gambiarra, tentar melhorar
        SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        String strTimeDay = simpleformat.format(new Date());

        double valorAluguelVeiculo = (valorVeiculo*0.001)*(numDiarias);
        System.out.println("O cliente " + cliente.getCpf() + " alugou o carro " + this.getMarca() + " com placa " + this.getPlaca() +
                 " na data e horário: " + strTimeDay + ". Totalizando: R$ " + valorAluguelVeiculo);
    }

//    public void aluga (int diaFinal, int mesFinal, Cliente cliente){
//
//        Calendar c = Calendar.getInstance();
//        Date diaEHoraInicio = c.getTime();
//        int mesInicio = c.get(Calendar.MONTH);
//        int diaInicio = c.get(Calendar.DAY_OF_MONTH);
//
//        //verificar nome da variável
//        //VeiculoAlugado ola = new VeiculoAlugado(this.getPlaca(), dataInicio, dataFinal);
//
//        //corrigir ainda
//        //int totalDias = 0;
//
////        if (mesInicio == mesFinal){
////            totalDias = diaFinal - diaInicio;
////        } else {
////            totalDias =
////        }
//        int totalDias = Math.abs(diaFinal - diaInicio);
//        double valorAluguelVeiculo = valorVeiculo*0.001;
//        double valorAluguelTotal = valorAluguelVeiculo*(totalDias);
//        System.out.println("O cliente " + cliente.getCpf() + " alugou o carro " + this.getMarca() + " com placa " + this.getPlaca() +
//                " do dia " + diaInicio + " até o dia " + diaFinal + " do mês " +
//                mesFinal + ". Totalizando: R$ " + valorAluguelTotal);
//    }

    public static int exibeCarrosDisponiveis(){
        Scanner ler = new Scanner(System.in);
        ArrayList<String> agenda = new ArrayList();
       //otimizar para aparecer os carros cadastrados
        agenda.add("Carro A");
        agenda.add("Carro B");
        agenda.add("Carro C");

        System.out.printf("Escolha um carro para alugar: \n");
        int n = agenda.size();
        for (int i=0; i<n; i++) {
            System.out.printf("%d. %s\n", i+1, agenda.get(i));
        }

        System.out.print("Informe o número: ");
        return ler.nextInt();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public static int getTotalVeiculos() {
        return Veiculo.totalVeiculos;
    }
}
