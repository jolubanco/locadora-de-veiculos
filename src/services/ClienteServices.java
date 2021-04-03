package services;

import model.Cliente;
import model.Veiculo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ClienteServices {

    public static ArrayList<Cliente> clientesCadastrados = new ArrayList();

    public ArrayList<Cliente> getClientesCadastrados() {
        return clientesCadastrados;
    }

//    public void getClientesCadastrados() {
//        if (clientesCadastrados.size() != 0){
//            for(int i = 0; i < clientesCadastrados.size(); i++){
//                System.out.println(clientesCadastrados.get(i));
//            }
//        } else {
//            System.out.println("Não existem clientes cadastrados!");
//        }
//    }

    public void adicionaCliente (Cliente clienteCadastrado){
        clientesCadastrados.add(clienteCadastrado);
    }


}
