package functions.consumers;


import functions.DefaultProduct;
import functions.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainConsumer {

    public static void main(String[] args) {
        System.out.println("==== Consumer demo ====");
        List<Product> products = new ArrayList<>(Arrays.asList(
                new DefaultProduct(1, "Product 1", "Category 1", 99.99),
                new DefaultProduct(2, "Product 2", "Category 2", 149.99),
                new DefaultProduct(3, "Product 3", "Category 3", 39.99)
        ));

        increasePriceForProductList(products, 10);
        for(Product product : products) {
            System.out.println(product);
        }

        System.out.println("==== BiConsumer demo ====");
        Map<Integer, Product> productMap = new HashMap<>();
        productMap.put(1, new DefaultProduct(1, "Product 1", "Category 1", 99.99));
        productMap.put(2, new DefaultProduct(2, "Product 2", "Category 2", 149.99));
        productMap.put(3, new DefaultProduct(3, "Product 3", "Category 3", 39.99));

        increasePriceForProductMap(productMap, 10);
        for (Product product : productMap.values()) {
            System.out.println(product);
        }
    }

    private static void increasePriceForProductList(List<Product> products, double priceIncrement) {
        products.iterator()
                .forEachRemaining(product -> product.setPrice(product.getPrice() + priceIncrement));
    }

    private static void increasePriceForProductMap(Map<Integer, ? extends Product> idProductMap,
                                                   double priceIncrement) {
        idProductMap.forEach((id, product) -> product.setPrice(product.getPrice() + priceIncrement));
    }
}
