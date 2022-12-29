import Clases.CocheCRUDImpl;
import com.Interfaces.underworld.CocheCRUD;

public class Main {
    public static void main(String[] args) {
        CocheCRUD cocheCRUD = new CocheCRUDImpl();
        
        cocheCRUD.save();
        cocheCRUD.findAll();
        cocheCRUD.delete();
    }
}