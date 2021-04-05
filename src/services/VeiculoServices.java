package services;
import model.Cliente;
import model.Veiculo;
import model.VeiculoAlugado;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class VeiculoServices {

    //[*] Atributos
    public ArrayList<VeiculoAlugado> veiculosAlugados = new ArrayList();
    public ArrayList<Veiculo> veiculosCadastrados = new ArrayList();
    //verificar se arquivoVeiculosAlugados vai ficar como atributo ou nao
    private FileWriter arquivoVeiculosAlugados = new FileWriter("C:\\Users\\jolub\\IdeaProjects\\locadora-carros\\veiculosAlugados.txt", true);

    public VeiculoServices() throws IOException {
    }

    public VeiculoAlugado alugaVeiculo(int numDiarias, Cliente cliente, Veiculo veiculo) throws IOException {

        GregorianCalendar data = new GregorianCalendar();
        Date dataInicio = data.getTime();
        data.add(Calendar.DAY_OF_MONTH, numDiarias);
        //int diaFinal = data.get(Calendar.DAY_OF_MONTH);
        Date dataFinal = data.getTime();

        double valorAluguelVeiculo = (veiculo.getValorVeiculo()*0.002)*(numDiarias);

        System.out.println("Veículo alugado com sucesso! O valor total ficou em R$" + valorAluguelVeiculo
        + " e a data prevista de devolução é: " + dataFinal);
        //formatar a data de saida, para portugues pelo menos!

        return new VeiculoAlugado(veiculo,cliente,dataInicio,dataFinal,valorAluguelVeiculo);
    }

    public void adicionaVeiculoAlugado( VeiculoAlugado veiculoAlugado) throws IOException {

        //GRAVANDO DADOS EM ARQUIVO TXT

        //FileWriter arquivo = new FileWriter("C:\\Users\\jolub\\IdeaProjects\\locadora-carros\\veiculosAlugados.txt");
        PrintWriter gravaArquivo = new PrintWriter(arquivoVeiculosAlugados);

        gravaArquivo.print(veiculoAlugado + "\r\n");

        arquivoVeiculosAlugados.close();

        //GRAVANDO DADOS EM ARQUIVO TXT
    }

    //criar uma excessão quando a lista de veiculos alugados estiver vazia!!!
    public void exibeVeiculosAlugados() throws IOException {
        //[*] abrindo o arquivo, se não existir ele cria um novo arquivo
        FileReader arquivo = new FileReader("C:\\Users\\jolub\\IdeaProjects\\locadora-carros\\veiculosAlugados.txt");

        //[*] lendo o arquivo
        BufferedReader lerArquivo = new BufferedReader(arquivo);

        //[*] lê a primeira linha. A variável "linha" recebe o valor "null" quando o processo
        //[*] de repetição atingir o final do arquivo texto
        String linha = lerArquivo.readLine();

        while(linha != null){
            System.out.printf("%s\n",linha);
            linha = lerArquivo.readLine(); //[*] lê da segunda até a última linha
        }

        //[*] fechando o arquivo
        arquivo.close();
    }

//    //falta corrigir alguns detalhes
//    public void alugaVeiculo(int numDiarias, Cliente cliente, Veiculo veiculo){
//        //salvar a data atual
//        //mostrar a data final
//
//        //[*] calcula a data final de locação com base no numero de diárias
//        GregorianCalendar data = new GregorianCalendar();
//        data.add(Calendar.DAY_OF_MONTH, numDiarias);
//        int diaFinal = data.get(Calendar.DAY_OF_MONTH);
//
//        //Date dataAdicionada = data.getTime(); apresenta a data ADICIONADA mas sem formatar, verifiar como formatar
//
//        //[*] seleciona a data e horario do dia de locação, formatando da maneira que queremos
//        SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
//        String strTimeDay = simpleformat.format(new Date());
//
//        double valorAluguelVeiculo = (veiculo.getValorVeiculo()*0.001)*(numDiarias);
//
//        System.out.println("Veículo alugado com sucesso! O valor total ficou em R$" + valorAluguelVeiculo);
//
//        //melhorar os dados que serão salvos, como a data
//        ArrayList lista = new ArrayList();
//        lista.add("Valor: " + valorAluguelVeiculo);
//        lista.add("Cpf: " + cliente.getCpf());
//        lista.add("Marca: " + veiculo.getMarca());
//        lista.add("Placa: " + veiculo.getPlaca());
//        lista.add("Data Final: " + data.get(Calendar.DATE));
//
//        veiculosAlugados.add(lista);
//    }

    //REVER, FAZER IGUAL O getVeiculosCadastrados COM MÉTODO toString()
//    public void getVeiculosAlugados() {
//        for(int i = 0; i < veiculosAlugados.size(); i++){
//            System.out.println(veiculosAlugados.get(i));
//        }
//    }

    //[*] Adiciona a referencia do objeto veiculo
    public void adicionaVeiculo( Veiculo veiculoCadastrado){
        veiculosCadastrados.add(veiculoCadastrado);
//        System.out.println("Veiculo adicionado ao banco de dados com sucesso");
    }

    public ArrayList<Veiculo> getVeiculosCadastrados() {
        return veiculosCadastrados;
    }

    public ArrayList<VeiculoAlugado> getVeiculosAlugados() {
        return veiculosAlugados;
    }

}
