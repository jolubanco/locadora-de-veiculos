package model;

import java.sql.SQLException;

public class Funcionario implements Autenticavel{

    private String nome;
    private String cpf;
    private String userName; //tratar o username para que não exista dois iguais
    private Autenticacao autenticador = new Autenticacao();

    //ta estranho
    public Funcionario(){
    }

    public Funcionario(String nome, String cpf, String userName) {
        this.nome = nome;
        this.cpf = cpf;
        this.userName = userName;
//        this.autenticador = new AutenticacaoPratica();
//        setSenha(cpf);
    }

    @Override
    public void setSenha(String senha) {
        this.autenticador.setSenha(senha);
    }

    @Override
    public boolean autentica(String userName,String senha) throws SQLException {
        return this.autenticador.autentica(userName,senha);
    }

    public String getNome() {
        return nome;
    }
}
