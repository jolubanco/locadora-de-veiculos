package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cliente WHERE id = ?");

        deletaCliente(2,preparedStatement);

        preparedStatement.close();
        connection.close();

    }
    private static void deletaCliente(int id, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1,id);
        preparedStatement.execute();

        int linhasmModificadas = preparedStatement.getUpdateCount();

        System.out.println("Quantidade de linhas apagadas: " + linhasmModificadas);

    }


}
