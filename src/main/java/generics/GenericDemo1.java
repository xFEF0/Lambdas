package generics;

public class GenericDemo1 {

    public static void main(String[] args) {
        String[] stringArray = {"one", "two", "three"};
        Integer[] inteArray = {1, 2, 3};
        printArray(stringArray);
        printArray(inteArray);
    }

    private static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.println("Element: " + element);
        }
    }
}
