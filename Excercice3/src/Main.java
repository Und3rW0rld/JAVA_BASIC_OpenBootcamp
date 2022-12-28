public class Main {
    public static void main(String[] args) {
        String[] Nombres = {"Pepito", "Anita", "Juanito", "Carlos"};
        String text = "";
        for(String i: Nombres){
            text += i+" ";
        }
        System.out.println(text);
    }
}