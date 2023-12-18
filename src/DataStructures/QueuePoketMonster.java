package DataStructures;
import PoketMonster.PoketMonster;

public class QueuePoketMonster extends Queue<PoketMonster> {
    public QueuePoketMonster() { }
    
    public QueuePoketMonster(Queue<PoketMonster> other) {
        this.elements = new List<>();

        int size = other.size();

        for (int i = 0; i < size; i++) {
            PoketMonster element = other.elements.getData(i);
            this.add(element);
        }
    }

    @Override
    public String show() {
        StringBuilder sb = new StringBuilder();
        Node<PoketMonster> current = elements.getNode(0);
       
        while (current != null) {
            sb.append(current.getData().getName() + "/" + current.getData().getType() + ", ");
            current = current.next;
        }
        
        return sb.toString().trim().substring(0, sb.length() - 2);
    }

    @Override
    public boolean contains(PoketMonster key) {
        for (int i = 0; i < this.size(); i++) {
            PoketMonster element = this.elements.getData(i);
            if (PoketMonster.isEqualsPokemons(element, key))
                return true;
        }
        return false;
    }

    public boolean containsType(String type) {
        for (int i = 0; i < this.size(); i++) {
            PoketMonster element = this.elements.getData(i);
            if (element.getType().equals(type))
                return true;
        }
        return false;
    }    
}
