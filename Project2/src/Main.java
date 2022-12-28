import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //EL IVA EN COLOMBIA ESTÁ EN EL 19%
        System.out.println("Ingrese el precio del producto:");
        Scanner sc = new Scanner(System.in);
        float price = sc.nextFloat();
        System.out.print(ivaFunction(price));

    }
    static float ivaFunction(float value){
        return value*1.19f;
    }
}