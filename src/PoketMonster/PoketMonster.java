package PoketMonster;

public class PoketMonster {
    public PoketMonster(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void setName(String name) { this.name = name; }

    public String getName() { return this.name; }

    public void setType(String type) { this.type = type; }

    public String getType() { return this.type; }

    public static boolean isEqualsPokemons(PoketMonster p1, PoketMonster p2) {
        return p1.getName().trim().equals(p2.getName().trim()) &&
            p1.getType().trim().equals(p2.getType().trim());
    }

    private String name, type;
}