package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Getter
public class Logic {
    private final List<Order> Orders = new ArrayList<>();

    public List<Product> isiListProduct() {
        return Arrays.asList(
                new Product()
                        .nama("Mie Ayam")
                        .harga(12000),
                new Product()
                        .nama("Bakso Urat")
                        .harga(13000),
                new Product()
                        .nama("Bakso Telor")
                        .harga(15000),
                new Product()
                        .nama("Nasi Goreng")
                        .harga(10000)
        );
    }

    public Product getProduct(int input) {
        return Optional.ofNullable(isiListProduct().get(input - 1)).orElse(new Product());
    }
}


    public void tambahOrder() {
        tambahOrder(4, 4);
    }

    public void tambahOrder(Integer kuantitas, int input) {
        this.Orders.add(
                Order.builder()
                        .nama(this.getProduct(input).getNama())
                        .kuantitas(kuantitas)
                        .totalHarga(this.getProduct(input).getHarga() * kuantitas)
                        .build()
        );
    }

};
