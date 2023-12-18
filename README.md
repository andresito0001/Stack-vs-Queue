# Stack vs Queue: a simple project to apply data structures concepts
Este programa lee comandos de un archivo de texto y simula una batalla de Pokémones entre dos equipos, uno en pila y el otro en cola.

## Data Structures
- `StackPoketMonster` : Una pila que almacena objetos del tipo PoketMonster.

- `QueuePoketMonster` : Una cola que almacena objetos del tipo PoketMonster.

## Clases PoketMonster

**PokemonValidator**

La clase `PokemonValidator` proporciona métodos estáticos para validar el formato y la contenido de datos relacionados con Pokémon.

+ **Campos**

-`VALID_TYPES` : Un arreglo constante que contiene los tipos de Pokémon válidos `("Fire", "Water", "Grass")`.

+ **Metodos**

- `isValidPokemonListFormat(String pokemonList)`: Devuelve `true` si la cadena `pokemonList` representa una lista válida de Pokémon en formato `"nombre/tipo, nombre/tipo, ..."`.
- `isValidPokemon(String pokemon)`: Devuelve `true` si la cadena pokemon representa un Pokémon válido en formato `"nombre/tipo"` (NO USADO EN EL PROGRAMA).
- `pokemonIsAvailableInpokedex(String pokedex, String types)`: Devuelve true si al menos un tipo de Pokémon de la lista `types` está disponible en la cadena `"pokedex"` que representa una pila o cola de de una pokedex.

**PokemonBattle**

Esta clase se encarga de determinar el ganador en una batalla entre dos objetos de tipo PoketMonster. Ofrece dos métodos principales:

- `getWinner(PoketMonster p1, PoketMonster p2)`:

    + Obtiene los tipos de ambos Pokemon, los `trim()` para eliminar espacios iniciales y finales.
    + Verifica si ambos tipos son iguales. Si lo son, devuelve null indicando un empate.
    + Obtiene la ventaja del tipo del Primer Pokemon usando el mapa `typeAdvantages`.
    + Si la ventaja existe y coincide con el tipo del Segundo Pokemon, entonces el Segundo Pokemon ganó (devuelve `p2`) si no el primer pokemon `p1` gana.

- `getWinnerParameter(PoketMonster p1, PoketMonster p2)`: Devuelve un entero que indica el resultado de la batalla:
    + `0:` Empate
    + `1:` El segundo parametro `p2` gana
    + `-1` El primer parametro `p1` gana


**Atributos**
- `typeAdvantages`: Mapa estático que relaciona un tipo de Pokemon con otro que tiene ventaja sobre él. Se inicializa con un `Map.of` que define las ventajas básicas entre Fuego, Agua y Planta.

**Notas**

- La lógica de ventajas se limita a Fuego, Agua y Planta en este ejemplo. Se puede ampliar para incluir más tipos y sus relaciones en el mapa typeAdvantages.
- Se podrían agregar comprobaciones de nulidad para los objetos PoketMonster recibidos como parámetros.


## Función Main
1. Lee comandos de un archivo de texto usando un objeto `FReader`. Estos comando deben introducirse dentro de la carpeta `test` creando un archivo con el formato `mytest.mpdm`.
2. Procesa cada comando analizándolo y tomando la acción adecuada.
3. Las acciones posibles son.
- Creación y gestión de pokedex (tanto de pila como de cola).
- Creación y gestión de equipos (tanto stack como cola).
- Simular un encuentro entre los dos equipos.
4. Escribe la salida en un archivo usando un objeto `FWriter`.

## Comandos
- `CREATE STACK POKEDEX [pokemon list]` : Crea una pila para la pokedex y la completa con la lista especificada de pokemons.
- `CREATE QUEUE POKEDEX [pokemon list]` : Crea una cola para la pokedex y la completa con la lista especificada de pokemons.
- `SHOW STACK POKEDEX` : Escribe el contenido de la pila pokedex en el archivo `output.mpdm`.
- `SHOW queue POKEDEX` : Escribe el contenido de la cola pokedex en el archivo `output.mpdm`.
- `CREATE STACK TEAM [types list]` : Crea un equipo pila basado en la lista especificada de tipos de Pokémon. Los Pokémon se eligen de la pokedex disponible hasta que no haya más argumentos. En caso de no haber suficientes tipos de pokemmones disponibles en la pokedex, generará un error y mostrara en la consola el siguiente mensaje `"There are no pokemons available in pokedex for a type"`.
- `CREATE QUEUE TEAM [types list]` : Crea un equipo cola basado en la lista especificada de tipos de Pokémon. Los Pokémon se eligen de la pokedex disponible hasta que no haya más argumentos. En caso de no haber suficientes tipos de pokemmones disponibles en la pokedex, generará un error y mostrara en la consola el siguiente mensaje `"There are no pokemons available in pokedex for a type"`.
- `SHOW STACK TEAM` : Imprime el contenido del equipo pila en el archivo de salida.
- `SHOW QUEUE TEAM` : Imprime el contenido del equipo pila en el archivo de salida.
- `ENCOUNTER` : Simula una batalla entre el equipo de la pila y el equipo de la cola con las siguiente reglas.
- 1. Existe un ganador si algún equipo se queda sin pokemones.
- 2. Si se enfrentan dos pokemones del mismo tipo automáticamente quedan eliminados.
- 3. Hay un empate cuando existen mas de 3 efrentameintos empatados.
- 4. Hay un empate si ambs equipos se quedan con un pokemon.

## Instrucciones de compilación
Abra una temrinal de Linux o Powershell y escirbe el sigueinte comando:
```
$ git clone https://github.com/andresito0001/Stack-vs-Queue.git
```

Una vez clonado el repositorio navegué hasta la carpeta `./src` para ello puede usar el comando `cd .\Stack-vs-Queue\` y luego use:

```
$ javac *.java
```

Para ejecutar el proyecto debe escribirescriba

```
$ java .\Main.java your-test-file.mpdm
```


## Ejemplos de entrada y salida
```
test.mpdm
CREATE STACK POKEDEX
Chikorita/Grass, Feraligatr/Water, Piplup/Water
CREATE QUEUE POKEDEX
Blastoise/Water, Feraligatr/Water, Sceptile/Grass, Gorebyss/Water, Piplup/Water, Tepig/Fire, Torchic/Fire, Typhlosion/Fire, Rapidash/Fire
SHOW STACK POKEDEX
CREATE STACK TEAM
Grass Water
CREATE QUEUE TEAM
Fire Fire Fire
SHOW STACK TEAM
SHOW QUEUE TEAM
ENCOUNTER
```

```
output.mpdm
Piplup/Water, Feraligatr/Water, Chikorita/Grass
STACK TEAM Piplup/Water, Chikorita/Grass
QUEUE TEAM Tepig/Fire, Torchic/Fire, Typhlosion/Fire
TURN: 1
Piplup/Water vs Tepig/Fire -> Piplup/Water
TURN: 2
Piplup/Water vs Torchic/Fire -> Piplup/Water
TURN: 3
Piplup/Water vs Typhlosion/Fire -> Piplup/Water
STACK TEAM WINS
```



## Notas adicionales
- El código utiliza varias clases y funciones auxiliares para validación, entrada/salida y simulación de batalla.
- El programa asume que el archivo de entrada existe y está formateado correctamente.
- El manejo de errores se incluye para varios escenarios, como comandos no válidos, datos faltantes y equipos vacíos.



## Autores
Rebanales, Andres   CI: 28.057.599

Gonzales, Italo     CI: 30.218.200