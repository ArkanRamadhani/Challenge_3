package Test;

import org.example.Logic;
import org.example.View;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testingView {

    private View view;
    private Logic logic;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUp() {
        logic = Mockito.mock(Logic.class);
        view = new View(logic);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testViewWhenCalledThenMainMenuExecuted() {
        // Arrange
        when(logic.isiListProduct()).thenReturn(Arrays.asList(
                Product.builder()
                        .nama("Mie Ayam")
                        .harga(12000)
                        .build(),
                Product.builder()
                        .nama("Bakso Urat")
                        .harga(13000)
                        .build(),
                Product.builder()
                        .nama("Bakso Telor")
                        .harga(15000)
                        .build(),
                Product.builder()
                        .nama("Nasi Goreng")
                        .harga(10000)
                        .build()
        ));

        // Act
        view.mainMenu();

        // Assert
        String expectedOutput = "Pilih produk: \n" +
                "Mie Ayam\t|\t12000\n" +
                "Bakso Urat\t|\t13000\n" +
                "Bakso Telor\t|\t15000\n" +
                "Nasi Goreng\t|\t10000\n";
        assertTrue(outContent.toString().contains(expectedOutput));
    }
}

public class testingView {

    @Test
    public void testViewWhenCalledThenNoException() {
        // Arrange
        View view = new View();

        // Act and Assert
        Assertions.assertDoesNotThrow(() -> view.mainMenu());
    }
}

public class testingView {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testViewWhenCalledThenNoExceptions() {
        // Arrange
        View view = new View();

        // Act
        view.mainMenu();

        // Assert
        String output = outContent.toString();
        assertTrue(output.contains("Pilih produk: "));
    }

    @Test
    public void testGetProduct() {
        // Arrange
        Logic logic = new Logic();

        // Act
        logic.getProduct(2);

        // Assert
        String output = outContent.toString();
        assertTrue(output.contains("Nama :"));
        assertTrue(output.contains("Harga :"));
    }
}

public class testingView {

    @Test
    public void testViewWhenCalledThenNoException() {
        // Arrange
        View view = new View();

        // Act and Assert
        Assertions.assertDoesNotThrow(() -> view.mainMenu(), "mainMenu method of View class should not throw an exception");
    }
}

public class testingView {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testViewWhenCalledThenMainMenuExecuted() {
        // Arrange
        Logic logicMock = Mockito.mock(Logic.class);
        Mockito.when(logicMock.isiListProduct()).thenReturn(Arrays.asList(
                new Product().setNama("Mie Ayam").setHarga(12000),
                new Product().setNama("Bakso Urat").setHarga(13000),
                new Product().setNama("Bakso Telor").setHarga(15000),
                new Product().setNama("Nasi Goreng").setHarga(10000)
        ));

        View view = new View();
        view.setLogic(logicMock);

        // Act
        view.mainMenu();

        // Assert
        String expectedOutput = "Pilih produk: \n" +
                "Mie Ayam\t|\t12000\n" +
                "Bakso Urat\t|\t13000\n" +
                "Bakso Telor\t|\t15000\n" +
                "Nasi Goreng\t|\t10000\n";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testGetProduct() {
        Logic logic = new Logic();
        System.out.println("Nama :" + logic.getProduct(2).getNama());
        System.out.println("Harga :" + logic.getProduct(2).getHarga());
    }
}

public class testingView {

    private View view;
    private Logic logic;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUp() {
        logic = Mockito.mock(Logic.class);
        view = new View(logic);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testViewWhenCalledThenMainMenuExecuted() {
        // Arrange
        when(logic.isiListProduct()).thenReturn(Arrays.asList(
                new Product().setNama("Mie Ayam").setHarga(12000),
                new Product().setNama("Bakso Urat").setHarga(13000),
                new Product().setNama("Bakso Telor").setHarga(15000),
                new Product().setNama("Nasi Goreng").setHarga(10000)
        ));

        // Act
        view.mainMenu();

        // Assert
        String expectedOutput = "Pilih produk: \n" +
                "Mie Ayam\t|\t12000\n" +
                "Bakso Urat\t|\t13000\n" +
                "Bakso Telor\t|\t15000\n" +
                "Nasi Goreng\t|\t10000\n";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testGetProduct() {
        // Arrange
        when(logic.getProduct(2)).thenReturn(new Product().setNama("Bakso Urat").setHarga(13000));

        // Act
        Product product = logic.getProduct(2);

        // Assert
        assertEquals("Bakso Urat", product.getNama());
        assertEquals(13000, product.getHarga());
    }
}