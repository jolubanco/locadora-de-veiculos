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

    //[*] Adiciona a referencia do objeto veiculo
    public void adicionaVeiculo( Veiculo veiculoCadastrado){
        veiculosCadastrados.add(veiculoCadastrado);
    }

    public ArrayList<Veiculo> getVeiculosCadastrados() {
        return veiculosCadastrados;
    }

    public ArrayList<VeiculoAlugado> getVeiculosAlugados() {
        return veiculosAlugados;
    }

}
