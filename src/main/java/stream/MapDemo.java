package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo {

    public static void main(String[] args) {
        System.out.println("==== map() Demo ====");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        List<String> transform = collection.stream()
                .map(s -> s + "1")
                .collect(Collectors.toList());
        System.out.println("transform = " + transform);

        List<Integer> number = collection.stream()
                .map(s -> Integer.parseInt(s.substring(1)))
                .collect(Collectors.toList());
        System.out.println("number = " + number);

        System.out.println("==== mapToInt() Demo");
        int[] numberArray = collection.stream()
                .mapToInt(s -> Integer.parseInt(s.substring(1)))
                .toArray();
        System.out.println("numberArray = " + Arrays.toString(numberArray));

        System.out.println("==== flatMap() Demo ====");
        Collection<String> collection2 = Arrays.asList("1,2,0", "4,5");
        int sum1 = collection2.stream()
                .flatMap(p -> Arrays.asList(p.split(",")).stream())
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println("sum = " + sum1);

        System.out.println("==== flatMapToInt() Demo ====");
        int sum2 = collection2.stream()
                .flatMapToInt(p -> Arrays.asList(p.split(",")).stream()
                .mapToInt(Integer::parseInt))
                .sum();
        System.out.println("sum = " + sum2);
    }
}
