package model;

import connection.Select;

import java.sql.SQLException;

public class AutenticacaoPratica {

    private String senha;
    //fazer a conexão com o banco
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean autentica(String userName,String senha) throws SQLException {
        Select select = new Select();
        String senhaFuncionarioConsultada = select.selectLoginFuncionario(userName);

        if(senhaFuncionarioConsultada.equals(senha)){
            return true;
        } else {
            return false;
        }
    }

}
