package DataStructures;

public class ArrayTwo {
    /*Crea un array bidimensional de enteros y recórrelo,
    mostrando la posición y el valor de cada elemento en ambas dimensiones.*/
    public static void main(String[] args) {
    var array = new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9}
    };
    for(int i = 0; i < array.length; i++) {
        for(int j = 0; j < array[i].length; j++) {
            System.out.print(" Element:"+array[i][j] + " Position: " + ((int)(i+1))+"|"+((int)(j+1)));

        }
        System.out.println();
    }
    }

}
