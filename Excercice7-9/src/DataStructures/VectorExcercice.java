package DataStructures;

import java.util.Vector;

public class VectorExcercice {
    /*Crea un "Vector" del tipo de dato que prefieras,
    y añádele 5 elementos. Elimina el 2o y 3er elemento y muestra el resultado final.*/
    public static void main(String[] args) {
        Vector<String> vector = new Vector();
        vector.add("Pablito");
        vector.add("Juanita");
        vector.add("Paquito");
        vector.add("Sopi");
        vector.add("Under_World!");
        vector.remove(2);
        vector.remove(1);
        System.out.println("Result:");
        System.out.println(vector);

}
}
