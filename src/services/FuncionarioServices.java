package services;

import java.util.ArrayList;
import java.util.Scanner;

public class FuncionarioServices {

    public static int exibeAcoesFuncionario(){
        Scanner leitor = new Scanner(System.in);
        ArrayList<String> listaAcoesFuncionario = new ArrayList();

        listaAcoesFuncionario.add("Cadastrar novo veículo");
        listaAcoesFuncionario.add("Realizar uma locação");
        listaAcoesFuncionario.add("Atualizar veículos");
        listaAcoesFuncionario.add("Consultar veículos cadastrados");
        listaAcoesFuncionario.add("Cadastrar novo cliente");
        listaAcoesFuncionario.add("Consultar clientes cadastrados");
        listaAcoesFuncionario.add("Atualizar cliente");

        System.out.printf("x-------------------------x\n" +
                "Painel do Funcionário: \n");
        int n = listaAcoesFuncionario.size();
        for (int i=0; i<n; i++) {
            System.out.printf("%d. %s\n", i+1, listaAcoesFuncionario.get(i));
        }

        System.out.print("Escolha uma opção: ");
        return leitor.nextInt();
    }

    public static int exibeListaAtualizacaoVeiculo(){
        Scanner leitor = new Scanner(System.in);
        ArrayList<String> listaAtualizacao = new ArrayList();

        listaAtualizacao.add("Marca");
        listaAtualizacao.add("Placa");
        listaAtualizacao.add("Modelo");
        listaAtualizacao.add("Valor");
        listaAtualizacao.add("Cor");
        listaAtualizacao.add("Ano");
        listaAtualizacao.add("Número de Portas");

        System.out.printf("Atualizar: \n");
        int j = listaAtualizacao.size();
        for (int i=0; i<j; i++) {
            System.out.printf("%d. %s\n", i+1, listaAtualizacao.get(i));
        }

        System.out.print("Escolha uma opção: ");
        return leitor.nextInt();
    }

    public static int exibeListaAtualizacaoCliente(){
        Scanner leitor = new Scanner(System.in);
        ArrayList<String> listaAtualizacao = new ArrayList();

        listaAtualizacao.add("Nome");
        listaAtualizacao.add("Cpf");

        System.out.printf("Atualizar: \n");
        int j = listaAtualizacao.size();
        for (int i=0; i<j; i++) {
            System.out.printf("%d. %s\n", i+1, listaAtualizacao.get(i));
        }

        System.out.print("Escolha uma opção: ");
        return leitor.nextInt();
    }

}
