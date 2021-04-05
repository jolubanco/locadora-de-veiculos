package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario implements Autenticavel{

    private String nome;
    private String cpf;
    private AutenticacaoPratica autenticador;

    public Funcionario(){
        this.autenticador = new AutenticacaoPratica();
    }

    public void setSenha(int senha) {
        this.autenticador.setSenha(senha);
    }

    @Override
    public boolean autentica(int senha) {
        return this.autenticador.autentica(senha);
    }
}
