package generics.demos;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo5 {

    public static void main(String[] args) {
        // Generics are useful during compilation time
        List<Integer> integers = new ArrayList<>();
        List list = new ArrayList();
        list = integers;
        list.add("String");
        Integer integer = integers.get(0);
        System.out.println(integer);
    }
}
