import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestWriteTxt {

    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);
        System.out.println("Informe o texto para ser gravado");
        String texto = ler.nextLine();

        FileWriter arquivo = new FileWriter("C:\\Users\\jolub\\treino.txt");
        PrintWriter gravaArquivo = new PrintWriter(arquivo);

        gravaArquivo.println(texto);

        arquivo.close();

    }

}
