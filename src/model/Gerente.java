package model;

import java.sql.SQLException;

public class Gerente extends Funcionario implements Autenticavel{

    public Gerente(String nome, String cpf, String userName){
        super(nome,cpf,userName);
    }

    @Override
    public boolean autentica(String userName,String senha) throws SQLException {
        System.out.println("Olá Gerente " + super.getNome());
        return super.autentica(userName,senha);
    }

}
