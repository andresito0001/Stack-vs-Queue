package DataStructures;

public class Stack<T> extends Group<T> {
    public Stack() {
        this.elements = new List<>();
    }

    public Stack(Stack<T> otherStack) {
        this.elements = new List<>();

        int size = otherStack.size();

        for (int i = 0; i < size; i++) {
            T element = otherStack.elements.getData(i);
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
            throw new RuntimeException("Stack is empty");

        return elements.remove(elements.size() - 1);
    }
    
    public T peek() {
        if (elements.isEmpty())
            throw new RuntimeException("Stack is empty");

        return elements.getData(elements.size() - 1);
    }

    public boolean contains(T key) {
        for (int i = 0; i < this.size(); i++) {
            T element = this.elements.getData(i);
            if (element.equals(key))
                return true;
        }
        return false;
    }

    public boolean isEmpty() { return elements.isEmpty(); }
    public int size() { return elements.size(); }
    
    public String show() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = elements.getNode(0);

        while (current != null) {
            sb.append(current.getData().toString()).append(" ");
            current = current.next;
        }
        return sb.toString();
    }

    protected List<T> elements;
}

