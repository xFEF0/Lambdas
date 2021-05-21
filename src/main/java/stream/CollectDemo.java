package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectDemo {

    public static void main(String[] args) {
        Collection<String> strings = Arrays.asList("a1", "b2", "c3", "a1");
        List<String> distinct = strings.stream().distinct().collect(Collectors.toList());
        System.out.println("distinct = " + distinct);

        String[] array = strings.stream().distinct().map(String::toUpperCase).toArray(String[]::new);
        System.out.println("array = " + Arrays.asList(array));

        String join = strings.stream().collect(Collectors.joining(" : ", "<b> ", " </b>"));
        System.out.println("join = " + join);

        Map<String, String> map = strings.stream()
                .distinct()
                .collect(Collectors.toMap(
                        p -> p.substring(0, 1),
                        p -> p.substring(1, 2)
                ));
        System.out.println("map = " + map);

        Map<String, List<String>> groups = strings.stream()
                .collect(Collectors.groupingBy(p -> p.substring(0, 1)));
        System.out.println("groups = " + groups);

        Map<String, String> groupJoin = strings.stream()
                .collect(Collectors.groupingBy(
                        p -> p.substring(0, 1),
                        Collectors.mapping(
                                p -> p.substring(1, 2),
                                Collectors.joining(" : ")
                        )
                ));
        System.out.println("groupJoin = " + groupJoin);

        Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        long sumOdd = numbers.stream()
                .collect(Collectors.summingInt(
                        p -> p % 2 == 1 ? p : 0
                ));
        System.out.println("sumOdd = " + sumOdd);

        double average = numbers.stream().collect(Collectors.averagingInt(
                p -> p - 1
        ));
        System.out.println("average = " + average);

        IntSummaryStatistics statistics = numbers.stream()
                .collect(Collectors.summarizingInt(p -> p + 3));
        System.out.println("statistics = " + statistics);

        long sumEven = numbers.stream()
                .collect(Collectors.summarizingInt(
                        p -> p % 2 == 0 ? p : 0
                ))
                .getSum();
        System.out.println("sumEven = " + sumEven);

        Map<Boolean, List<Integer>> parts = numbers.stream()
                .collect(Collectors.partitioningBy(
                        p -> p % 2 == 0
                ));
        System.out.println("parts = " + parts);
    }
}
