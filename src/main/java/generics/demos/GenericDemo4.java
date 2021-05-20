package generics.demos;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo4 {

    public static void main(String[] args) {
        List<Child> children = new ArrayList<>();
        processElements(children);
        List<Parent> parents = new ArrayList<>();
        processElements2(children);
        processElements2(parents);
    }

    private static void processElements(List<? extends Parent> elements) {
        Parent p = elements.get(0);
        elements.add(null);
    }

    private static void processElements2(List<? super Child> elements) {
        Object o = elements.get(0);
        elements.add(new Child());
        elements.add(new GrandChild());
        elements.add(null);
    }
}

class Parent {}

class Child extends Parent {
    public void childSpecificMethod() {}
}

class GrandChild extends Child {}
