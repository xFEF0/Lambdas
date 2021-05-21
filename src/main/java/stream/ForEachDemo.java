package stream;

import java.util.Arrays;
import java.util.Collection;

public class ForEachDemo {

    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        System.out.print("forEach = ");
        collection.stream().map(String::toUpperCase)
            .forEach(e -> System.out.print(e + ","));
        System.out.println();

        Collection<StringBuilder> list = Arrays.asList(
                new StringBuilder("a1"),
                new StringBuilder("a2"),
                new StringBuilder("a3")
        );
        list.stream().forEachOrdered(p -> p.append("_new"));
        System.out.println("forEachOrdered = " + list);
    }
}
