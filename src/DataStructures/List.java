package DataStructures;

public class List<T> {
    public List() {
        this.head = null;
        this.tail = null;
    }

    public T add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) { 
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        this.size++;

        return newNode.getData();
    }

    public T addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    
        this.size++;
        return data;
    }

    public T remove(Integer index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
    
        Node<T> node = getNode(index);

        if (node == head) {
            head = node.next;
        } else {
            Node<T> previusNode = getNode(index - 1);
            previusNode.next = node.next;
        }
    
        node.next = null;

        size--;
    
        return node.data;
    }

    public void show() {
        Node<T> current = this.head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    
    public T getData(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Node<T> current = head;

        for (int i = 0; i < index; ++i) {
            current = current.next;
        }

        return current.data;
    }
    
    public Node<T> getNode(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Node<T> current = head;

        for (int i = 0; i < index; ++i) {
            current = current.next;
        }

        return current;
    }

    public boolean isEmpty() { return this.head == null; }
    public int size() { return this.size; }
    public void incrementSize() { this.size++; }
    
    private int size;
    private Node<T> head;
    private Node<T> tail;

}
