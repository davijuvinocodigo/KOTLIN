/**
 * Funções Genéricas.
 *
 * @see [Generics](https://play.kotlinlang.org/byExample/01_introduction/06_Generics)
 */

class MutableStack<E>(vararg items: E) {              // 1

  private val elements = items.toMutableList()

  fun push(element: E) = elements.add(element)        // 2

  fun peek(): E = elements.last()                     // 3

  fun pop(): E = elements.removeAt(elements.size - 1)

  fun isEmpty() = elements.isEmpty()

  fun size() = elements.size

  override fun toString() = "MutableStack(${elements.joinToString()})"
}


// Função genérica para criar uma pilha mutável que recebe um número variável de argumentos de uma classe genérica E com argumentos de tipo vararg.
fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)


fun main() {
  val stack = mutableStackOf(0.62, 3.14, 2.7)
  val stack2QualquerCoisa = mutableStackOf("um", "dois", "tres")
  println(stack)
  println(stack2QualquerCoisa)
}