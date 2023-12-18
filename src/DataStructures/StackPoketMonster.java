package DataStructures;

import PoketMonster.PoketMonster;

public class StackPoketMonster extends Stack<PoketMonster> {
    public StackPoketMonster() { }
    
    @Override
    public String show() {
        StringBuilder sb = new StringBuilder();
        for (int i = this.elements.size() - 1; i >= 0; i--)
            sb.append(this.elements.getData(i).getName() + "/" + elements.getData(i).getType() + ", ");

        return sb.toString().trim().substring(0, sb.length() - 2);
    }

    public StackPoketMonster(Stack<PoketMonster> other) {
        this.elements = new List<>();
        int size = other.size();
        
        for (int i = 0; i < size; i++) {
            PoketMonster element = other.elements.getData(i);
            this.add(element);
        }
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