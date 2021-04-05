import model.Cliente;
import model.Funcionario;
import services.FuncionarioServices;

public class TestaAutenticacao {

    public static void main(String[] args) {

        Funcionario funcionario = new Funcionario();
        funcionario.setSenha(1010);

        funcionario.autentica(6);

        Cliente cliente = new Cliente();
        cliente.setSenha(10);

        cliente.autentica(10);
        System.out.println(cliente.autentica(10));

    }
}
