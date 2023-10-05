package org.example;

import java.util.List;
import java.util.stream.Collectors;


public class View {

    Logic logic = new Logic();

    public View(Logic logic) {
    }

    public void mainMenu() {
        System.out.println("Pilih produk: ");
        List<Product> ProductList = logic.isiListProduct().stream()
                .filter(Product -> org.example.Product.getNama() != null && Product.getHarga() != null)
                .peek(Product -> System.out.println(Product.getNama() + "\t|\t" + Product.getHarga()))
                .collect(Collectors.toList());
    }
}

}
