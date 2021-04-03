package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario {

    private String nome;
    private String cpf;
    private int senha;

    public boolean autenticaSenha(int senhaFuncionario){
        if(this.senha == senhaFuncionario){
            System.out.println("Acesso Permitido!");
            return true;
        } else {
            System.out.println("Acesso Negado!");
            return false;
        }
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
}
