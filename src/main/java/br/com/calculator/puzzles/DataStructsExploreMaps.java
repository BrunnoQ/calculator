package br.com.calculator.puzzles;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class DataStructsExploreMaps {

    public static void main(String[] args) {

    }

    /*
     * Principais usos para um HashMap:
     * 
     * 1. Armazenamento de pares chave-valor: HashMap é usado para armazenar dados em pares
     * chave-valor, permitindo acesso rápido aos valores através das chaves.
     * 
     * 2. Implementação de caches: HashMap é frequentemente usado para implementar caches devido à
     * sua eficiência em operações de busca, inserção e remoção.
     * 
     * 3. Contagem de frequências: HashMap pode ser usado para contar a frequência de elementos em
     * uma coleção.
     * 
     * 4. Agrupamento de dados: HashMap pode ser usado para agrupar dados com base em uma chave
     * comum.
     * 
     * 5. Implementação de tabelas de símbolos: HashMap é usado em compiladores e interpretadores
     * para implementar tabelas de símbolos.
     * 
     */
    class HashMapExample {

        public void seiLa() {
            // Exemplo 1: Armazenamento de pares chave-valor
            HashMap<String, Integer> ageMap = new HashMap<>();
            ageMap.put("Alice", 30);
            ageMap.put("Bob", 25);
            ageMap.put("Charlie", 35);

            System.out.println("Age of Alice: " + ageMap.get("Alice"));

            // Exemplo 2: Implementação de caches
            HashMap<String, String> cache = new HashMap<>();
            cache.put("user1", "data1");
            cache.put("user2", "data2");

            System.out.println("Cache for user1: " + cache.get("user1"));

            // Exemplo 3: Contagem de frequências
            String[] words = {"apple", "banana", "apple", "orange", "banana", "apple"};
            HashMap<String, Integer> frequencyMap = new HashMap<>();
            for (String word : words) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }

            System.out.println("Frequency of 'apple': " + frequencyMap.get("apple"));

            // Exemplo 4: Agrupamento de dados
            HashMap<String, String> groupMap = new HashMap<>();
            groupMap.put("Group1", "Alice");
            groupMap.put("Group2", "Bob");
            groupMap.put("Group1", "Charlie"); // Substitui o valor anterior para a chave "Group1"

            System.out.println("Group1: " + groupMap.get("Group1"));

            // Exemplo 5: Implementação de tabelas de símbolos
            HashMap<String, String> symbolTable = new HashMap<>();
            symbolTable.put("x", "int");
            symbolTable.put("y", "float");

            System.out.println("Type of 'x': " + symbolTable.get("x"));
        }

    }


    /*
     * Principais usos para um LinkedHashMap:
     * 
     * 1. Armazenamento de pares chave-valor com ordem de inserção: LinkedHashMap é usado para
     * armazenar dados em pares chave-valor, mantendo a ordem de inserção.
     * 
     * 2. Implementação de caches com política de remoção: LinkedHashMap pode ser usado para
     * implementar caches com políticas de remoção, como LRU (Least Recently Used).
     * 
     * 3. Iteração previsível: A ordem de iteração de um LinkedHashMap é previsível e segue a ordem
     * em que os elementos foram inseridos.
     * 
     * 4. Manutenção de ordem de acesso: LinkedHashMap pode ser configurado para manter a ordem de
     * acesso, onde a ordem de iteração reflete a ordem em que as entradas foram acessadas.
     * 
     * 5. Agrupamento de dados com ordem: LinkedHashMap pode ser usado para agrupar dados com base
     * em uma chave comum, mantendo a ordem de inserção.
     */
    class DataStructsExploreLinkedHashMap {

        public void seiLa() {
            // Exemplo 1: Armazenamento de pares chave-valor com ordem de inserção
            LinkedHashMap<String, Integer> ageMap = new LinkedHashMap<>();
            ageMap.put("Alice", 30);
            ageMap.put("Bob", 25);
            ageMap.put("Charlie", 35);

            System.out.println("Age of Alice: " + ageMap.get("Alice"));

            // Exemplo 2: Implementação de caches com política de remoção
            LinkedHashMap<String, String> cache = new LinkedHashMap<>(16, 0.75f, true) {
                protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                    return size() > 3; // Limita o tamanho do cache a 3 entradas
                }
            };
            cache.put("user1", "data1");
            cache.put("user2", "data2");
            cache.put("user3", "data3");
            cache.put("user4", "data4"); // "user1" será removido

            System.out.println("Cache after adding user4: " + cache);

            // Exemplo 3: Iteração previsível
            for (Map.Entry<String, Integer> entry : ageMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Exemplo 4: Manutenção de ordem de acesso
            cache.get("user2"); // Acessa "user2" para movê-lo para o final
            cache.put("user5", "data5"); // "user3" será removido

            System.out.println("Cache after accessing user2 and adding user5: " + cache);

            // Exemplo 5: Agrupamento de dados com ordem
            LinkedHashMap<String, String> groupMap = new LinkedHashMap<>();
            groupMap.put("Group1", "Alice");
            groupMap.put("Group2", "Bob");
            groupMap.put("Group1", "Charlie"); // Substitui o valor anterior para a chave "Group1"

            System.out.println("Group1: " + groupMap.get("Group1"));
        }
    }

    /*
     * Principais usos para um HashTable:
     * 
     * 1. Armazenamento de pares chave-valor: HashTable é usado para armazenar dados em pares
     * chave-valor, permitindo acesso rápido aos valores com base nas chaves.
     * 
     * 2. Implementação de caches: HashTable pode ser usado para implementar caches, onde os dados
     * são armazenados temporariamente para acesso rápido.
     * 
     * 3. Sincronização: HashTable é sincronizado, o que significa que é seguro para uso em
     * ambientes multithreaded, onde múltiplos threads podem acessar e modificar a tabela
     * simultaneamente.
     * 
     * 4. Implementação de dicionários: HashTable pode ser usado para implementar dicionários, onde
     * palavras são mapeadas para seus significados ou outras informações associadas.
     * 
     * 5. Lookup eficiente: HashTable oferece uma maneira eficiente de realizar operações de busca,
     * inserção e remoção de pares chave-valor.
     */
    class DataStructsExploreHashTable {

        public void seiLa() {
            // Exemplo 1: Armazenamento de pares chave-valor
            Hashtable<String, Integer> studentGrades = new Hashtable<>();
            studentGrades.put("Alice", 90);
            studentGrades.put("Bob", 85);
            studentGrades.put("Charlie", 88);

            System.out.println("Nota de Alice: " + studentGrades.get("Alice"));

            // Exemplo 2: Implementação de caches
            Hashtable<String, String> cache = new Hashtable<>();
            cache.put("page1", "Conteúdo da página 1");
            cache.put("page2", "Conteúdo da página 2");

            System.out.println("Cache da página 1: " + cache.get("page1"));

            // Exemplo 3: Sincronização
            Hashtable<String, String> synchronizedTable = new Hashtable<>();
            synchronizedTable.put("key1", "value1");
            synchronizedTable.put("key2", "value2");

            synchronized (synchronizedTable) {
                for (String key : synchronizedTable.keySet()) {
                    System.out.println(key + ": " + synchronizedTable.get(key));
                }
            }

            // Exemplo 4: Implementação de dicionários
            Hashtable<String, String> dictionary = new Hashtable<>();
            dictionary.put("cachorro", "Animal de estimação");
            dictionary.put("gato", "Outro animal de estimação");

            System.out.println("Definição de cachorro: " + dictionary.get("cachorro"));

            // Exemplo 5: Lookup eficiente
            Hashtable<String, String> lookupTable = new Hashtable<>();
            lookupTable.put("123", "John Doe");
            lookupTable.put("456", "Jane Smith");

            System.out.println("Lookup para 123: " + lookupTable.get("123"));
        }
    }

    /*
     * Principais usos para um TreeMap:
     * 
     * 1. Armazenamento de pares chave-valor ordenados: TreeMap é usado para armazenar dados em
     * pares chave-valor, mantendo as chaves ordenadas de acordo com a ordem natural ou um
     * comparador fornecido.
     * 
     * 2. Implementação de dicionários ordenados: TreeMap pode ser usado para implementar
     * dicionários onde as entradas são mantidas em ordem alfabética ou outra ordem definida.
     * 
     * 3. Navegação de intervalos: TreeMap permite operações eficientes de navegação de intervalos,
     * como obter submapas, cabeçalhos e caudas de mapas.
     * 
     * 4. Implementação de tabelas de símbolos: TreeMap pode ser usado para implementar tabelas de
     * símbolos onde as chaves são identificadores e os valores são informações associadas.
     * 
     * 5. Lookup eficiente com ordenação: TreeMap oferece uma maneira eficiente de realizar
     * operações de busca, inserção e remoção de pares chave-valor, mantendo as chaves ordenadas.
     */

    public class DataStructsExploreTreeMap {

        public void seiLa() {
            // Exemplo 1: Armazenamento de pares chave-valor ordenados
            TreeMap<String, Integer> studentGrades = new TreeMap<>();
            studentGrades.put("Alice", 90);
            studentGrades.put("Bob", 85);
            studentGrades.put("Charlie", 88);

            System.out.println("Nota de Alice: " + studentGrades.get("Alice"));

            // Exemplo 2: Implementação de dicionários ordenados
            TreeMap<String, String> dictionary = new TreeMap<>();
            dictionary.put("cachorro", "Animal de estimação");
            dictionary.put("gato", "Outro animal de estimação");

            System.out.println("Definição de cachorro: " + dictionary.get("cachorro"));

            // Exemplo 3: Navegação de intervalos
            TreeMap<Integer, String> rangeMap = new TreeMap<>();
            rangeMap.put(1, "Um");
            rangeMap.put(2, "Dois");
            rangeMap.put(3, "Três");

            System.out.println("Submapa de 1 a 2: " + rangeMap.subMap(1, true, 2, true));

            // Exemplo 4: Implementação de tabelas de símbolos
            TreeMap<String, String> symbolTable = new TreeMap<>();
            symbolTable.put("x", "10");
            symbolTable.put("y", "20");

            System.out.println("Valor de x: " + symbolTable.get("x"));

            // Exemplo 5: Lookup eficiente com ordenação
            TreeMap<String, String> lookupTable = new TreeMap<>();
            lookupTable.put("123", "John Doe");
            lookupTable.put("456", "Jane Smith");

            System.out.println("Lookup para 123: " + lookupTable.get("123"));
        }
    }


}
