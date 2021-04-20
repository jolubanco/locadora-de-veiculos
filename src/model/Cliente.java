package model;

import java.sql.SQLException;

public class Cliente implements Autenticavel{

    private String nome;
    private String cpf;
    private Autenticacao autenticador;

    public Cliente(){
        this.autenticador = new Autenticacao();
    }

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente: " +
                "nome = '" + nome + '\'' +
                ", cpf = '" + cpf + '\'';
    }

    //ainda nao existem implementação para o cliente utilizar a senha!
    @Override
    public void setSenha(String senha) {
        this.autenticador.setSenha(senha);
    }

    @Override
    public boolean autentica(String userName,String senha) throws SQLException {
        return autenticador.autentica(userName,senha);
    }
}


