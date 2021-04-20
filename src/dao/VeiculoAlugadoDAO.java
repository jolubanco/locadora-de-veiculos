package dao;

import connection.ConnectionFactory;
import model.Veiculo;
import model.VeiculoAlugado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeiculoAlugadoDAO {

    private Connection connection;

    public VeiculoAlugadoDAO(Connection connection){
        this.connection = connection;
    }

    public void select() throws SQLException {

        String sql = "SELECT * FROM veiculo_alugado";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.execute();

            try(ResultSet resultSet = preparedStatement.getResultSet()){

                while (resultSet.next()){

                    String placa = resultSet.getString("placa_veiculo");
                    String cpf = resultSet.getString("cpf_cliente");
                    String dataInicio = resultSet.getString("data_inicio");
                    String dataFinal = resultSet.getString("data_final");
                    double valorLocacao = resultSet.getDouble("valor_locacao");
                    boolean statusLocacao = resultSet.getBoolean("status_locacao");

                    System.out.println("Placa: " + placa + ", Cpf: " + cpf + ", Inicio: " + dataInicio + ", Final: " + dataFinal +
                            ", Valor Locacao: R$" + valorLocacao + ", Status Locação: " + statusLocacao);
                }
            }
        }
    }

    public void insert(VeiculoAlugado veiculoAlugado) throws SQLException {

        String sql = "INSERT INTO veiculo_alugado (placa_veiculo,cpf_cliente,data_inicio,data_final,valor_locacao,status_locacao) VALUES (?,?,?,?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, veiculoAlugado.getVeiculo().getPlaca());
            preparedStatement.setString(2, veiculoAlugado.getCliente().getCpf());
            preparedStatement.setString(3, veiculoAlugado.getDataInicio());
            preparedStatement.setString(4, veiculoAlugado.getDataFinal());
            preparedStatement.setDouble(5, veiculoAlugado.getValorLocacao());
            preparedStatement.setBoolean(6, true);

            preparedStatement.execute();

        }
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
    }

}
