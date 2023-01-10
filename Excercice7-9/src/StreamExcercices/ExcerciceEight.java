package StreamExcercices;

import java.io.*;

public class ExcerciceEight {
    /*
    * Utilizando InputStream y PrintStream, crea una función que reciba dos parámetros:
    * "fileIn" y "fileOut". La tarea de la función será realizar la copia del fichero dado en el parámetro
    * "fileIn" al fichero dado en "fileOut".
    *
    */
    public static void main(String[] args) {
        try{
        InputStream fileIn = new FileInputStream("src/StreamExcercices/fichero.txt");
        PrintStream flieOut = new PrintStream("copy.txt");
        copiarFichero(fileIn, flieOut);
        flieOut.close();
        fileIn.close();
        }catch(FileNotFoundException e){
            System.out.println("El programa da error: "+e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static void copiarFichero(InputStream in, PrintStream out) throws IOException {
        try {
            out.writeBytes(in.readAllBytes());
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: "+e.getMessage());
        }
    }
}