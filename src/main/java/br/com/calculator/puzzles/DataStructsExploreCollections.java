package br.com.calculator.puzzles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class DataStructsExploreCollections {

    public static void main(String[] args) {


    }

    /**
     * 
     * 
     * Inserções e Remoções Frequentes:
     * 
     * Quando a aplicação necessita de muitas operações de inserção e remoção de elementos,
     * especialmente no início ou no meio da lista, uma LinkedList é mais eficiente do que uma
     * ArrayList. Isso ocorre porque a LinkedList não precisa deslocar elementos como a ArrayList.
     * Implementação de Filas e Deques:
     * 
     * LinkedList implementa as interfaces Queue e Deque, tornando-a uma escolha natural para
     * implementar filas (FIFO) e deques (double-ended queues). Acesso Sequencial:
     * 
     * Se a aplicação faz muitas operações de acesso sequencial (iterar sobre a lista), a LinkedList
     * pode ser eficiente. No entanto, para acesso aleatório (acessar elementos por índice), a
     * ArrayList é mais eficiente. Estruturas de Dados Complexas:
     * 
     * LinkedList pode ser usada para implementar outras estruturas de dados complexas, como listas
     * ligadas, pilhas e árvores.
     */
    class ArrayListExample {

        public void seila() {
            // Exemplo de Acesso Aleatório Rápido
            ArrayList<String> list = new ArrayList<>();
            list.add("A");
            list.add("B");
            list.add("C");
            System.out.println(list.get(1)); // Output: B

            // Exemplo de Armazenamento de Dados Temporários
            ArrayList<Integer> tempData = new ArrayList<>();
            tempData.add(10);
            tempData.add(20);
            tempData.add(30);
            System.out.println(tempData); // Output: [10, 20, 30]

            // Exemplo de Implementação de Pilha
            ArrayList<String> stack = new ArrayList<>();
            stack.add("First");
            stack.add("Second");
            stack.add("Third");
            System.out.println(stack.remove(stack.size() - 1)); // Output: Third

            // Exemplo de Lista Imutável
            ArrayList<String> immutableList = new ArrayList<>();
            immutableList.add("X");
            immutableList.add("Y");
            immutableList.add("Z");
            System.out.println(immutableList); // Output: [X, Y, Z]
        }
    }

    /**
     * Uma LinkedList é uma implementação da interface List que utiliza uma estrutura de dados de
     * lista duplamente encadeada. Aqui estão os principais usos para uma LinkedList:
     * 
     * Principais usos para uma LinkedList:
     * 
     * 1. Inserções e Remoções Frequentes: Quando a aplicação necessita de muitas operações de
     * inserção e remoção de elementos, especialmente no início ou no meio da lista, uma LinkedList
     * é mais eficiente do que uma ArrayList. Isso ocorre porque a LinkedList não precisa deslocar
     * elementos como a ArrayList.
     * 
     * 2. Implementação de Filas e Deques: LinkedList implementa as interfaces Queue e Deque,
     * tornando-a uma escolha natural para implementar filas (FIFO) e deques (double-ended queues).
     * 
     * 3. Acesso Sequencial: Se a aplicação faz muitas operações de acesso sequencial (iterar sobre
     * a lista), a LinkedList pode ser eficiente. No entanto, para acesso aleatório (acessar
     * elementos por índice), a ArrayList é mais eficiente.
     * 
     * 4. Estruturas de Dados Complexas: LinkedList pode ser usada para implementar outras
     * estruturas de dados complexas, como listas ligadas, pilhas e árvores.
     */
    class LinkedListExample {
        public void seila() {
            // Exemplo de Inserções e Remoções Frequentes
            LinkedList<String> linkedList = new LinkedList<>();
            linkedList.add("A");
            linkedList.add("B");
            linkedList.add("C");
            linkedList.add(1, "D");
            linkedList.remove(2);
            System.out.println(linkedList); // Output: [A, D, C]

            // Exemplo de Implementação de Fila
            Queue<String> queue = new LinkedList<>();
            queue.add("A");
            queue.add("B");
            queue.add("C");
            System.out.println(queue.poll()); // Output: A

            // Exemplo de Implementação de Deque
            Deque<String> deque = new LinkedList<>();
            deque.addFirst("A");
            deque.addLast("B");
            System.out.println(deque.removeLast()); // Output: B
        }
    }


    /**
     * Uma LinkedList é uma implementação da interface List que utiliza uma estrutura de dados de
     * lista duplamente encadeada. Aqui estão os principais usos para uma LinkedList:
     * 
     * Principais usos para uma LinkedList:
     * 
     * <p>
     * 1. Inserções e Remoções Frequentes: <br>
     * Quando a aplicação necessita de muitas operações de inserção e remoção de elementos,
     * especialmente no início ou no meio da lista, uma LinkedList é mais eficiente do que uma
     * ArrayList. Isso ocorre porque a LinkedList não precisa deslocar elementos como a ArrayList.
     * </p>
     * 
     * <p>
     * 2. Implementação de Filas e Deques: <br>
     * LinkedList implementa as interfaces Queue e Deque, tornando-a uma escolha natural para
     * implementar filas (FIFO) e deques (double-ended queues).
     * </p>
     * 
     * <p>
     * 3. Acesso Sequencial: <br>
     * Se a aplicação faz muitas operações de acesso sequencial (iterar sobre a lista), a LinkedList
     * pode ser eficiente. No entanto, para acesso aleatório (acessar elementos por índice), a
     * ArrayList é mais eficiente.
     * </p>
     * 
     * <p>
     * 4. Estruturas de Dados Complexas: <br>
     * LinkedList pode ser usada para implementar outras estruturas de dados complexas, como listas
     * ligadas, pilhas e árvores.
     * </p>
     */

    class QueueExample {
        public void seila() {
            // Cria uma fila
            Queue<String> queue = new LinkedList<>();

            // Adiciona elementos na fila
            queue.add("A");
            queue.add("B");
            queue.add("C");

            // Remove e retorna o primeiro elemento da fila
            System.out.println(queue.poll()); // Output: A

            // Retorna o primeiro elemento da fila sem removê-lo
            System.out.println(queue.peek()); // Output: B

            // Verifica se a fila está vazia
            System.out.println(queue.isEmpty()); // Output: false

        }
    }

    class DequeExample {
        public void seila() {
            Deque<String> deque = new LinkedList<>();

            // Adiciona elementos no início e no fim do deque
            deque.addFirst("A");
            deque.addLast("B");

            // Retorna o primeiro e o último elemento do deque
            System.out.println(deque.getFirst()); // Output: A
            System.out.println(deque.getLast()); // Output: B

            // Remove o último elemento do deque
            deque.pop();

            // Remove elemento do início do deque
            deque.removeFirst();
            deque.pop();

            // Remove e retorna o primeiro e o último elemento do deque
            System.out.println(deque.removeFirst()); // Output: A
            System.out.println(deque.removeLast()); // Output: B
        }
    }

    /**
     * A PriorityQueue é uma estrutura de dados que funciona como uma fila, mas onde cada elemento
     * tem uma prioridade associada. Os elementos com maior prioridade são removidos antes dos
     * elementos com menor prioridade.
     * 
     * Principais usos para um PriorityQueue:
     * 
     * 1. Agendamento de Tarefas: Usada em sistemas de agendamento onde tarefas com maior prioridade
     * devem ser executadas antes.
     * 
     * 2. Algoritmos de Grafos: Utilizada em algoritmos como Dijkstra para encontrar o caminho mais
     * curto.
     * 
     * 3. Processamento de Eventos: Em sistemas de simulação onde eventos com diferentes prioridades
     * precisam ser processados em ordem.
     * 
     * 4. Filas de Impressão: Em sistemas de impressão onde documentos com maior prioridade devem
     * ser impressos primeiro.
     * 
     * Exemplo de uso de PriorityQueue:
     */
    public class PriorityQueueExample {
        public void seila() {
            // Cria uma PriorityQueue
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

            // Adiciona elementos na PriorityQueue
            priorityQueue.add(4);
            priorityQueue.add(2);
            priorityQueue.add(5);
            priorityQueue.add(1);

            // Remove e retorna o elemento com a maior prioridade (menor valor)
            System.out.println(priorityQueue.poll()); // Output: 1
            System.out.println(priorityQueue.poll()); // Output: 2
            System.out.println(priorityQueue.poll()); // Output: 4
            System.out.println(priorityQueue.poll()); // Output: 5
        }
    }


    /**
     * Exemplo de uso de PriorityQueue com Comparator customizado:
     */
    public class CustomPriorityQueueExample {
        public void seila() {
            // Cria uma PriorityQueue com um Comparator customizado (ordem decrescente)
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

            // Adiciona elementos na PriorityQueue
            priorityQueue.add(4);
            priorityQueue.add(2);
            priorityQueue.add(5);
            priorityQueue.add(1);

            // Remove e retorna o elemento com a maior prioridade (maior valor)
            System.out.println(priorityQueue.poll()); // Output: 5
            System.out.println(priorityQueue.poll()); // Output: 4
            System.out.println(priorityQueue.poll()); // Output: 2
            System.out.println(priorityQueue.poll()); // Output: 1
        }

    }

    /*
     * Principais usos para um HashSet:
     * 
     * 1. Armazenamento de elementos únicos: HashSet é usado para armazenar elementos únicos, ou
     * seja, ele não permite elementos duplicados.
     * 
     * 2. Operações de conjunto: HashSet pode ser usado para realizar operações de conjunto como
     * união, interseção e diferença.
     * 
     * 3. Busca eficiente: HashSet oferece operações de busca eficientes (O(1) em média) devido à
     * sua implementação baseada em tabela hash.
     * 
     * 4. Remoção rápida: Remover elementos de um HashSet é geralmente rápido devido à sua estrutura
     * de dados subjacente. 5. Verificação de existência: Verificar se um elemento está presente em
     * um HashSet é eficiente.
     */

    class HashSetExample {
        public void seila() {
            // Exemplo 1: Armazenamento de elementos únicos
            HashSet<String> uniqueNames = new HashSet<>();
            uniqueNames.add("Alice");
            uniqueNames.add("Bob");
            uniqueNames.add("Charlie");
            uniqueNames.add("Alice"); // Este elemento não será adicionado novamente

            System.out.println("Unique Names: " + uniqueNames);

            // Exemplo 2: Operações de conjunto
            HashSet<Integer> set1 = new HashSet<>();
            set1.add(1);
            set1.add(2);
            set1.add(3);

            HashSet<Integer> set2 = new HashSet<>();
            set2.add(3);
            set2.add(4);
            set2.add(5);

            // União
            HashSet<Integer> union = new HashSet<>(set1);
            union.addAll(set2);
            System.out.println("Union: " + union);

            // Interseção
            HashSet<Integer> intersection = new HashSet<>(set1);
            intersection.retainAll(set2);
            System.out.println("Intersection: " + intersection);

            // Diferença
            HashSet<Integer> difference = new HashSet<>(set1);
            difference.removeAll(set2);
            System.out.println("Difference: " + difference);

            // Exemplo 3: Verificação de existência
            boolean contains = set1.contains(2);
            System.out.println("Set1 contains 2: " + contains);

            // Exemplo 4: Remoção rápida
            set1.remove(2);
            System.out.println("Set1 after removing 2: " + set1);
        }
    }

    /*
     * Principais usos para um LinkedHashSet:
     * 
     * 1. Armazenamento de elementos únicos com ordem de inserção: LinkedHashSet é usado para
     * armazenar elementos únicos, mantendo a ordem de inserção.
     * 
     * 2. Iteração previsível: A ordem de iteração de um LinkedHashSet é previsível e segue a ordem
     * em que os elementos foram inseridos.
     * 
     * 3. Operações de conjunto: LinkedHashSet pode ser usado para realizar operações de conjunto
     * como união, interseção e diferença, mantendo a ordem de inserção.
     * 
     * 4. Busca eficiente: LinkedHashSet oferece operações de busca eficientes (O(1) em média)
     * devido à sua implementação baseada em tabela hash.
     * 
     * 5. Remoção rápida: Remover elementos de um LinkedHashSet é geralmente rápido devido à sua
     * estrutura de dados subjacente. 6. Verificação de existência: Verificar se um elemento está
     * presente em um LinkedHashSet é eficiente.
     */
    class LinkedHashSetExample {
        public void seiLa() {
            // Exemplo 1: Armazenamento de elementos únicos com ordem de inserção
            LinkedHashSet<String> uniqueNames = new LinkedHashSet<>();
            uniqueNames.add("Alice");
            uniqueNames.add("Bob");
            uniqueNames.add("Charlie");
            uniqueNames.add("Alice"); // Este elemento não será adicionado novamente

            System.out.println("Unique Names: " + uniqueNames);

            // Exemplo 2: Operações de conjunto
            LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
            set1.add(1);
            set1.add(2);
            set1.add(3);

            LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
            set2.add(3);
            set2.add(4);
            set2.add(5);

            // União
            LinkedHashSet<Integer> union = new LinkedHashSet<>(set1);
            union.addAll(set2);
            System.out.println("Union: " + union);

            // Interseção
            LinkedHashSet<Integer> intersection = new LinkedHashSet<>(set1);
            intersection.retainAll(set2);
            System.out.println("Intersection: " + intersection);

            // Diferença
            LinkedHashSet<Integer> difference = new LinkedHashSet<>(set1);
            difference.removeAll(set2);
            System.out.println("Difference: " + difference);

            // Exemplo 3: Verificação de existência
            boolean contains = set1.contains(2);
            System.out.println("Set1 contains 2: " + contains);

            // Exemplo 4: Remoção rápida
            set1.remove(2);
            System.out.println("Set1 after removing 2: " + set1);
        }
    }

    /*
     * Principais usos para um TreeSet:
     * 
     * 1. Armazenamento de elementos únicos ordenados: TreeSet é usado para armazenar elementos
     * únicos em uma ordem natural ou definida por um comparador.
     * 
     * 2. Iteração ordenada: A ordem de iteração de um TreeSet é ordenada, seguindo a ordem natural
     * dos elementos ou a ordem definida por um comparador.
     * 
     * 3. Operações de conjunto: TreeSet pode ser usado para realizar operações de conjunto como
     * união, interseção e diferença, mantendo a ordem dos elementos.
     * 
     * 4. Busca eficiente: TreeSet oferece operações de busca eficientes (O(log n)) devido à sua
     * implementação baseada em árvore de busca binária.
     * 
     * 5. Subconjuntos: TreeSet permite a criação de subconjuntos baseados em intervalos de valores.
     * 
     * 6. Navegação: TreeSet oferece métodos para navegar pelos elementos, como `first()`, `last()`,
     * `headSet()`, `tailSet()`, etc.
     */

    public class TreeSetExample {
        public void sei() {
            // Exemplo 1: Armazenamento de elementos únicos ordenados
            TreeSet<String> uniqueNames = new TreeSet<>();
            uniqueNames.add("Alice");
            uniqueNames.add("Bob");
            uniqueNames.add("Charlie");
            uniqueNames.add("Alice"); // Este elemento não será adicionado novamente

            System.out.println("Unique Names: " + uniqueNames);

            // Exemplo 2: Operações de conjunto
            TreeSet<Integer> set1 = new TreeSet<>();
            set1.add(1);
            set1.add(2);
            set1.add(3);

            TreeSet<Integer> set2 = new TreeSet<>();
            set2.add(3);
            set2.add(4);
            set2.add(5);

            // União
            TreeSet<Integer> union = new TreeSet<>(set1);
            union.addAll(set2);
            System.out.println("Union: " + union);

            // Interseção
            TreeSet<Integer> intersection = new TreeSet<>(set1);
            intersection.retainAll(set2);
            System.out.println("Intersection: " + intersection);

            // Diferença
            TreeSet<Integer> difference = new TreeSet<>(set1);
            difference.removeAll(set2);
            System.out.println("Difference: " + difference);

            // Exemplo 3: Verificação de existência
            boolean contains = set1.contains(2);
            System.out.println("Set1 contains 2: " + contains);

            // Exemplo 4: Subconjuntos
            TreeSet<Integer> subset = new TreeSet<>(set1.subSet(1, 3));
            System.out.println("Subset from 1 to 3: " + subset);

            // Exemplo 5: Navegação
            System.out.println("First element: " + set1.first());
            System.out.println("Last element: " + set1.last());
        }
    }


}


