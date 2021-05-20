package generics.exercise;

import java.util.Iterator;

public class DefaultMyListParameterized<T> implements
        MyListParameterized<T>, ListIterableParameterized<T> {

    @Override
    public ListIteratorParameterized<T> listIterator() {
        return null;
    }

    @Override
    public void add(T e) {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
