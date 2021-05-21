package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctDemo {

    public static void main(String[] args) {
        Collection<String> ordered = Arrays.asList("a1", "a2", "a2", "a3", "a1", "a2", "a2");
        Collection<String> nonOrdered = new HashSet<>(ordered);
        List<String> distinct = nonOrdered.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinct = " + distinct);

        List<String> distinctOrdered = ordered.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinctOrdered = " + distinctOrdered);
    }
}
