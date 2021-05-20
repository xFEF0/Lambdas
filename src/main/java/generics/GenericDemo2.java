package generics;

public class GenericDemo2 {

    public static void main(String[] args) {
        String[] strings = {"Audi", "Acura", "Aston Martin"};
        System.out.printf("Max of %s, %s and %s is %s\n", strings[0], strings[1], strings[2],
                maxValueOf(strings[0], strings[1], strings[2]));
        Integer[] integers = {1, -5, 22};
        System.out.printf("Max of %s, %s and %s is %s\n", integers[0], integers[1], integers[2],
                maxValueOf(integers[0], integers[1], integers[2]));
    }

    private static <T extends Comparable<T>> T maxValueOf(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }
}
