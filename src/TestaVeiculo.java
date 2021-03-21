public class TestaVeiculo {

    public static void main(String[] args) {

        Veiculo vec = new Veiculo("Ferrari","ABCD-1457", 70000);
        Camionete cat = new Camionete("Chevrolet", "ABBA-1547",150000);
        Caminhao cam = new Caminhao("Mercedez Bens","OKL-1025",500000);

        Cliente cliente = new Cliente("08326702943");

        //cliente algua o carro vec
        vec.aluga(25,12,cliente);
        cam.aluga(22,12,cliente);

        System.out.println("Veículos Cadastrados: " + Veiculo.getTotalVeiculos());

//        System.out.println(Veiculo.exibeCarrosDisponiveis());



    }
}
