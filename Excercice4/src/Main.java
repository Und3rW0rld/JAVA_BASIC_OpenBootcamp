public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SmartDevice telefono = new SmartPhone(
                "192392932", "Samsung",
                "Galaxy",
                "12GB", "500GB",
                "Blue");
        SmartDevice reloj = new SmartWatch("Samsung"
                ,"CH11","4GB","64GB"
                ,"Black","12:30:24");
        System.out.println("IMPRIMIMOS EL TELEFONO");
        System.out.println(telefono);
        System.out.println("IMPRIMIMOS EL RELOJ");
        System.out.println(reloj);
    }
}