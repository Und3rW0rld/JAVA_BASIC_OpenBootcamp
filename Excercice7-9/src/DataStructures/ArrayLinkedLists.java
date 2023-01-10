package DataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class ArrayLinkedLists {
    /*Crea un ArrayList de tipo String, con 4 elementos.
    Cópialo en una LinkedList. Recorre ambos mostrando únicamente el valor de cada elemento.*/
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("Pepito");
        arrayList.add("Sopita");
        arrayList.add("Pedro");
        arrayList.add("Under_World!");

        LinkedList<String> linkedList = convertir(arrayList);
        System.out.println("Imprimimos el ArrayList");
        for(String element : arrayList){
            System.out.print(element+" ");
        }
        System.out.println();
        System.out.println("Imprimimos la LinkedList");
        for(String element : linkedList){
            System.out.print(element+" ");
        }
    }
    public static LinkedList <String> convertir(ArrayList <String> lista){
        LinkedList<String> linkedList = new LinkedList();
        for(Object element: lista){
            linkedList.add(element.toString());
        }
        return linkedList;
    }
}
