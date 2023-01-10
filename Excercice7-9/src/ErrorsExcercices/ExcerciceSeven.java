package ErrorsExcercices;

public class ExcerciceSeven {

    public static void main(String[] args) {
        /*
        * Crea una función DividePorCero. Esta, debe generar una excepción ("throws")
        * a su llamante del tipo ArithmeticException que será capturada por su llamante (desde "main", por
        * ejemplo). Si se dispara la excepción, mostraremos el mensaje "Esto no puede hacerse".
        * Finalmente, mostraremos en cualquier caso: "Demo de código".
        * */

        System.out.println(dividePorCero(2,0));

    }
    public static int dividePorCero(int a, int b) throws ArithmeticException {
        int result;
        try {
            result = a / b;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Esto no puede hacerse");
        }finally {
            System.out.println("Demo de codigo");
        }
        return result;
    }
}
