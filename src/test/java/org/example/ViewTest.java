package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private View view;
    private Logic logic;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        logic = Mockito.mock(Logic.class);
        view = new View(logic);
    }

    @Test
    public void testMainMenuWhenCalledThenPrintsFilteredProductList() {
        List<Product> productList = Arrays.asList(
                new Product("Product1", 100),
                new Product("Product2", 200),
                new Product("Product3", 300)
        );

        when(logic.isiListProduct()).thenReturn(productList);

        view.mainMenu();

        String expectedOutput = "Pilih produk: \nProduct1\t|\t100\nProduct2\t|\t200\nProduct3\t|\t300\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testMainMenuWhenProductNameIsNullThenPrintsEmptyList() {
        List<Product> productList = Arrays.asList(
                new Product(null, 100),
                new Product("Product2", 200),
                new Product("Product3", 300)
        );

        when(logic.isiListProduct()).thenReturn(productList);

        view.mainMenu();

        String expectedOutput = "Pilih produk: \nProduct2\t|\t200\nProduct3\t|\t300\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testMainMenuWhenProductPriceIsNullThenPrintsEmptyList() {
        List<Product> productList = Arrays.asList(
                new Product("Product1", null),
                new Product("Product2", 200),
                new Product("Product3", 300)
        );

        when(logic.isiListProduct()).thenReturn(productList);

        view.mainMenu();

        String expectedOutput = "Pilih produk: \nProduct2\t|\t200\nProduct3\t|\t300\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainMenuWhenProductListNotEmptyThenPrintProductList() {
        when(logic.isiListProduct()).thenReturn(Collections.singletonList(new Product().setNama("Mie Ayam").setHarga(12000)));
        view.mainMenu();
        String expectedOutput = "Pilih produk: \nMie Ayam\t|\t12000\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testMainMenuWhenProductListEmptyThenNotPrintAnything() {
        when(logic.isiListProduct()).thenReturn(Collections.emptyList());
        view.mainMenu();
        String expectedOutput = "Pilih produk: \n";
        assertEquals(expectedOutput, outContent.toString());
    }
}