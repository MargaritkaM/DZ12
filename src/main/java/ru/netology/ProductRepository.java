package ru.netology;

public class ProductRepository {

    private Product[] products = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

//    public Product[] searchBy(String text) {
//        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
//        for (Product product : repo.getProducts()) {
//            if (matches(product, text)) {
//                // "добавляем в конец" массива result продукт product
//                Product[] tmp = new Product[result.length + 1];
//                for (int i = 0; i < result.length; i++) {
//                    tmp[i] = result[i];
//                }
//                tmp[tmp.length - 1] = product;
//                result = tmp;
//            }
//        }
//        return result;
//    }

//    public boolean matches(Product product, String search) {
//        if (product.getName().contains(search)) {
//            return true;
//        } else {
//            return false;
//        }


    public void removeById(int removeId) {
        if (findById(removeId) == null) {
            throw new NotFoundException(
                    "Id не найдено:" + removeId
            );
        }
        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != removeId) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }

    public Product findById(int id) {
        Product result = null;
        for (Product product : products) {
            if (product.getId() == id) {
                result = product;
                break;
            }
        }
        return result;
    }

    public Product[] getProducts() {
        return products;
    }

}
