package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaOrdenacaoLista implements Comparable<TestaOrdenacaoLista>  {
    private String nome;
    private int idade;
    private String endereco;

    @Override
    public int compareTo(TestaOrdenacaoLista p) {
        return this.getNome().compareTo(p.getNome());
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + ", endereco="
                + endereco + "]";
    }

    public static void main(String[] args) {
        TestaOrdenacaoLista p1 = new TestaOrdenacaoLista();
        p1.setNome("João");
        TestaOrdenacaoLista p2 = new TestaOrdenacaoLista();
        p2.setNome("Maria");
        TestaOrdenacaoLista p3 = new TestaOrdenacaoLista();
        p3.setNome("André");
        List<TestaOrdenacaoLista> pessoas = new ArrayList();
        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);
        Collections.sort(pessoas);
        System.out.println(pessoas);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
//getters and setters
}