package DataStructures;

import java.util.ArrayList;

public class ExcerciceSix {
    /*
    *Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10.
    *A continuación, con otro bucle, recórrelo y elimina los numeros pares.
    *Por último, vuelve a recorrerlo y muestra el ArrayList final.
    * Si te atreves, puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.
     */
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            arrayList.add(i);
        }
        int cont = 0;
        System.out.println("____Imprimimos nuestro array con numeros impares:____");
        ArrayList<Integer> pares = new ArrayList<Integer>();
        /* Posible Solucion
        for(int i = 0; i<arrayList.size(); i++){
           if (arrayList.get(i) %2 == 0) {
               arrayList.remove(i);
               i = 0;
               System.out.print(arrayList.get(cont)+" ");
               cont += 1;
           }
           }
        */
         for(Integer i: arrayList){
             if(i % 2 != 0){
                 pares.add(i);
                 System.out.print(pares.get(cont)+ " ");
                 cont += 1;
             }
         }
    }
}
