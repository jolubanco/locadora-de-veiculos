package dao;

import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO {

    private Connection connection;

    public FuncionarioDAO(Connection connection){
        this.connection = connection;
    }

    public String selectSenha(String userName) throws SQLException {

        String sql = "SELECT nome,senha FROM funcionario WHERE username = ?";
        String nome = null;
        String senha = null;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1,userName);
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){

                while (resultSet.next()){
//                  nome = resultSet.getString("nome");
                    senha = resultSet.getString("senha");
                }
            }
        }

        return senha;
    }
}
