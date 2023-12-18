package PoketMonster;
import java.util.Map;

public class PokemonBattle {
    private static final Map<String, String> typeAdvantages = Map.of (
        "Fire", "Water",
        "Water", "Grass",
        "Grass", "Fire"
    );

    public static PoketMonster getWinner(PoketMonster p1, PoketMonster p2) {
        String type1 = p1.getType().trim(), type2 = p2.getType().trim();
        
        if (type1.equals(type2))
            return null;
        
        String advantage = typeAdvantages.get(type1);
        
        if (advantage != null && advantage.equals(type2))
            return p2;

        return p1;
    }

    public static Integer getWinnerParameter(PoketMonster p1, PoketMonster p2) {
        String type1 = p1.getType().trim(), type2 = p2.getType().trim();
        
        if (type1.equals(type2))
            return 0;   // TIE
        
        String advantage = typeAdvantages.get(type1);
        
        if (advantage != null && advantage.equals(type2))
            return 1;   // PARAM2 WINS

        return -1;      // PARAM1 WINS
    }
}