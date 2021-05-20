package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsDemo {

    public static void main(String[] args) {
        System.out.println("==== filter() & map() & collect() demo ====");
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("iPhone", 1099.99, 1345),
                new Product("Boots", 49.99, 15200),
                new Product("SSD", 234.99, 900),
                new Product("HP Laptop", 2599.99, 876),
                new Product("Sony PlayStation", 2004.99, 1001)
        ));

        List<Product> modifiedProducts = products.stream()
                .filter(product -> product.getExistence() > 1000)
                .peek(product -> product.setPrice(product.getPrice() - product.getPrice() * 0.1))
                .collect(Collectors.toList());
        modifiedProducts.forEach(System.out::println);

        System.out.println("==== flatMap() demo ====");
        Warehouse warehouse1 = new Warehouse();
        Warehouse warehouse2 = new Warehouse();
        Warehouse warehouse3 = new Warehouse();

        warehouse1.setProducts(new ArrayList<>(Collections.singletonList(
                new Product("iPhone", 1099.99, 1345)
        )));
        warehouse2.setProducts(new ArrayList<>(Arrays.asList(
                new Product("Boots", 49.99, 15200),
                new Product("SSD", 234.99, 900)
        )));
        warehouse3.setProducts(new ArrayList<>(Arrays.asList(
                new Product("HP Laptop", 2599.99, 876),
                new Product("Sony PlayStation", 2004.99, 1001)
        )));

        List<Warehouse> warehouses = new ArrayList<>(Arrays.asList(
                warehouse1,
                warehouse2,
                warehouse3
        ));

        Product[] productsArray = warehouses.stream()
                .flatMap(warehouse -> warehouse.getProducts().stream())
                .filter(product -> product.getExistence() > 1000)
                .peek(product -> product.setPrice(product.getPrice() - product.getPrice() * 0.1))
                .toArray(Product[]::new);
        Arrays.stream(productsArray).forEach(System.out::println);

        System.out.println("==== toMap() demo ====");
        Map<String, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getName, Function.identity()));
        System.out.println(productMap);

        System.out.println("==== mapToInt() & sum() demo ====");
        int totalItemsAmount = products.stream()
                .mapToInt(Product::getExistence)
                .sum();
        System.out.println("Items in warehouse: " + totalItemsAmount);
    }
}
