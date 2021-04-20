package dao;

import connection.ConnectionFactory;
import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO(Connection connection){
        this.connection = connection;
    }

    public void select() throws SQLException {

        String sql = "SELECT * FROM cliente";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String cpf = resultSet.getString("cpf");
                    boolean status = resultSet.getBoolean("status");
                    //talvez utilizar toString
                    System.out.println("Id: " + id + ", Nome: " + nome + ", Cpf: " + cpf + ", Status: " + status);
                }
            }
        }
    }

    public Cliente selectCpf(String cpfInformado) throws SQLException {

        String sql = "SELECT nome,cpf FROM cliente WHERE cpf = ?";

        String nome = null;
        String cpf = null;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1,cpfInformado);
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){

                while (resultSet.next()){
                    nome = resultSet.getString("nome");
                    cpf = resultSet.getString("cpf");
                }
            }
        }
        return new Cliente(nome,cpf);
    }

    public void insert(Cliente cliente) throws SQLException {

        String sql = "INSERT INTO cliente (nome,cpf,senha,status) VALUES (?,?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getCpf());
            preparedStatement.setBoolean(4, true);
            //setando a senha padrão para ser o CPF.
        }
    }

    public void update(String cpfCliente, String variavelAtualizada, int opcaoAtualizacao) throws SQLException {

        String sql1 = "UPDATE cliente SET nome = ? WHERE cpf = ?";
        String sql2 = "UPDATE cliente SET cpf = ? WHERE cpf = ?";

        switch (opcaoAtualizacao){
            case 1:
                try(PreparedStatement preparedStatement1 = connection.prepareStatement(sql1)){

                    preparedStatement1.setString(1, variavelAtualizada);
                    preparedStatement1.setString(2, cpfCliente);

                    preparedStatement1.execute();
                    break;
                }
            case 2:
                try(PreparedStatement preparedStatement2 = connection.prepareStatement(sql2)) {

                    preparedStatement2.setString(1, variavelAtualizada);
                    preparedStatement2.setString(2, cpfCliente);

                    preparedStatement2.execute();
                    break;
                }
        }


    }

}
