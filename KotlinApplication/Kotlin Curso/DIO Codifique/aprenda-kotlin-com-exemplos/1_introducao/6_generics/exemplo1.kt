/**
 * Classes Genéricas.
 *
 * @see [Generics](https://play.kotlinlang.org/byExample/01_introduction/06_Generics)
 * Generics permitem criar classes, interfaces e funções que podem trabalhar com diferentes tipos de forma segura em tempo de compilação.
 * Isso significa que você pode criar componentes reutilizáveis que funcionam com diferentes tipos de dados, sem a necessidade de duplicar código para cada tipo específico.
 */

class MutableStack<E>(vararg items: E) {              // 1 Cria uma classe genérica MutableStack que pode armazenar elementos de qualquer tipo E

  private val elements = items.toMutableList()        // 2 Inicializa uma lista mutável para armazenar os elementos da pilha

  fun push(element: E) = elements.add(element)        // 3 Adiciona um elemento do tipo E ao topo da pilha

  fun peek(): E = elements.last()                     // 4 Retorna o elemento do topo da pilha sem removê-lo

  fun pop(): E = elements.removeAt(elements.size - 1) // 5 Remove e retorna o elemento do topo da pilha 

  fun isEmpty() = elements.isEmpty()                  // 6 Verifica se a pilha está vazia

  fun size() = elements.size                        // 7 Retorna o número de elementos na pilha

  override fun toString() = "MutableStack(${elements.joinToString()})" // 8 funcão override que sobrescreve o método toString para fornecer uma representação legível da pilha
}


fun main() {
  val stack = MutableStack("A", "B", "C")   // 9 Cria uma instância da pilha genérica com elementos do tipo String
  stack.push("D")                           // 10 Adiciona o elemento "D" à pilha
  println(stack)                            // 11 Imprime o estado atual da pilha

  println("peek(): ${stack.peek()}")        // 12 Exibe o elemento do topo da pilha sem removê-lo
  println(stack)                            // 13 Imprime o estado atual da pilha

  for (i in 1..stack.size()) {              // 14 Itera sobre os elementos da pilha
    println("pop(): ${stack.pop()}")        
    
                                            // 15 Remove e exibe o elemento do topo da pilha
    println(stack)                          // 16 Imprime o estado atual da pilha
  }
}