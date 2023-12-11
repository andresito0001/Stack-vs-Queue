package DataStructures;

public abstract class Group<T> {
    public abstract T add(T data);      // data puede ser del tipo PoketMonster
    public abstract T remove();
    public abstract String show();
}