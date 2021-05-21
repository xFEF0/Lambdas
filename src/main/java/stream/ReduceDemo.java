package stream;

import java.util.Arrays;
import java.util.Collection;

public class ReduceDemo {

    public static void main(String[] args) {
        Collection<Integer> collection = Arrays.asList(1, 2, 3, 4, 2);
        Integer sum1 = collection.stream()
                .reduce((s1, s2) -> s1 + s2).orElse(0);

        Integer sum2 = collection.stream()
                .reduce(Integer::sum).orElse(0);
        System.out.println("sum1 = " + sum1 + "; sum2 = " + sum2);

        Integer max1 = collection.stream()
                .reduce((s1, s2) -> s1 > s2 ? s1 : s2).orElse(0);
        Integer max2 = collection.stream()
                .reduce(Integer::max).orElse(0);
        System.out.println("max1 = " + max1 + "; max2 = " + max2);

        Integer min1 = collection.stream()
                .reduce((s1, s2) -> s1 < s2 ? s1 : s2).orElse(0);
        Integer min2 = collection.stream()
                .reduce(Integer::min).orElse(0);
        System.out.println("min1 = " + min1 + "; min2 = " + min2);

        Integer last = collection.stream().reduce((s1, s2) -> s2).orElse(0);
        System.out.println("last = " + last);

        Integer sumGreaterThan2 = collection.stream()
                .filter(e -> e > 2)
                .reduce(Integer::sum).orElse(0);
        System.out.println("sumGreaterThan2 = " + sumGreaterThan2);

        Integer sumOdd = collection.stream()
                .filter(e -> e % 2 != 0)
                .reduce(Integer::sum).orElse(0);
        System.out.println("sumOdd = " + sumOdd);

        Collection<People> people = Arrays.asList(
                new People("William", 16, Sex.MAN),
                new People("John", 23, Sex.MAN),
                new People("Helen", 42, Sex.WOMAN),
                new People("Peter", 69, Sex.MAN),
                new People("Demi", 26, Sex.NON_BINARY)
        );
        int oldMan = people.stream()
                .filter(person -> person.getGender() == Sex.MAN)
                .map(People::getAge)
                .reduce((s1, s2) -> s1 > s2 ? s1 : s2).get();
        System.out.println("oldMan = " + oldMan);

        int youngerE = people.stream()
                .filter(person -> person.getName().contains("e"))
                .mapToInt(People::getAge)
                .reduce(Integer::min).orElse(0);
        System.out.println("youngerE = " + youngerE);
    }
}
