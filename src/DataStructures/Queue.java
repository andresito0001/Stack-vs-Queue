package DataStructures;

public class Queue<T> extends Group<T>{
    public Queue() { this.elements = new List<>(); }

    public Queue(Queue<T> other) {
        this.elements = new List<>();

        int size = other.size();

        for (int i = 0; i < size; i++) {
            T element = other.elements.getData(i);
            this.add(element);
        }
    }

    public T add(T data) {
        return elements.add(data);
    }

    public T addFirst(T data) {
        return elements.addFirst(data);
    }

    public T remove() {
        if (elements.isEmpty())
            throw new RuntimeException("Queue is empty");

        return elements.remove(0);
    }
    
    public boolean contains(T key) {
        for (int i = 0; i < this.size(); i++) {
            T element = this.elements.getData(i);
            if (element.equals(key))
                return true;
        }
        return false;
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = elements.getNode(0);

        while (current != null) {
            sb.append(current.getData().toString()).append(" ");
            current = current.next;
        }
        return sb.toString();
    }

    public T peek() {
        if (elements.isEmpty())
            throw new RuntimeException("Queue is empty");

        return elements.getData(0);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() { return elements.size(); }
    
    protected List<T> elements;
}