
import model.*;
import services.ClienteServices;
import services.FuncionarioServices;
import services.VeiculoServices;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TesteAcoesFuncionario {

    public static void main(String[] args) throws IOException {

        //PRÉ-DEFINICOES
        VeiculoServices veiculoServices = new VeiculoServices();
        ClienteServices clienteServices = new ClienteServices();
        Funcionario funcionario = new Funcionario();
        funcionario.setSenha(2021);
        //CRIANDO O ARQUIVO PARA SALVAR OS VEICULOS ALUGADOS
        //FileWriter arquivo = new FileWriter("C:\\Users\\jolub\\IdeaProjects\\locadora-carros\\veiculosAlugados.txt");
        //
        boolean condicao = true;

        while(true){
        //Por enquanto apenas para um funcionário
        Scanner leitorSenhaFuncionario = new Scanner(System.in);
        System.out.print("Informe sua senha: ");
        int senhaSolicitada = leitorSenhaFuncionario.nextInt();

            if (funcionario.autentica(senhaSolicitada)){
                condicao = true;
                while (condicao) {
                    Scanner leitor = new Scanner(System.in);
                    //[*] Exibe as opções de ações do funcionário
                    int opcaoAcaoFuncionario = FuncionarioServices.exibeAcoesFuncionario();

                    //APENAS PARA TESTE
//            Carro veiculoteste1 = new Carro("Peugeot", "ABCD-1010", 15000);
//            Carro veiculoteste2 = new Carro("Ford", "EFGH-0101", 30000);
//            veiculoServices.adicionaVeiculo(veiculoteste1);
//            veiculoServices.adicionaVeiculo(veiculoteste2);

                    switch (opcaoAcaoFuncionario) {
                        case 1:
                            System.out.println("Forneça as seguitnes informações");
                            System.out.print("Marca: ");
                            String marca = leitor.nextLine();
                            System.out.print("Placa: ");
                            String placa = leitor.nextLine();
                            System.out.print("Valor: ");
                            double valor = leitor.nextDouble();

                            //realizar uma verificacao para qual tipo de veiculo sera cadastrado
                            veiculoServices.adicionaVeiculo(new Carro(marca,placa,valor));
                            System.out.println("Veículo cadastrado com sucesso!");
                            //provisorio, apenas para verificar que foi feita o cadastro
                            //veiculoServices.getVeiculosCadastrados().stream().forEach(veiculo -> System.out.println(veiculo.toString()));
                            break;
                        case 2:
                            veiculoServices.getVeiculosCadastrados().stream().forEach(vec -> System.out.println(vec.toString()));
                            System.out.print("Escolha a posição de um veículo (começando do 0): ");
                            int posicaoVeiculo = leitor.nextInt();

                            int opcaoAtualizacao = FuncionarioServices.exibeListaAtualizacaoVeiculo();

                            switch (opcaoAtualizacao){
                                case 1:
                                    System.out.print("Insira a marca atualizada: ");
                                    String marcaAtualizada = leitor.nextLine();
                                    veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setMarca(marcaAtualizada);
                                    System.out.println("Atualização realizada com sucesso!");
                                    break;
                                case 2:
                                    System.out.print("Insira a placa atualizada: ");
                                    String placaAtualizada = leitor.nextLine();
                                    veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setPlaca(placaAtualizada);
                                    System.out.println("Atualização realizada com sucesso!");
                                    break;
                                case 3:
                                    System.out.print("Insira o modelo atualizado: ");
                                    String modeloAtualizada = leitor.nextLine();
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
                                    String corAtualizada = leitor.nextLine();
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
                            break;
                        case 3:
                            if (veiculoServices.getVeiculosCadastrados().size() != 0){
                                System.out.println("Numero de veiculos cadastrados: " + veiculoServices.getVeiculosCadastrados().size());
                                veiculoServices.getVeiculosCadastrados().stream().forEach(vec -> System.out.println(vec.toString()));
                            } else {
                                System.out.println("Lista vazia. Cadastre um veículo!");
                            }
                            break;
                        case 4:
                            System.out.println("Forneça as seguintes informações");
                            System.out.print("Cpf: ");
                            String cpf = leitor.nextLine();

                            clienteServices.adicionaCliente(new Cliente(cpf));
                            System.out.println("Cliente cadastrado com sucesso!");
                            //provisorio, apenas para verificar que foi feita o cadastro
                            //clienteServices.getClientesCadastrados().stream().forEach(cli -> System.out.println(cli.toString()));
                            break;
                        case 5:
                            clienteServices.getClientesCadastrados().stream().forEach(cli -> System.out.println(cli.toString()));
                            System.out.print("Escolha a posição de um cliente (começando do 0): ");
                            int posicaoClienteAtualizar = leitor.nextInt();

                            int opcaoAtualizacaoCliente = FuncionarioServices.exibeListaAtualizacaoCliente();

                            switch (opcaoAtualizacaoCliente){
                                case 1:
                                    System.out.print("Insira o nome atualizado: ");
                                    String nomeAtualizado = leitor.nextLine();
                                    clienteServices.getClientesCadastrados().get(posicaoClienteAtualizar).setNome(nomeAtualizado);
                                    System.out.println("Atualização realizada com sucesso!");
                                    break;
                                case 2:
                                    System.out.print("Insira o cpf atualizado: ");
                                    String cpfAtualizado = leitor.nextLine();
                                    clienteServices.getClientesCadastrados().get(posicaoClienteAtualizar).setCpf(cpfAtualizado);
                                    System.out.println("Atualização realizada com sucesso!");
                                    break;
                            }
                            break;
                        case 6:
                            if (clienteServices.getClientesCadastrados().size() != 0){
                                System.out.println("Numero de clientes cadastrados: " + clienteServices.getClientesCadastrados().size());
                                clienteServices.getClientesCadastrados().stream().forEach(cli -> System.out.println(cli.toString()));
                            } else {
                                System.out.println("Lista vazia. Cadastre um cliente!");
                            }
                            break;
                        case 7:
                                    //TESTE
        //                    Cliente cliente1 = new Cliente("08326702943");
        //                    Cliente cliente2 = new Cliente("10202150255");
        //                    Carro carroTeste1 = new Carro("ford","ABCD-1212",1000);
        //                    Carro carroTeste2 = new Carro("renout","ASDA-1003",2000);
        //                    veiculoServices.adicionaVeiculo(carroTeste1);
        //                    veiculoServices.adicionaVeiculo(carroTeste2);
        //                    clienteServices.adicionaCliente(cliente1);
        //                    clienteServices.adicionaCliente(cliente2);

                            clienteServices.getClientesCadastrados().stream().forEach(cliente -> System.out.println(cliente.toString()));
                            System.out.print("Escolha o cliente (posição): ");
                            int posicaoCliente = leitor.nextInt();

                            veiculoServices.getVeiculosCadastrados().stream().forEach(veiculo -> System.out.println(veiculo.toString()));
                            System.out.print("Escolha o veículo (posição): ");
                            int posicaoVeiculoAlugar = leitor.nextInt();

                            System.out.print("Número Diarias: ");
                            int numeroDiarias = leitor.nextInt();

                            Cliente cliente = clienteServices.getClientesCadastrados().get(posicaoCliente);
                            Veiculo veiculo = veiculoServices.getVeiculosCadastrados().get(posicaoVeiculoAlugar);
                            VeiculoAlugado veiculoAlugado = veiculoServices.alugaVeiculo(numeroDiarias,cliente,veiculo);
                            veiculoServices.adicionaVeiculoAlugado(veiculoAlugado);
                            break;
                        case 8:
                            veiculoServices.exibeVeiculosAlugados();

//                            if (veiculoServices.getVeiculosAlugados().size() != 0){
//                                System.out.println("Numero de veiculos alugados: " + veiculoServices.getVeiculosAlugados().size());
//                                veiculoServices.getVeiculosAlugados().stream().forEach(vecAlug -> System.out.println(vecAlug.toString()));
//                            } else {
//                                System.out.println("Lista vazia. Alugue um veículo!");
//                            }
                            break;
                        case 9:
                            System.out.println("Saindo do Sistema!\n" +
                                    "x-------------------------x");
                            condicao = false;
                            break;
                    }
                }
            } else {
                System.out.println("Acesso Negado! Apenas para Funcionários.");
            }
        }


}

//public static void acoesFuncionario(){
//    Scanner leitor = new Scanner(System.in);
//    //[*] Exibe as opções de ações do funcionário
//    int opcaoAcaoFuncionario = FuncionarioServices.exibeAcoesFuncionario();
//
//    //APENAS PARA TESTE
//    Carro veiculoteste1 = new Carro("Peugeot", "ABCD-1010", 15000);
//    Carro veiculoteste2 = new Carro("Ford", "EFGH-0101", 30000);
//    veiculoServices.adicionaVeiculo(veiculoteste1);
//    veiculoServices.adicionaVeiculo(veiculoteste2);
//
//    switch (opcaoAcaoFuncionario) {
//
//        case 1:
//            System.out.println("Forneça as seguitnes informações");
//            System.out.print("Marca: ");
//            String marca = leitor.next();
//            System.out.print("Placa: ");
//            String placa = leitor.next();
//            System.out.print("Valor: ");
//            double valor = leitor.nextDouble();
//
//            veiculoServices.adicionaVeiculo(new Carro(marca,placa,valor));
//            veiculoServices.getVeiculosCadastrados().stream().forEach(veiculo -> System.out.println(veiculo.toString()));
//            //veiculo só é adicionado em tempo de execução, quando passa para o proximo case ele some
//            break;
//
//        case 2:
////                    VeiculoServices veiculoServices = new VeiculoServices();
//            //EXIBIR LISTA DE CLIENTES
//            //EXIBIR LISTA DE VEICULOS CADASTRADOS
//
//
//            System.out.println("Forneça as seguitnes informações ");
//            System.out.print("Número Diarias: ");
//            int numeroDiarias = leitor.nextInt();
//            System.out.print("Cliente: ");
//            String cpfCliente = leitor.next();
//            System.out.print("Veiculo: ");
//            String placaVeiculo = leitor.next();
////                    veiculoServices.alugaVeiculo(numeroDiarias,);
//            break;
//
//        case 3:
//            veiculoServices.getVeiculosCadastrados().stream().forEach(veiculo -> System.out.println(veiculo.toString()));
//            System.out.print("Escolha a posição de um veículo (começando do 0): ");
//            int posicaoVeiculo = leitor.nextInt();
//
//            int opcaoAtualizacao = FuncionarioServices.exibeListaAtualizacaoVeiculo();
//
//            switch (opcaoAtualizacao){
//                case 1:
//                    System.out.print("Insira a marca atualizada: ");
//                    String marcaAtualizada = leitor.next();
//                    veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setMarca(marcaAtualizada);
//                    System.out.println("Atualização realizada com sucesso!");
//                    break;
//                case 2:
//                    System.out.print("Insira a placa atualizada: ");
//                    String placaAtualizada = leitor.next();
//                    veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setPlaca(placaAtualizada);
//                    System.out.println("Atualização realizada com sucesso!");
//                    break;
//                case 3:
//                    System.out.print("Insira o modelo atualizado: ");
//                    String modeloAtualizada = leitor.next();
//                    veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setModelo(modeloAtualizada);
//                    System.out.println("Atualização realizada com sucesso!");
//                    break;
//                case 4:
//                    System.out.print("Insira o valor atualizado: ");
//                    double valorAtualizada = leitor.nextDouble();
//                    veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setValorVeiculo(valorAtualizada);
//                    System.out.println("Atualização realizada com sucesso!");
//                    break;
//                case 5:
//                    System.out.print("Insira a cor atualizada: ");
//                    String corAtualizada = leitor.next();
//                    veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setCor(corAtualizada);
//                    System.out.println("Atualização realizada com sucesso!");
//                    break;
//                case 6:
//                    System.out.print("Insira o ano atualizado: ");
//                    int anoAtualizada = leitor.nextInt();
//                    veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setAno(anoAtualizada);
//                    System.out.println("Atualização realizada com sucesso!");
//                    break;
//                case 7:
//                    System.out.print("Insira numero de portas atualizado: ");
//                    int numPortaAtualizada = leitor.nextInt();
//                    veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setNumeroPortas(numPortaAtualizada);
//                    System.out.println("Atualização realizada com sucesso!");
//                    break;
//
//            }
//    }
//}

}


