package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

public class Select {

    public void selectVeiculo() throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM veiculo");
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String marca = resultSet.getString("marca");
            String placa = resultSet.getString("placa");
            String modelo = resultSet.getString("modelo");
            int numeroPortas = resultSet.getInt("numero_portas");
            double valorVeiculo = resultSet.getDouble("valor_veiculo");
            String cor = resultSet.getString("cor");
            int ano = resultSet.getInt("ano");
            String tipoVeiculo = resultSet.getString("tipo_veiculo");

            System.out.println("Tipo Veículo: " + tipoVeiculo + ", Marca: " + marca + ", Placa: " + placa +
                    ", Modelo: " + modelo + ", Nº Portas: " + numeroPortas + ", Valor Veiculo: " + valorVeiculo +
                    ", Cor: " + cor + ", Ano: " + ano);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    public void selectCliente() throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cliente");
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String cpf = resultSet.getString("cpf");
            boolean status = resultSet.getBoolean("status");

            System.out.println("Id: " + id + ", Nome: " + nome + ", Cpf: " + cpf + ", Status: " + status);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    public void selectVeiculoAlugado() throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM veiculo_alugado");
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()){
            String placa = resultSet.getString("placa_veiculo");
            String cpf = resultSet.getString("cpf_cliente");
            String dataInicio = resultSet.getString("data_inicio");
            String dataFinal = resultSet.getString("data_final");
            double valorLocacao = resultSet.getDouble("valor_locacao");
            boolean statusLocacao = resultSet.getBoolean("status_locacao");

            System.out.println("Placa: " + placa + ", Cpf: " + cpf + ", Data Inicio: " + dataInicio + ", Data Final: " + dataFinal +
                    ", Valor Locacao: R$" + valorLocacao + ", Status Locação: " + statusLocacao);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    public ArrayList selectVeiculoPlaca(String placaInformada) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT marca,valor_veiculo,placa FROM veiculo WHERE placa = ?");
        preparedStatement.setString(1,placaInformada);
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getResultSet();

        String marca = null;
        String placa = null;
        double valor = 0;

        while (resultSet.next()){
            marca = resultSet.getString("marca");
            placa = resultSet.getString("placa");
            valor = resultSet.getDouble("valor_veiculo");
        }

        ArrayList listaSelecaoVeiculo = new ArrayList();
        listaSelecaoVeiculo.add(marca);
        listaSelecaoVeiculo.add(placa);
        listaSelecaoVeiculo.add(valor);

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return listaSelecaoVeiculo;

    }

    public ArrayList selectClienteCpf(String cpfInformado) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT nome,cpf FROM cliente WHERE cpf = ?");
        preparedStatement.setString(1,cpfInformado);
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getResultSet();

        String nome = null;
        String cpf = null;

        while (resultSet.next()){
            nome = resultSet.getString("nome");
            cpf = resultSet.getString("cpf");
        }

        ArrayList listaSelecaoVeiculo = new ArrayList();
        listaSelecaoVeiculo.add(nome);
        listaSelecaoVeiculo.add(cpf);

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return listaSelecaoVeiculo;

    }


}
