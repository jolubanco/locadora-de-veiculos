package model;

public class Atendente extends Funcionario implements Autenticavel {

    public Atendente(String nome, String cpf, String userName) {
        super(nome, cpf,userName);
    }

    @Override
    public boolean autentica(String username,String senha) {
        return false;
    }
}
