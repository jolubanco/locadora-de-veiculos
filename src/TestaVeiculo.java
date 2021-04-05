import model.*;
import services.VeiculoServices;

import java.io.IOException;
import java.util.ArrayList;

public class TestaVeiculo {

    public static void main(String[] args) throws IOException {

        //[*] instaciando objetos
        Carro vec = new Carro("Ferrari","ABCD-1457", 70000);
        Camionete cat = new Camionete("Chevrolet", "ABBA-1547",150000);
        Caminhao cam = new Caminhao("Mercedez Bens","OKL-1025",500000);
        Cliente cliente = new Cliente("08326702943");

        //[*] instanciando classe VeiculoServices onde estao os metodos para veiculos
        VeiculoServices veiculoService = new VeiculoServices();

        //[*] adicionando um novo veiculo a lista de veiculos cadastrados
        veiculoService.adicionaVeiculo(vec);
        veiculoService.adicionaVeiculo(cat);
        veiculoService.adicionaVeiculo(cam);
        System.out.println(veiculoService.getVeiculosCadastrados());
        System.out.println(veiculoService.getVeiculosCadastrados().get(1).getPlaca());


        //[*] alugando veiculos
        veiculoService.alugaVeiculo(3,cliente, vec);
        veiculoService.alugaVeiculo(2,cliente,cat);

        //[*] adicionando os veiculos na lista de veiculos alugados e exibindo quais veiculos foram alugados
//        veiculoService.adicionaVeiculoAlugado(veiculoAlugado1);
//        veiculoService.adicionaVeiculoAlugado(veiculoAlugado2);
        veiculoService.getVeiculosAlugados();

        //[*] exibe o numero de veiculos cadastrados
        System.out.println("Veículos Cadastrados: " + Veiculo.getTotalVeiculos());

//        veiculoService.exibeVeiculosCadastrados();




    }

}
