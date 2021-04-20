package dao;

import connection.ConnectionFactory;
import model.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeiculoDAO {

    private Connection connection;

    public VeiculoDAO(Connection connection){
        this.connection = connection;
    }

    public void insert(Veiculo veiculo, String tipoVeiculo) throws SQLException {

        String sql = "INSERT INTO veiculo (marca, placa, valor_veiculo,tipo_veiculo) VALUES (?,?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, veiculo.getMarca());
            preparedStatement.setString(2, veiculo.getPlaca());
            preparedStatement.setDouble(3,veiculo.getValorVeiculo());
            //corrigir a formad e obter o tipo do veiculo
            preparedStatement.setString(4, tipoVeiculo);
            //setando a senha padrão para ser o CPF.

            preparedStatement.execute();

        }



    }

    public void select() throws SQLException {

        String sql = "SELECT * FROM veiculo";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){

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
            }
        }

    }

    public Veiculo selectPlaca(String placaInformada) throws SQLException {

        String sql = "SELECT marca,valor_veiculo,placa FROM veiculo WHERE placa = ?";
        String marca = null;
        String placa = null;
        double valor = 0;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1,placaInformada);
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){

                while (resultSet.next()){
                    marca = resultSet.getString("marca");
                    placa = resultSet.getString("placa");
                    valor = resultSet.getDouble("valor_veiculo");
                }
            }
        }
        return new Veiculo(marca,placa,valor);

    }

    public void update(String placaVeiculo, Object variavelAtualizada, int opcaoAtualizacao) throws SQLException {

        switch (opcaoAtualizacao){
            case 1:
                try(PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE veiculo SET marca = ? WHERE placa = ?")){
                    preparedStatement1.setString(1, (String) variavelAtualizada);
                    preparedStatement1.setString(2, placaVeiculo);

                    preparedStatement1.execute();
                    break;
                }
            case 2:
                try(PreparedStatement preparedStatement2 = connection.prepareStatement("UPDATE veiculo SET placa = ? WHERE placa = ?")){
                    preparedStatement2.setString(1, (String) variavelAtualizada);
                    preparedStatement2.setString(2, placaVeiculo);

                    preparedStatement2.execute();
                    break;
                }
            case 3:
                try(PreparedStatement preparedStatement3 = connection.prepareStatement("UPDATE veiculo SET modelo = ? WHERE placa = ?")){
                    preparedStatement3.setString(1, (String) variavelAtualizada);
                    preparedStatement3.setString(2, placaVeiculo);

                    preparedStatement3.execute();
                    break;
                }
            case 4:
                try(PreparedStatement preparedStatement4 = connection.prepareStatement("UPDATE veiculo SET valor_veiculo = ? WHERE placa = ?")){
                    preparedStatement4.setDouble(1, (double) variavelAtualizada);
                    preparedStatement4.setString(2, placaVeiculo);

                    preparedStatement4.execute();
                    break;
                }
            case 5:
                try(PreparedStatement preparedStatement5 = connection.prepareStatement("UPDATE veiculo SET cor = ? WHERE placa = ?")){
                    preparedStatement5.setString(1, (String) variavelAtualizada);
                    preparedStatement5.setString(2, placaVeiculo);

                    preparedStatement5.execute();
                    break;
                }
            case 6:
                try(PreparedStatement preparedStatement6 = connection.prepareStatement("UPDATE veiculo SET ano = ? WHERE placa = ?")){
                    preparedStatement6.setInt(1,(int) variavelAtualizada);
                    preparedStatement6.setString(2, placaVeiculo);

                    preparedStatement6.execute();
                    break;
                }
            case 7:
                try(PreparedStatement preparedStatement7 = connection.prepareStatement("UPDATE veiculo SET numero_portas = ? WHERE placa = ?")){
                    preparedStatement7.setInt(1,(int) variavelAtualizada);
                    preparedStatement7.setString(2, placaVeiculo);

                    preparedStatement7.execute();
                    break;
                }
        }
    }

}
