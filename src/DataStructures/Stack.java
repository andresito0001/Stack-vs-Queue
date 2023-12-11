package DataStructures;

public class Stack<T> extends Group<T> {
    public Stack() {
        this.elements = new List<>();
    }

    public T add(T data) {
       return elements.add(data);
    }

    public T remove() {
        if (elements.isEmpty())
            throw new RuntimeException("Stack is empty");

        return elements.remove(elements.size() - 1);
    }
    
    public T peek() {
        if (elements.isEmpty())
            throw new RuntimeException("Stack is empty");

        return elements.getData(elements.size() - 1);
    }

    public boolean isEmpty() { return elements.isEmpty(); }

    /**
     * Posiblemente cambie esta funcion a algo mejor...
     * el tema es que no me gusta que tenga que invocar a toString()
     * varias veces
     */
    public String show() {
        Node<T> current = elements.getNode(0);
        String stackElementsToString = "";

        while (current != null) {
            stackElementsToString += current.getData().toString() + " ";
            current = current.next;
        }

        return stackElementsToString.toString();
    }
    
    private List<T> elements;
}