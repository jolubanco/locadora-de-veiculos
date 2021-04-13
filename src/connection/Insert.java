package connection;

import model.Cliente;
import model.Veiculo;
import model.VeiculoAlugado;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Insert {

    public void insertCliente(Cliente cliente) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cliente (nome,cpf,senha,status) " +
                "VALUES (?,?,?,?)");

//        preparedStatement.setString(1, cliente.getNome());
        preparedStatement.setString(1, cliente.getNome());
        preparedStatement.setString(2, cliente.getCpf());
        preparedStatement.setString(3, cliente.getCpf());
        preparedStatement.setBoolean(4, true);
        //setando a senha padrão para ser o CPF.

        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public void insertVeiculoAlugado(VeiculoAlugado veiculoAlugado) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO veiculo_alugado" +
                " (placa_veiculo,cpf_cliente,data_inicio,data_final,valor_locacao,status_locacao) " +
                "VALUES (?,?,?,?,?,?)");

        //FEITO PORCAMENTE, CORRIGIR
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        //corrigr o mês, não esta certo, pois está vindo como string e convertendo
        String dataInicioString = dateFormat.format(veiculoAlugado.getDataInicio());
        String dataFinalString = dateFormat.format(veiculoAlugado.getDataFinal());

        preparedStatement.setString(1, veiculoAlugado.getVeiculo().getPlaca());
        preparedStatement.setString(2, veiculoAlugado.getCliente().getCpf());
        preparedStatement.setString(3, dataInicioString);
        preparedStatement.setString(4, dataFinalString);
        preparedStatement.setDouble(5, veiculoAlugado.getValorLocacao());
        preparedStatement.setBoolean(6, true);


        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public void insertVeiculo(Veiculo veiculo, String tipoVeiculo) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO veiculo " +
                "(marca, placa, valor_veiculo,tipo_veiculo) " +
                "VALUES (?,?,?,?)");

//        preparedStatement.setString(1, cliente.getNome());
        preparedStatement.setString(1, veiculo.getMarca());
        preparedStatement.setString(2, veiculo.getPlaca());
        preparedStatement.setDouble(3,veiculo.getValorVeiculo());
        //corrigir a formad e obter o tipo do veiculo
        preparedStatement.setString(4, tipoVeiculo);
        //setando a senha padrão para ser o CPF.

        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }
}