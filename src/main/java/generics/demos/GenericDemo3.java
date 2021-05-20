package generics.demos;

public class GenericDemo3<T> {

    private T t;

    private void setT(T t) {
        this.t = t;
    }

    private T getT() {
        return t;
    }

    public static void main(String[] args) {
        GenericDemo3<Integer> integerBox = new GenericDemo3<>();
        integerBox.setT(1);
        System.out.println(integerBox.getT());
        GenericDemo3<String> stringBox = new GenericDemo3<>();
        stringBox.setT("one");
        System.out.println(stringBox.getT());
    }
}
