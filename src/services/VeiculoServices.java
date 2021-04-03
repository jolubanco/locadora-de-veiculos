package services;
import model.Cliente;
import model.Veiculo;
import java.text.SimpleDateFormat;
import java.util.*;

public class VeiculoServices {

    //[*] Atributos
    public ArrayList veiculosAlugados = new ArrayList(); // adiciona os campos
    public ArrayList<Veiculo> veiculosCadastrados = new ArrayList(); //adiciona a referencia

    //falta corrigir alguns detalhes
    public void alugaVeiculo(int numDiarias, Cliente cliente, Veiculo veiculo){
        //salvar a data atual
        //mostrar a data final

        //[*] calcula a data final de locação com base no numero de diárias
        GregorianCalendar data = new GregorianCalendar();
        data.add(Calendar.DAY_OF_MONTH, numDiarias);
        int diaFinal = data.get(Calendar.DAY_OF_MONTH);

        //Date dataAdicionada = data.getTime(); apresenta a data ADICIONADA mas sem formatar, verifiar como formatar

        //[*] seleciona a data e horario do dia de locação, formatando da maneira que queremos
        SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        String strTimeDay = simpleformat.format(new Date());

        double valorAluguelVeiculo = (veiculo.getValorVeiculo()*0.001)*(numDiarias);

        System.out.println("Veículo alugado com sucesso!");

        //melhorar os dados que serão salvos, como a data
        ArrayList lista = new ArrayList();
        lista.add("Valor: " + valorAluguelVeiculo);
        lista.add("Cpf: " + cliente.getCpf());
        lista.add("Marca: " + veiculo.getMarca());
        lista.add("Placa: " + veiculo.getPlaca());

        veiculosAlugados.add(lista);
    }


    //REVER, FAZER IGUAL O getVeiculosCadastrados COM MÉTODO toString()
    public void getVeiculosAlugados() {
        for(int i = 0; i < veiculosAlugados.size(); i++){
            System.out.println(veiculosAlugados.get(i));
        }
    }

    //[*] Adiciona a referencia do objeto veiculo
    public void adicionaVeiculo( Veiculo veiculoCadastrado){
        veiculosCadastrados.add(veiculoCadastrado);
//        System.out.println("Veiculo adicionado ao banco de dados com sucesso");
    }

    public ArrayList<Veiculo> getVeiculosCadastrados() {
        return veiculosCadastrados;
    }

//    public void exibeVeiculosCadastrados(){
//        for(int i = 0; i < veiculosCadastrados.size(); i++){
//            System.out.println(veiculosCadastrados.get(i).getMarca());
//        }
//    }

}
