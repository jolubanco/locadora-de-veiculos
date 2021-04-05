import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestReadTxt {

    public static void main(String[] args) throws IOException {
        //[*] abrindo o arquivo, se não existir ele cria um novo arquivo
        FileReader arquivo = new FileReader("C:\\Users\\jolub\\IdeaProjects\\locadora-carros\\veiculosAlugados.txt");
        //[*] lendo o arquivo
        BufferedReader lerArquivo = new BufferedReader(arquivo);

        //[*] lê a primeira linha. A variável "linha" recebe o valor "null" quando o processo
        //[*] de repetição atingir o final do arquivo texto
        String linha = lerArquivo.readLine();

        while(linha != null){
            System.out.printf("%s\n",linha);
            linha = lerArquivo.readLine(); //[*] lê da segunda até a última linha
        }

        //[*] fechando o arquivo
        arquivo.close();

//        int i;
//        while((i=fr.read())!=-1)
//            System.out.print((char)i);
//        fr.close();
    }

}
