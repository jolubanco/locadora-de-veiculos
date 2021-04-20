package connection;

import model.Cliente;
import model.Veiculo;
import model.VeiculoAlugado;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Insert {
    //ok
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
    //ok
    public void insertVeiculoAlugado(VeiculoAlugado veiculoAlugado) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO veiculo_alugado" +
                " (placa_veiculo,cpf_cliente,data_inicio,data_final,valor_locacao,status_locacao) " +
                "VALUES (?,?,?,?,?,?)");

        //FEITO PORCAMENTE, CORRIGIR
//        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
//        String dataInicioString = dateFormat.format(veiculoAlugado.getDataInicio()); //aqui
//        String dataFinalString = dateFormat.format(veiculoAlugado.getDataFinal());

//        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
//        String dataInicio = veiculoAlugado.getDataInicio();
//        OffsetDateTime dateTime = OffsetDateTime.parse(dataInicio);
//        String dataInicioFormatada = dateTime.format(monthFormatter);
//
//        String dataFinal = veiculoAlugado.getDataFinal();
//        OffsetDateTime dateTime2 = OffsetDateTime.parse(dataFinal);
//        String dataFinalFormatada = dateTime2.format(monthFormatter);



        preparedStatement.setString(1, veiculoAlugado.getVeiculo().getPlaca());
        preparedStatement.setString(2, veiculoAlugado.getCliente().getCpf());
        preparedStatement.setString(3, veiculoAlugado.getDataInicio());
        preparedStatement.setString(4, veiculoAlugado.getDataFinal());
        preparedStatement.setDouble(5, veiculoAlugado.getValorLocacao());
        preparedStatement.setBoolean(6, true);

        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }
    //ok
    public void insertVeiculo(Veiculo veiculo, String tipoVeiculo) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO veiculo " +
                "(marca, placa, valor_veiculo,tipo_veiculo) VALUES (?,?,?,?)");

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