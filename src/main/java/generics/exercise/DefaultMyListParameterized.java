package generics.exercise;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DefaultMyListParameterized<T> implements
        MyListParameterized<T>, ListIterableParameterized<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public ListIteratorParameterized<T> listIterator() {
        return null;
    }

    @Override
    public void add(T element) {
        final Node<T> lastNode = last;
        final Node<T> newNode = new Node<>(lastNode, element, null);
        if (lastNode == null) {
            first = newNode;
        } else {
            lastNode.next = newNode;
        }
        size++;
    }

    @Override
    public void clear() {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;
            x.data = null;
            x.next = null;
            x.previous = null;
            x = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.data == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.data.equals(o)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    private Object unlink(Node<T> element) {
        Object o = element.data;
        Node<T> next = element.next;
        Node<T> previous = element.previous;

        if (previous == null) {
            first = next;
        } else {
            previous.next = next;
            element.previous = null;
        }

        if (next == null) {
            last = previous;
        } else {
            next.previous = previous;
            element.next = null;
        }

        element.data = null;
        size--;
        return o;
    }

    public Object removeNodeByIndex(int index) {
        return unlink(getNodeByIndex(index));

    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> node = null;
        if (index <= (size-1)) {
            if (index < (size >> 1)) {
                node = first;
                for (int i = 0; i < index; i++) {
                    node = node.next;
                }
            } else {
                node = last;
                for (int i = size - 1; i > index; i--) {
                    node = node.previous;
                }
            }
        }
        return node;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int index = 0;
        for (Node<T> x = first; x != null; x = x.next) {
            result[index++] = x.data;
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.data == null) {
                    return true;
                }
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.data.equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(MyListParameterized<?> c) {
        Object[] array = c.toArray();
        for (Object o : array) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl<>();
    }

    @Override
    public String toString() {
        if (first == null) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder("{");
        for (Node<T> x = first; x != null; x = x.next) {
            stringBuilder.append("[")
                    .append(x.data);
            if(x.next == null) {
                break;
            }
            stringBuilder.append("], ");
        }
        return stringBuilder.append("]}").toString();
    }

    private class ListIteratorImplParameterized<T> extends IteratorImpl<T>
            implements ListIteratorParameterized<T> {

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public T previous() {
            cursor -= 1;
            Node<T> previous = (Node<T>) getNodeByIndex(cursor);
            if (previous == null) {
                cursor = 0;
                throw new NoSuchElementException();
            }
            return previous.data;
        }

        @Override
        public void set(T element) {
            if (lastRet < 0) {
                throw new IllegalStateException();
            } else {
                Node<T> x = (Node<T>)getNodeByIndex(lastRet);
                x.data = element;
                lastRet = -1;
            }
        }
    }

    private class IteratorImpl<T> implements Iterator<T> {
        int cursor = 0;
        int lastRet = -1;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            Node<T> next = (Node<T>) getNodeByIndex(cursor);
            if (next == null) {
                throw new NoSuchElementException();
            }
            lastRet = cursor;
            cursor++;
            return next.data;
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            } else {
                DefaultMyListParameterized.this.removeNodeByIndex(lastRet);
                if (lastRet < cursor) {
                    cursor--;
                }
                lastRet = -1;
            }
        }
    }
}
