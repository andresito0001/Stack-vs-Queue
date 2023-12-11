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

    private String name, type;
}