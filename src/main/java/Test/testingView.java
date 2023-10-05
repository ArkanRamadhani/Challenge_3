package Test;

import org.example.Logic;
import org.example.View;
import org.junit.jupiter;
public class testingView {
    @Test
    public void testView() {
        View view = new View();
        view.mainMenu();
    }

    @Test
    public void testGetProduct() {
        Logic logic = new Logic();
        System.out.println("Nama :" + logic.getProduct(2).getNama());
        System.out.println("Harga :" + logic.getProduct(2).getHarga());
    }
}



