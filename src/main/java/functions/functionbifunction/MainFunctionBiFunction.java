package functions.functionbifunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class MainFunctionBiFunction {

    private static final Double DISCOUNT_RATE = 0.1;

    public static void main(String ...args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        System.out.println("====Function type demo====");
        System.out.println("map.get(4): " + map.get(4));
        map.computeIfAbsent(4, key -> Integer.toString(key));
        System.out.println("map.get(4): " + map.get(4));
        map.computeIfAbsent(5, FunctionsDemoCollections::convertIntToString);
        System.out.println("map.get(5): " + map.get(5));

        System.out.println("====BiFunction type demo====");
        map.computeIfPresent(3, (key, value) -> key + " : " + value);
        System.out.println("map.get(3): " + map.get(3));
        map.computeIfPresent(2, FunctionsDemoCollections::combineIntAndString);
        System.out.println("map.get(2): " + map.get(2));

        System.out.println("====Compose Functions type demo====");
        Map<Product, Double> productDiscountMap = new HashMap<>();
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product(1, 1.55),
                new Product(2, 3.30),
                new Product(3, 2.25)
        ));

        for (Product product : products) {
            Function<Product, Double> getPriceFunction = Product::getPrice;
            Function<Double, Double> getDiscountFunction = price -> price * DISCOUNT_RATE;
            // In both cases showed below,
            // getPriceFunction is executed first, and used as the input of getDiscountFunction
            Function<Product, Double> getPriceAndThenDiscountFunction =
                    getPriceFunction.andThen(getDiscountFunction);
            Function<Product, Double> getPriceAndThenDiscountFunction2 =
                    getDiscountFunction.compose(getPriceFunction);
            productDiscountMap.computeIfAbsent(product, getPriceAndThenDiscountFunction);
        }
        System.out.println(productDiscountMap);

        System.out.println("====Comparator.comparing() demo====");
        products.sort(Comparator.comparing(Product::getPrice));
        System.out.println(products);
    }
}
