import java.io.File;

import DataStructures.QueuePoketMonster;
import DataStructures.StackPoketMonster;
import IOFile.FReader;
import IOFile.FWriter;
import PoketMonster.PokemonBattle;
import PoketMonster.PokemonValidator;
import PoketMonster.PoketMonster;

public class Main {
    public static void main(String[] args) {
        FWriter fWriter = new FWriter(".." + File.separator, "output.mpdm");
        FReader fReader = new FReader(".." + File.separator + "test" + File.separator + args[0]);

        String str = fReader.getString();
        String[] fileString = str.split("\n");

        // all pokedex
        StackPoketMonster stackPoketMonsterPokedex = new StackPoketMonster();
        QueuePoketMonster queuePoketMonsterPokedex = new QueuePoketMonster();

        // all team
        StackPoketMonster stackPoketMonsterTeam = new StackPoketMonster();
        QueuePoketMonster queuePoketMonsterTeam = new QueuePoketMonster();

        for (int i = 0; i < fileString.length;) {
            String key = fileString[i].trim();
            
            switch (key) {
                case "CREATE STACK POKEDEX": {
                    if ((i + 1) >= fileString.length)
                        throw new IndexOutOfBoundsException("Index bounds, File format Format error");

                    if (!PokemonValidator.isValidPokemonListFormat(fileString[i + 1])) {
                        throw new IllegalArgumentException("Pokemon list is not valid format");
                    }

                    String[] splitArgs = fileString[i + 1].trim().split(",");

                    for (String it : splitArgs) {
                        String[] parts = it.trim().split("/");
                        PoketMonster pokemon = new PoketMonster(parts[0], parts[1]);
                        
                        if (stackPoketMonsterPokedex.contains(pokemon))
                            throw new IllegalArgumentException("There cannot be repeated pokemons in the stack");

                        stackPoketMonsterPokedex.add(new PoketMonster(parts[0], parts[1]));
                    }

                    i += 2;
                } break;

                case "CREATE QUEUE POKEDEX": {
                    if ((i + 1) >= fileString.length)
                        throw new IndexOutOfBoundsException("Index bounds, File format Format error");

                    if (!PokemonValidator.isValidPokemonListFormat(fileString[i + 1]))
                        throw new IllegalArgumentException("Pokemon list is not valid forma " + key);
                    
                    String[] splitArgs = fileString[i + 1].trim().split(",");

                    for (String it : splitArgs) {
                        String[] parts = it.trim().split("/");
                        PoketMonster pokemon = new PoketMonster(parts[0], parts[1]);

                        if (queuePoketMonsterPokedex.contains(pokemon))
                            throw new IllegalArgumentException("There cannot be repeated pokemons in the queue");
                        
                        queuePoketMonsterPokedex.add(new PoketMonster(parts[0], parts[1]));
                    }

                    i += 2;
                } break;

                case "SHOW STACK POKEDEX": {
                    if (stackPoketMonsterPokedex.isEmpty())
                        throw new RuntimeException("Stack pokedex is empty");

                    fWriter.writeFile(stackPoketMonsterPokedex.show());
                    fWriter.writeFile("\n");
                    i += 1; 
                } break;

                case "SHOW QUEUE POKEDEX": {
                    if (queuePoketMonsterPokedex.isEmpty())
                        throw new RuntimeException("Queue pokedex is empty");
                    
                    fWriter.writeFile(queuePoketMonsterPokedex.show());
                    fWriter.writeFile("\n");
                    i += 1;
                } break;
                
                case "CREATE STACK TEAM": {
                    if ((i + 1) >= fileString.length)
                        throw new IndexOutOfBoundsException("Index bounds, File format error");

                    if (!PokemonValidator.isValidTypeListFormat(fileString[i + 1].trim()) && fileString[i + 1].trim().length() > stackPoketMonsterPokedex.size())
                        throw new IllegalArgumentException("Invalid pokemon type list");

                    if (stackPoketMonsterPokedex.isEmpty())
                        throw new RuntimeException("Stack is empty");
                    
                    String argStringTypes = fileString[i + 1].trim();
                    String[] argsTypesSplit = argStringTypes.split(" ");

                    if (!PokemonValidator.pokemonIsAvailableInPokedex(stackPoketMonsterPokedex.show().trim(), argStringTypes))
                        throw new IllegalArgumentException("There are no pokemons available in pokedex for a type");
                    
                    for (String type : argsTypesSplit)
                        if (!stackPoketMonsterPokedex.containsType(type))
                           throw new IllegalArgumentException("Invalid pokemon types: the specified type was not found");

                    for (int count = 0, j = 0; count < stackPoketMonsterPokedex.size(); ++count) {
                        StackPoketMonster auxStackPoketMonsterPokedex = new StackPoketMonster(stackPoketMonsterPokedex);
            
                        while (true) {
                            PoketMonster poketMonster = auxStackPoketMonsterPokedex.remove();
                            if (!stackPoketMonsterTeam.isEmpty() && stackPoketMonsterTeam.contains(poketMonster)) 
                                continue;
            
                            if (poketMonster == null || j >= argsTypesSplit.length)
                                break;
            
                            if (poketMonster.getType().trim().equals(argsTypesSplit[j])) {
                                stackPoketMonsterTeam.add(poketMonster);
                                ++j;
                                break;
                            }
                        }
                    }
                    i += 2;
                } break;

                case "SHOW STACK TEAM": {
                    if (stackPoketMonsterTeam.isEmpty())
                        throw new RuntimeException("Stack team is empty");
                    
                    fWriter.writeFile("STACK TEAM " + stackPoketMonsterTeam.show());
                    fWriter.writeFile("\n");
                    i += 1;
                } break;

                case "CREATE QUEUE TEAM": {
                    if ((i + 1) >= fileString.length)
                        throw new IndexOutOfBoundsException("Index bounds, File format Format error");

                    if (!PokemonValidator.isValidTypeListFormat(fileString[i + 1].trim()) && fileString[i + 1].trim().length() > queuePoketMonsterPokedex.size())
                        throw new IllegalArgumentException("Invalid pokemon type list");

                    if (queuePoketMonsterPokedex.isEmpty())
                        throw new RuntimeException("Queue pokedex is empty");
                    
                    String argStringTypes = fileString[i + 1].trim();
                    String[] argsTypesSplit = argStringTypes.split(" ");

                    if (!PokemonValidator.pokemonIsAvailableInPokedex(queuePoketMonsterPokedex.show().trim(), argStringTypes))
                        throw new IllegalArgumentException("There are no pokemons available in pokedex for a type");
                    
                    for (String type : argsTypesSplit)
                        if (!queuePoketMonsterPokedex.containsType(type))
                            throw new IllegalArgumentException("Invalid pokemon types: the specified type was not found");

                    for (int count = 0, j = 0; count < queuePoketMonsterPokedex.size(); ++count) {
                        QueuePoketMonster auxQueuePokedex = new QueuePoketMonster(queuePoketMonsterPokedex);
            
                        while (true) {
                            PoketMonster poketMonster = auxQueuePokedex.remove();
                            if (!queuePoketMonsterTeam.isEmpty() && queuePoketMonsterTeam.contains(poketMonster)) 
                                continue;
            
                            if (poketMonster == null || j >= argsTypesSplit.length)
                                break;
            
                            if (poketMonster.getType().trim().equals(argsTypesSplit[j])) {
                                queuePoketMonsterTeam.add(poketMonster);
                                ++j;
                                break;
                            }
                        }
                    }
                    i += 2;
                } break;

                case "SHOW QUEUE TEAM": {
                    if (queuePoketMonsterTeam.isEmpty())
                        throw new RuntimeException("Queue team is empty");
                    
                    fWriter.writeFile("QUEUE TEAM " + queuePoketMonsterTeam.show());
                    fWriter.writeFile("\n");
                    i += 1;
                } break;

                case "ENCOUNTER": {
                    if (stackPoketMonsterTeam.isEmpty() || queuePoketMonsterTeam.isEmpty())
                        throw new RuntimeException("Queue team or Stack team empty");
                    
                    String win = new String("");
                    Integer turn = 1;
                    Integer tieCounter = 0;
                    
                    while (!stackPoketMonsterTeam.isEmpty() && !queuePoketMonsterTeam.isEmpty() && tieCounter <= 3) {
                        PoketMonster pkStackTeam = stackPoketMonsterTeam.peek();
                        PoketMonster pkQueueTeam = queuePoketMonsterTeam.peek();

                        fWriter.writeFile("TURN: " + turn + "\n" + pkStackTeam.getName() + "/" + pkStackTeam.getType() + " vs " + pkQueueTeam.getName() + "/" + pkQueueTeam.getType() + " -> ");

                        Integer winner = PokemonBattle.getWinnerParameter(pkStackTeam, pkQueueTeam);
   
                        switch (winner) {
                            case 1: {
                                stackPoketMonsterTeam.remove();
                                PoketMonster auxPoketMonster = queuePoketMonsterTeam.remove();
                                queuePoketMonsterTeam.addFirst(auxPoketMonster);
                                fWriter.writeFile(pkQueueTeam.getName() + "/" + pkQueueTeam.getType());
                                fWriter.writeFile("\n");
                            } break;
                            case -1: {
                                queuePoketMonsterTeam.remove();
                                fWriter.writeFile(pkStackTeam.getName() + "/" + pkStackTeam.getType());
                                fWriter.writeFile("\n");
                            } break;
                            case 0: {
                                if (queuePoketMonsterTeam.size() == 1 && stackPoketMonsterTeam.size() == 1) {
                                    win = "TIE";
                                    tieCounter = 3;
                                }
                                
                                queuePoketMonsterTeam.remove();
                                stackPoketMonsterTeam.remove();
                                fWriter.writeFile("TIE\n");

                                tieCounter++;
                            } break;
                            default: { throw new RuntimeException("An error ocurred"); }
                        }

                        turn++;
                    }

                    win =   stackPoketMonsterTeam.size() > 0 
                                    ? new String("STACK TEAM WINS") : 
                                    queuePoketMonsterTeam.size() > 0 ? new String("QUEUE TEAM WINS") 
                                    : new String("TIE");
                    fWriter.writeFile(win);

                    i += 1;
                } break;
                default: { throw new IllegalArgumentException("ERROR unknown command: : " + key); }
            }
        }
    }
}