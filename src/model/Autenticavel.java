package model;

import java.sql.SQLException;

public interface Autenticavel {

    public abstract void setSenha(String senha);

    public abstract boolean autentica(String username,String senha) throws SQLException;
}
