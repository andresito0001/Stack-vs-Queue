package DataStructures;

public class Node<T> {
    public Node (T data) {
        this.data = data;
        this.next = null;
    }
    
    public T getData() { return this.data; }
    public Node<T> getNext() { return next; }

    public void setData(T data) { this.data = data; }
    public void setNext(Node<T> next) { this.next = next; }

    public T data;
    public Node<T> next;
}
