package stream;

import java.util.Arrays;
import java.util.Collection;

public class FindFirstAndSkipDemo {

    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        String first = collection.stream().findFirst().orElse("1");
        System.out.println("first = " + first);

        String last = collection.stream().skip(collection.size() - 1)
                .findAny().orElse("2");
        System.out.println("last = " + last);

        String find = collection.stream().filter("a3"::equals).findFirst().get();
        System.out.println("find = " + find);

        String third = collection.stream().skip(2).findFirst().get();
        System.out.println("third = " + third);
    }
}
