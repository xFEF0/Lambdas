package generics.exercise;

public class Node<T> {
    Node<T> previous;
    T data;
    Node<T> next;

    public Node(Node<T> previous, T data, Node<T> next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
