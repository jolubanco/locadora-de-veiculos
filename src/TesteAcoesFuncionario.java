
import model.Carro;
import services.FuncionarioServices;
import services.VeiculoServices;
import java.util.Scanner;

public class TesteAcoesFuncionario {

    public static void main(String[] args) {

        while (true) {
            acoesFuncionario();
    }

}

public static void acoesFuncionario(){
    Scanner leitor = new Scanner(System.in);
    //[*] Exibe as opções de ações do funcionário
    int opcaoAcaoFuncionario = FuncionarioServices.exibeAcoesFuncionario();

    VeiculoServices veiculoServices = new VeiculoServices();

    //APENAS PARA TESTE
    Carro veiculoteste1 = new Carro("Peugeot", "ABCD-1010", 15000);
    Carro veiculoteste2 = new Carro("Ford", "EFGH-0101", 30000);
    veiculoServices.adicionaVeiculo(veiculoteste1);
    veiculoServices.adicionaVeiculo(veiculoteste2);

    switch (opcaoAcaoFuncionario) {

        case 1:
            System.out.println("Forneça as seguitnes informações");
            System.out.print("Marca: ");
            String marca = leitor.next();
            System.out.print("Placa: ");
            String placa = leitor.next();
            System.out.print("Valor: ");
            double valor = leitor.nextDouble();

            veiculoServices.adicionaVeiculo(new Carro(marca,placa,valor));
            System.out.println(veiculoServices.getVeiculosCadastrados());
            //veiculo só é adicionado em tempo de execução, quando passa para o proximo case ele some
            break;

        case 2:
//                    VeiculoServices veiculoServices = new VeiculoServices();
            //EXIBIR LISTA DE CLIENTES
            //EXIBIR LISTA DE VEICULOS CADASTRADOS


            System.out.println("Forneça as seguitnes informações ");
            System.out.print("Número Diarias: ");
            int numeroDiarias = leitor.nextInt();
            System.out.print("Cliente: ");
            String cpfCliente = leitor.next();
            System.out.print("Veiculo: ");
            String placaVeiculo = leitor.next();
//                    veiculoServices.alugaVeiculo(numeroDiarias,);
            break;

        case 3:
            System.out.println(veiculoServices.getVeiculosCadastrados());
            System.out.print("Escolha a posição de um veículo (começando do 0): ");
            int posicaoVeiculo = leitor.nextInt();

            int opcaoAtualizacao = FuncionarioServices.exibeListaAtualizacaoVeiculo();

            switch (opcaoAtualizacao){
                case 1:
                    System.out.print("Insira a marca atualizada: ");
                    String marcaAtualizada = leitor.next();
                    veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setMarca(marcaAtualizada);
                    System.out.println("Atualização realizada com sucesso!");
                    break;
                case 2:
                    System.out.print("Insira a placa atualizada: ");
                    String placaAtualizada = leitor.next();
                    veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setPlaca(placaAtualizada);
                    System.out.println("Atualização realizada com sucesso!");
                    break;
                case 3:
                    System.out.print("Insira o modelo atualizado: ");
                    String modeloAtualizada = leitor.next();
                    veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setModelo(modeloAtualizada);
                    System.out.println("Atualização realizada com sucesso!");
                    break;
                case 4:
                    System.out.print("Insira o valor atualizado: ");
                    double valorAtualizada = leitor.nextDouble();
                    veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setValorVeiculo(valorAtualizada);
                    System.out.println("Atualização realizada com sucesso!");
                    break;
                case 5:
                    System.out.print("Insira a cor atualizada: ");
                    String corAtualizada = leitor.next();
                    veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setCor(corAtualizada);
                    System.out.println("Atualização realizada com sucesso!");
                    break;
                case 6:
                    System.out.print("Insira o ano atualizado: ");
                    int anoAtualizada = leitor.nextInt();
                    veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setAno(anoAtualizada);
                    System.out.println("Atualização realizada com sucesso!");
                    break;
                case 7:
                    System.out.print("Insira numero de portas atualizado: ");
                    int numPortaAtualizada = leitor.nextInt();
                    veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setNumeroPortas(numPortaAtualizada);
                    System.out.println("Atualização realizada com sucesso!");
                    break;

            }
    }
}
}


