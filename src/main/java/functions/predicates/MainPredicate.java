package functions.predicates;

import functions.DefaultProduct;
import functions.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MainPredicate {

    public static void main(String[] args) {
        System.out.println("==== Predicate demo ====");
        List<Product> products = new ArrayList<>(Arrays.asList(
                new DefaultProduct(1, "Product 1", "Category 1", 99.99),
                new DefaultProduct(2, "Product 2", "Category 2", 149.99),
                new DefaultProduct(3, "Product 3", "Category 3", 39.99)
        ));

        removeProductIfPriceIsMoreThan(products, 100);
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("==== Predicate.and() demo ====");
        removeProductIfPriceIsMoreThanAndCategoryIsEqualTo(products, 90, "Category 1");
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("==== Predicate.isEqual() demo ====");
        List<User> users = new ArrayList<>(Arrays.asList(
                new UserForHashTables(1, "John", "Smith",
                        "password", "john.smith@email.com"),
                new UserForHashTables(2, "Ivan", "Ivanov",
                        "password", "ivan.ivanov@email.com"),
                new UserForHashTables(3, "Harsha", "Anand",
                        "password", "harsha.anand@email.com")
        ));

        User criteriaUser = new UserForHashTables(1, "John", "Smith",
                "password", "john.smith@email.com");

        users.removeIf(Predicate.not(Predicate.isEqual(criteriaUser)));
        for (User user : users) {
            System.out.println(user);
        }
    }

    private static void removeProductIfPriceIsMoreThanAndCategoryIsEqualTo(List<Product> products,
                                                                           int limit,
                                                                           String category) {
        Predicate<Product> isPriceMoreThan = product -> product.getPrice() > limit;
        Predicate<Product> isCategoryEqualTo = product -> product.getCategory().equals(category);
        products.removeIf(isPriceMoreThan.and(isCategoryEqualTo));
    }

    private static void removeProductIfPriceIsMoreThan(List<Product> products, int limit) {
        products.removeIf(product -> product.getPrice() > limit);
    }
}
