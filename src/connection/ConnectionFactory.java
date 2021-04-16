package connection;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;
        import com.mchange.v2.c3p0.ComboPooledDataSource;

        import javax.sql.DataSource;

public class ConnectionFactory {

//    public DataSource dataSource;
//
//    public ConnectionFactory(){
//        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
//        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/locadora_veiculos?useTimezone=true&serverTimezone=UTC");
//        comboPooledDataSource.setUser("root");
//        comboPooledDataSource.setPassword("root");
//        comboPooledDataSource.setMaxPoolSize(10);
//
//        this.dataSource = comboPooledDataSource;
//    }
//
//    public Connection recuperaConexao() throws SQLException {
//        return this.dataSource.getConnection();
//    }

    public Connection recuperaConexao() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/locadora_veiculos?useTimezone=true&serverTimezone=UTC","root","root");
    }

}
