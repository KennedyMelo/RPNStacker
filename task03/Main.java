package task03;
import java.util.*;
import java.io.*;
public class Main {
  static Stack<Double>pilha = new Stack<>();
  static Vector<Token>vectorToken = new Vector<>();
  
  public static boolean createTokens(String str){
    if(Regex.isNum(str)){
      vectorToken.add(new Token(TokenType.NUM, str));
    } else if(Regex.isOP(str)){
      if(str.equals("+")){
        vectorToken.add(new Token(TokenType.PLUS, str));
      } else if(str.equals("-")){
        vectorToken.add(new Token(TokenType.MINUS, str));
      } else if(str.equals("*")){
        vectorToken.add(new Token(TokenType.STAR, str));
      } else if(str.equals("/")){
        vectorToken.add(new Token(TokenType.SLASH, str));
      }
    } else{
      return false;
    }
    return true;
  }
  public static Double rpnStacker(){
    Double a,b;
    for(Token token: vectorToken){
      System.out.println(token);
      if(token.type == TokenType.NUM){
        pilha.push(Double.parseDouble(token.lexeme));
      } else{  
        b = pilha.pop();
        a = pilha.pop();
        if(token.type == TokenType.PLUS){
          pilha.push(a+b);
        } else if(token.type == TokenType.MINUS){
          pilha.push(a-b);
        } else if(token.type == TokenType.STAR){
          pilha.push(a*b);
        } else if(token.type == TokenType.SLASH){
          pilha.push(a/b);
        }
      }
    }
    return pilha.pop();
  }
  public static void main(String[] args){
    try {
      String path = "/home/kennedy/Documentos/faculdade/2022.2/compiladores/RPNStacker/task03/";
      FileReader fileReader = new FileReader(path + File.separator + "input.txt");
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String linha;
      Boolean flag =true;
      while ((linha = bufferedReader.readLine()) != null) {
        if(!createTokens(linha)){
          System.out.println("Error: Unexpected character: " + linha);
          flag = false;
          break;
        }
      }
      if(flag){
        Double answer = rpnStacker();
        System.out.println("Saida: " + answer);
      }
      bufferedReader.close();
    } catch (IOException e) {
      System.out.println("Ocorreu um erro ao ler o arquivo.");
      e.printStackTrace();
    }
  }
}
