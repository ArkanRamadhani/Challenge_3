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
                        .setNama("Mie Ayam")
                        .setHarga(12000),
                new Product()
                        .setNama("Bakso Urat")
                        .setHarga(13000),
                new Product()
                        .setNama("Bakso Telor")
                        .setHarga(15000),
                new Product()
                        .setNama("Nasi Goreng")
                        .setHarga(10000)
        );
    }

    public Product getProduct(int input) {
        return Optional.ofNullable(isiListProduct().get(input - 1)).orElse(new Product());
    }

    public void tambahOrder(Integer kuantitas, int input) {
        boolean add = this.Orders.add(
                Order.builder()
                        .nama(this.getProduct(input).getNama())
                        .kuantitas(kuantitas)
                        .totalHarga(this.getProduct(input).getHarga() * kuantitas)
                        .build()
        );
    }
}