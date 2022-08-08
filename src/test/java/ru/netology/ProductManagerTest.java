package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Product(11, "альбом", 550);
    Product product2 = new Product(1, "книга", 50);
    Product product3 = new Product(8, "шапка", 10);
    Product book1 = new Book(33, "книга", 660, "Пушкин");
    Product book2 = new Book(32, "книга", 670, "Пушкин");
    Product book3 = new Book(31, "книга", 680, "Достоевский");
    Product Smartphone1 = new Smartphone(13, "телефон", 300_550, "Apple");
    Product Smartphone2 = new Smartphone(14, "телефон", 100_550, "Samsung");
    Product Smartphone13 = new Smartphone(15, "телефон", 50_550, "Xiaomi ");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
    }

    @Test
    public void addProduct() {

        Product[] expected = {product1, product2, product3, book1, book2, book3};
        Product[] actual = manager.getAllProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findProduct() {


        Product[] expected = {product3};
        Product[] actual = manager.searchBy("шапка");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findSomeProduct() {


        Product[] expected = {product2, book1, book2, book3};
        Product[] actual = manager.searchBy("книга");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findFalseProduct() {


        Product[] expected = {};
        Product[] actual = manager.searchBy("стена");

        Assertions.assertArrayEquals(expected, actual);
    }
}
