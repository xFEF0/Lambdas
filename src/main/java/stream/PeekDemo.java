package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PeekDemo {

    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        System.out.print("peek1 = ");
        List<String> peek = collection.stream().map(String::toUpperCase)
                .peek(e -> System.out.print(e + ","))
                .collect(Collectors.toList());
        System.out.println();
        System.out.println("peek2 = " + peek);

        Collection<StringBuilder> list = Arrays.asList(
                new StringBuilder("a1"),
                new StringBuilder("a2"),
                new StringBuilder("a3")
        );
        List<StringBuilder> newList = list.stream()
                .peek(p -> p.append("_new"))
                .collect(Collectors.toList());
        System.out.println("newList = " + newList);
    }
}
