package task03;
import java.util.Scanner;
import java.io.*;
public class Main {
  
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    try {
      String path = "/home/kennedy/Documentos/faculdade/2022.2/compiladores/RPNStacker/task03/";
      FileReader fileReader = new FileReader(path + File.separator + "input.txt");
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String linha;
      while ((linha = bufferedReader.readLine()) != null) {
        System.out.println(linha);
        if(Regex.isNum(linha)){
          System.out.println("eh numero");
        } else if(Regex.isOP(linha)){
          System.out.println("eh Operacao");
        } else{
          System.out.println("Nenhum dos casos");
        }
        
      }
      
      bufferedReader.close();
    } catch (IOException e) {
      System.out.println("Ocorreu um erro ao ler o arquivo.");
      e.printStackTrace();
    }
  }
}
