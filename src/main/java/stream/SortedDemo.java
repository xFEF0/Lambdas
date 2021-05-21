package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SortedDemo {

    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4");
        List<String> sorted = collection.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted = " + sorted);

        List<String> sortedDistinct = collection.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println("sortedDistinct = " + sortedDistinct);

        List<String> sortedReverse = collection.stream()
                .sorted(((o1, o2) -> -o1.compareTo(o2)))
                .collect(Collectors.toList());
        System.out.println("sortedReverse = " + sortedReverse);

        List<String> sortedReverseDistinct = collection.stream()
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("sortedReverseDistinct = " + sortedReverseDistinct);

        Collection<People> people = Arrays.asList(
                new People("William", 16, Sex.MAN),
                new People("John", 23, Sex.MAN),
                new People("Helen", 42, Sex.WOMAN),
                new People("Peter", 69, Sex.MAN)
        );
        Collection<People> byName = people.stream()
                .sorted((o1, o2) -> -o1.getName().compareTo(o2.getName()))
                .collect(Collectors.toList());
        System.out.println("byName = " + byName);

        Collection<People> bySexAndAge = people.stream()
                .sorted((o1, o2) -> o1.getGender() != o2.getGender() ?
                        o1.getGender().compareTo(o2.getGender()) : o1.getAge().compareTo(o2.getAge()))
                .collect(Collectors.toList());
        System.out.println("bySexAndAge = " + bySexAndAge);
    }
}
