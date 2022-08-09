package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product product1 = new Product(11, "альбом", 550);
    Product product2 = new Product(1, "книга", 50);
    Product product3 = new Product(8, "шапка", 10);
    Product book1 = new Book(33, "книга", 660, "Пушкин");
    Product book2 = new Book(32, "книга", 670, "Пушкин");
    Product book3 = new Book(31, "книга", 680, "Достоевский");
    Product Smartphone1 = new Smartphone(13, "телефон", 300_550, "Apple");
    Product Smartphone2 = new Smartphone(14, "телефон", 100_550, "Samsung");
    Product Smartphone13 = new Smartphone(15, "телефон", 50_550, "Xiaomi ");

    ProductRepository repo = new ProductRepository();

    @BeforeEach
    public void setup() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
    }

    @Test
    public void saveGetProduct() {

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveGetProductBook() {

        repo.save(book1);

        Product[] expected = {product1, product2, product3, book1};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveGetProductBookSmartphone() {

        repo.save(book1);
        repo.save(Smartphone1);

        Product[] expected = {product1, product2, product3, book1, Smartphone1};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void delete() {

        repo.removeById(product1.getId());

        Product[] expected = {product2, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteId() {

        repo.removeById(8);

        Product[] expected = {product1, product2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteError() {

//        repo.removeById(3);
//
//        Product[] expected = {product2, product3};
//        Product[] actual = repo.getProducts();

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(14);
        });
    }
}
