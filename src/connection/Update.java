package connection;

import model.Cliente;

import java.sql.*;

public class Update {

    public void atualizaCliente(String cpfCliente, String variavelAtualizada, int opcaoAtualizacao) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        //otimizar esse processo, sem repetição de codigo!
        switch (opcaoAtualizacao){
            case 1:
                PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE cliente SET nome = ?" +
                        "WHERE cpf = ?");

                preparedStatement1.setString(1, variavelAtualizada);
                preparedStatement1.setString(2, cpfCliente);

                preparedStatement1.execute();
                preparedStatement1.close();
                connection.close();
                break;
            case 2:
                PreparedStatement preparedStatement2 = connection.prepareStatement("UPDATE cliente SET cpf = ?" +
                        "WHERE cpf = ?");

                preparedStatement2.setString(1, variavelAtualizada);
                preparedStatement2.setString(2, cpfCliente);

                preparedStatement2.execute();
                preparedStatement2.close();
                connection.close();
                break;
        }


    }

    public void atualizarVeiculo(String placaVeiculo, Object variavelAtualizada, int opcaoAtualizacao) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        //otimizar esse processo, sem repetição de codigo!
        //problema em atualizar os campos que não são Strings
        switch (opcaoAtualizacao){
            case 1:
                PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE veiculo SET marca = ? WHERE placa = ?");

                preparedStatement1.setString(1, (String) variavelAtualizada);
                preparedStatement1.setString(2, placaVeiculo);

                preparedStatement1.execute();
                preparedStatement1.close();
                connection.close();
                break;
            case 2:
                PreparedStatement preparedStatement2 = connection.prepareStatement("UPDATE veiculo SET placa = ? WHERE placa = ?");

                preparedStatement2.setString(1, (String) variavelAtualizada);
                preparedStatement2.setString(2, placaVeiculo);

                preparedStatement2.execute();
                preparedStatement2.close();
                connection.close();
                break;
            case 3:
                PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE veiculo SET modelo = ? WHERE placa = ?");

                preparedStatement3.setString(1, (String) variavelAtualizada);
                preparedStatement3.setString(2, placaVeiculo);

                preparedStatement3.execute();
                preparedStatement3.close();
                connection.close();
                break;
            case 4:
                PreparedStatement preparedStatement4 = connection.prepareStatement("UPDATE veiculo SET valor_veiculo = ? WHERE placa = ?");

                preparedStatement4.setDouble(1, (double) variavelAtualizada);
                preparedStatement4.setString(2, placaVeiculo);

                preparedStatement4.execute();
                preparedStatement4.close();
                connection.close();
                break;
            case 5:
                PreparedStatement preparedStatement5 = connection.prepareStatement("UPDATE veiculo SET cor = ? WHERE placa = ?");

                preparedStatement5.setString(1, (String) variavelAtualizada);
                preparedStatement5.setString(2, placaVeiculo);

                preparedStatement5.execute();
                preparedStatement5.close();
                connection.close();
                break;
            case 6:
                PreparedStatement preparedStatement6 = connection.prepareStatement("UPDATE veiculo SET ano = ? WHERE placa = ?");

                preparedStatement6.setInt(1,(int) variavelAtualizada);
                preparedStatement6.setString(2, placaVeiculo);

                preparedStatement6.execute();
                preparedStatement6.close();
                connection.close();
                break;
            case 7:
                PreparedStatement preparedStatement7 = connection.prepareStatement("UPDATE veiculo SET numero_portas = ? WHERE placa = ?");

                preparedStatement7.setInt(1,(int) variavelAtualizada);
                preparedStatement7.setString(2, placaVeiculo);

                preparedStatement7.execute();
                preparedStatement7.close();
                connection.close();
                break;
        }
    }
}
