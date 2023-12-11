package DataStructures;

public class Queue<T> extends Group<T>{
    public Queue() { this.elements = new List<>(); }

    public T add(T elemento) {
        return elements.add(elemento);
    }

    public T remove() {
        if (elements.isEmpty())
            throw new RuntimeException("Queue is empty");

        return elements.remove(0);
    }

    public String show() {
        Node<T> current = elements.getNode(0);
        String queueElelemntsToString = "";

        while(current != null) {
            queueElelemntsToString += current.getData().toString() + " ";
            current = current.next;
        }

        return queueElelemntsToString.toString();
    }

    public T peek() {
        if (elements.isEmpty())
            throw new RuntimeException("Queue is empty");

        return elements.getData(0);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    private List<T> elements;
}