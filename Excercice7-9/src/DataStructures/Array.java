package DataStructures;

public class Array {
    /*Crea un array unidimensional de Strings y recórrelo,
    mostrando únicamente sus valores.
     */
    public static void main(String[] args) {
        var array = new String[]{"Carlos", "Felipe", "Juan", "Ramiro", "Sofia"};
        for(String element: array){
            System.out.println(element);
        }
    }
}
