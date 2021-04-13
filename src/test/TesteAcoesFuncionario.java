package test;

import connection.*;
import model.*;
import services.ClienteServices;
import services.FuncionarioServices;
import services.VeiculoServices;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class TesteAcoesFuncionario {

    public static void main(String[] args) throws IOException, SQLException {

        //PRÉ-DEFINICOES
        VeiculoServices veiculoServices = new VeiculoServices();
        ClienteServices clienteServices = new ClienteServices();
        Funcionario funcionario = new Funcionario();
        funcionario.setSenha(2021);
        ////

        //PRÉ-DEFINICOES - BANCO DE DADOS
        Insert insert = new Insert();
        Delete delete = new Delete();
        Select select = new Select();
        Update update = new Update();

        //APENAS PARA TESTE
        Carro veiculoteste1 = new Carro("Peugeot", "ABCD-1010", 15000);
        Carro veiculoteste2 = new Carro("Ford", "EFGH-0101", 30000);
        Carro veiculoteste3 = new Carro("Ferrari", "IUPI-5255", 1000000);
        Cliente clienteteste1 = new Cliente("guilherme","08326702943");
        Cliente clienteteste2 = new Cliente("Joaquim","10255889699");
        Cliente clienteteste3 = new Cliente("Douglas","101010101010");
        clienteServices.adicionaCliente(clienteteste1);
        clienteServices.adicionaCliente(clienteteste2);
        clienteServices.adicionaCliente(clienteteste3);
        veiculoServices.adicionaVeiculo(veiculoteste1);
        veiculoServices.adicionaVeiculo(veiculoteste2);
        veiculoServices.adicionaVeiculo(veiculoteste3);

        boolean condicao = true;

        while(true){
            Scanner leitorSenhaFuncionario = new Scanner(System.in);
            System.out.print("Informe sua senha: ");
            int senhaSolicitada = leitorSenhaFuncionario.nextInt();

                if (funcionario.autentica(senhaSolicitada)){
                    condicao = true;
                    while (condicao) {
                        Scanner leitor = new Scanner(System.in);

                        int opcaoAcaoFuncionario = FuncionarioServices.exibeAcoesFuncionario();

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

                                //Cadastrando MySQL
                                insert.insertVeiculo(new Carro(marca,placa,valor),"carro");

                                break;
                            case 2:
                                //veiculoServices.getVeiculosCadastrados().stream().forEach(vec -> System.out.println(vec.toString()));
                                select.selectVeiculo();
                                System.out.print("Escolha a placa do veículo: ");
                                String placaVeiculo = leitor.nextLine();

                                int opcaoAtualizacao = FuncionarioServices.exibeListaAtualizacaoVeiculo();

                                switch (opcaoAtualizacao){
                                    case 1:
                                        System.out.print("Insira a marca atualizada: ");
                                        String marcaAtualizada = leitor.nextLine();
                                        //veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setMarca(marcaAtualizada);
                                        update.atualizarVeiculo(placaVeiculo,marcaAtualizada,1);
                                        System.out.println("Atualização realizada com sucesso!");
                                        break;
                                    case 2:
                                        System.out.print("Insira a placa atualizada: ");
                                        String placaAtualizada = leitor.nextLine();
                                        //veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setPlaca(placaAtualizada);
                                        update.atualizarVeiculo(placaVeiculo,placaAtualizada,2);
                                        System.out.println("Atualização realizada com sucesso!");
                                        break;
                                    case 3:
                                        System.out.print("Insira o modelo atualizado: ");
                                        String modeloAtualizada = leitor.nextLine();
                                        //veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setModelo(modeloAtualizada);
                                        update.atualizarVeiculo(placaVeiculo,modeloAtualizada,3);
                                        System.out.println("Atualização realizada com sucesso!");
                                        break;
                                    case 4:
                                        System.out.print("Insira o valor atualizado: ");
                                        double valorAtualizada = leitor.nextDouble();
                                        //veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setValorVeiculo(valorAtualizada);
                                        //update.atualizarVeiculo(placaVeiculo,valorAtualizada,4);
                                        System.out.println("Atualização realizada com sucesso!");
                                        break;
                                    case 5:
                                        System.out.print("Insira a cor atualizada: ");
                                        String corAtualizada = leitor.nextLine();
                                        //veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setCor(corAtualizada);
                                        update.atualizarVeiculo(placaVeiculo,corAtualizada,5);
                                        System.out.println("Atualização realizada com sucesso!");
                                        break;
                                    case 6:
                                        System.out.print("Insira o ano atualizado: ");
                                        int anoAtualizada = leitor.nextInt();
                                        //veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setAno(anoAtualizada);
                                        //update.atualizarVeiculo(placaVeiculo,anoAtualizada,6);
                                        System.out.println("Atualização realizada com sucesso!");
                                        break;
                                    case 7:
                                        System.out.print("Insira numero de portas atualizado: ");
                                        int numPortaAtualizada = leitor.nextInt();
                                        //veiculoServices.getVeiculosCadastrados().get(posicaoVeiculo).setNumeroPortas(numPortaAtualizada);
                                        //update.atualizarVeiculo(placaVeiculo,numPortaAtualizada,7);
                                        System.out.println("Atualização realizada com sucesso!");
                                        break;

                                }
                                break;
                            case 3:
                                select.selectVeiculo();
                                break;
//                                if (veiculoServices.getVeiculosCadastrados().size() != 0){
//                                    System.out.println("Numero de veiculos cadastrados: " + veiculoServices.getVeiculosCadastrados().size());
//                                    veiculoServices.getVeiculosCadastrados().stream().forEach(vec -> System.out.println(vec.toString()));
//                                } else {
//                                    System.out.println("Lista vazia. Cadastre um veículo!");
//                                }

                            case 4:
                                System.out.println("Forneça as seguintes informações");

                                System.out.print("Nome: ");
                                String nome = leitor.nextLine();

                                System.out.print("Cpf: ");
                                String cpf = leitor.nextLine();

                                clienteServices.adicionaCliente(new Cliente(nome,cpf));

                                //[*] Adicionando Cliente no MySQL
                                insert.insertCliente(new Cliente(nome,cpf));

                                System.out.println("Cliente cadastrado com sucesso!");
                                break;
                            case 5:
                                //só é possivel mudar o status do cliente, escolhendo a opção "desativar cliente"

                                //clienteServices.getClientesCadastrados().stream().forEach(cli -> System.out.println(cli.toString()));
                                select.selectCliente();
                                System.out.print("Escolha o cpf do cliente: ");
                                String cpfCliente = leitor.nextLine();

                                int opcaoAtualizacaoCliente = FuncionarioServices.exibeListaAtualizacaoCliente();

                                switch (opcaoAtualizacaoCliente){
                                    case 1:
                                        System.out.print("Insira o nome atualizado: ");
                                        String nomeAtualizado = leitor.nextLine();
                                        //MELHORAR O PARAMETRO opcaoAtualização
                                        update.atualizaCliente(cpfCliente,nomeAtualizado,1);
                                        //clienteServices.getClientesCadastrados().get(posicaoClienteAtualizar).setNome(nomeAtualizado);
                                        System.out.println("Atualização realizada com sucesso!");
                                        break;
                                    case 2:
                                        System.out.print("Insira o cpf atualizado: ");
                                        String cpfAtualizado = leitor.nextLine();
                                        //MELHORAR O PARAMETRO opcaoAtualização
                                        update.atualizaCliente(cpfCliente,cpfAtualizado,2);
                                        //clienteServices.getClientesCadastrados().get(posicaoClienteAtualizar).setCpf(cpfAtualizado);
                                        System.out.println("Atualização realizada com sucesso!");
                                        break;
                                }
                                break;
                            case 6:
                                select.selectCliente();
                                break;
//                                if (clienteServices.getClientesCadastrados().size() != 0){
//                                    System.out.println("Numero de clientes cadastrados: " + clienteServices.getClientesCadastrados().size());
//                                    clienteServices.getClientesCadastrados().stream().forEach(cli -> System.out.println(cli.toString()));
//                                } else {
//                                    System.out.println("Lista vazia. Cadastre um cliente!");
//                                }

                            case 7:
                              //clienteServices.getClientesCadastrados().stream().forEach(cliente -> System.out.println(cliente.toString()));
                                select.selectCliente();
                                System.out.print("Escolha o cpf do cliente: ");
                                String cpfClienteEscolhido = leitor.nextLine();

                              //veiculoServices.getVeiculosCadastrados().stream().forEach(veiculo -> System.out.println(veiculo.toString()));
                                select.selectVeiculo();
                                System.out.print("Escolha a placa do veículo: ");
                                String placaVeiculoAlugarEscolhido = leitor.nextLine();

                                System.out.print("Número Diarias: ");
                                int numeroDiarias = leitor.nextInt();

                                //VAI SAIR
//                                Cliente cliente = null;
//                                for(int i = 0; i < clienteServices.getClientesCadastrados().size() ; i++){
//                                    if (clienteServices.getClientesCadastrados().get(i).getCpf().equals(cpfClienteEscolhido)){
//                                         cliente = clienteServices.getClientesCadastrados().get(i);
//                                    }
//                                }

//                                Veiculo veiculo = null;
//                                for(int i = 0 ; i < veiculoServices.getVeiculosCadastrados().size() ; i++){
//
//                                    if (veiculoServices.getVeiculosCadastrados().get(i).getPlaca().equals(placaVeiculoAlugarEscolhido)){
//                                        veiculo = veiculoServices.getVeiculosCadastrados().get(i);
//                                    }
//                                }
                                //

                                //[*] Recuperando os dados do Cliente
                                ArrayList listaAtributosCliente = select.selectClienteCpf(cpfClienteEscolhido);
                                String nomeClienteRecuperado = (String) listaAtributosCliente.get(0);
                                String cpfClienteRecuperada = (String) listaAtributosCliente.get(1);
                                //

                                //[*] Recuperando os dados do Veículo
                                ArrayList listaAtributosVeiculo = select.selectVeiculoPlaca(placaVeiculoAlugarEscolhido);
                                String marcaVeiculoRecuperada = (String) listaAtributosVeiculo.get(0);
                                String placaVeiculoRecuperada = (String) listaAtributosVeiculo.get(1);
                                double valorVeiculoRecuperado = (double) listaAtributosVeiculo.get(2);
                                //

                                Veiculo recriandoVeiculoEscolhido = new Veiculo(marcaVeiculoRecuperada,placaVeiculoRecuperada,valorVeiculoRecuperado);
                                Cliente recriandoClienteEscolhido = new Cliente(nomeClienteRecuperado,cpfClienteRecuperada);

                                VeiculoAlugado veiculoAlugado = veiculoServices.alugaVeiculo(numeroDiarias,recriandoClienteEscolhido,recriandoVeiculoEscolhido);
                                veiculoServices.adicionaVeiculoAlugado(veiculoAlugado);


                                //SQL
                                insert.insertVeiculoAlugado(veiculoAlugado);
                                break;
                            case 8:
                                select.selectVeiculoAlugado();
//                                veiculoServices.exibeVeiculosAlugados();
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

}


