package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAndCountDemo {

    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        Collection<People> peopleList = Arrays.asList(
                new People("William", 16, Sex.MAN),
                new People("John", 23, Sex.MAN),
                new People("Helen", 42, Sex.WOMAN),
                new People("Peter", 69, Sex.MAN)
        );

        long a1Count = collection.stream().filter("a1"::equals).count();
        System.out.println("a1Count = " + a1Count);

        List<String> select1 = collection.stream()
                .filter(s -> s.contains("1"))
                .collect(Collectors.toList());
        System.out.println("select1 = " + select1);

        List<People> militaryService = peopleList.stream()
                .filter(people -> people.getAge() >= 18
                        && people.getAge() < 27
                        && Sex.MAN == people.getGender())
                .collect(Collectors.toList());
        System.out.println("militaryService = " + militaryService);

        double manAverageAge = peopleList.stream()
                .filter(p -> p.getGender() == Sex.MAN)
                .mapToInt(People::getAge)
                .average().getAsDouble();
        System.out.println("manAverageAge = " + manAverageAge);

        long peopleWhoCanWork = peopleList.stream()
                .filter(p -> p.getAge() >= 18)
                .filter(people -> (people.getGender() == Sex.WOMAN && people.getAge() < 55) ||
                                (people.getGender() == Sex.MAN && people.getAge() < 60)
                ).count();
        System.out.println("peopleWhoCanWork = " + peopleWhoCanWork);
    }
}
