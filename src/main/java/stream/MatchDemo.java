package stream;

import java.util.Arrays;
import java.util.Collection;

public class MatchDemo {


    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        boolean isAnyA1 = collection.stream().anyMatch("a1"::equals);
        System.out.println("isAnyA1 = " + isAnyA1);
        boolean isAnyA4 = collection.stream().anyMatch("a4"::equals);
        System.out.println("isAnyA4 = " + isAnyA4);

        boolean isAll = collection.stream().allMatch(s -> s.contains("1"));
        System.out.println("isAll = " + isAll);

        boolean isNoneA5 = collection.stream().noneMatch("a5"::equals);
        System.out.println("isNoneA5 = " + isNoneA5);
    }
}
