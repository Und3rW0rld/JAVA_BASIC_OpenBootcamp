package Reversed_String;
import java.util.Scanner;
public class Main {
    /*Escribe el código que devuelva una cadena al revés.
    Por ejemplo, la cadena "hola mundo", debe retornar "odnum aloh".*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverse(s));
    }
    public static String reverse(String texto) {
        StringBuilder result = new StringBuilder();
        for(int i = texto.length() - 1; i >= 0; i--){
            result.append(texto.charAt(i));
        }
        return result.toString();
    }
}
