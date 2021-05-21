package stream;

import java.util.Arrays;
import java.util.Collection;

public class MinMaxDemo {

    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        String max = collection.stream().max(String::compareTo).get();
        System.out.println("max = " + max);

        String min = collection.stream().min(String::compareTo).get();
        System.out.println("min = " + min);

        Collection<People> people = Arrays.asList(
                new People("William", 16, Sex.MAN),
                new People("John", 23, Sex.MAN),
                new People("Helen", 42, Sex.WOMAN),
                new People("Peter", 69, Sex.MAN),
                new People("Demi", 28, Sex.NON_BINARY)
        );

        People older = people.stream()
                .max((p1, p2) -> p1.getAge().compareTo(p2.getAge())).get();
        System.out.println("older = " + older);

        People younger = people.stream()
                .min((p1, p2) -> p1.getAge().compareTo(p2.getAge())).get();
        System.out.println("younger = " + younger);
    }
}
