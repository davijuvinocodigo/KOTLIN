/**
 * Funções Genéricas.
 *
 * @see [Generics](https://play.kotlinlang.org/byExample/01_introduction/06_Generics)
 */

class MutableStack<E>(vararg items: E) {             

  private val elements = items.toMutableList()

  fun push(element: E) = elements.add(element)        

  fun peek(): E = elements.last()                   

  fun pop(): E = elements.removeAt(elements.size - 1)

  fun isEmpty() = elements.isEmpty()

  fun size() = elements.size

  override fun toString() = "MutableStack(${elements.joinToString()})"
}

/**

    *<E>: É um parâmetro de tipo genérico. Permite que a função trabalhe com qualquer tipo de dado (como Double, String, etc.), sem precisar especificar o tipo antecipadamente. O tipo E é inferido automaticamente com base nos argumentos passados.

    *vararg elements: E:

      * vararg significa "variable arguments" (argumentos variáveis). Permite passar um número indefinido de argumentos do tipo E.
      * elements é o nome do parâmetro que representa a lista de argumentos recebidos.
      * = MutableStack(*elements):
      É uma função de expressão única (single-expression function), que retorna diretamente o resultado.
      MutableStack(*elements) cria uma nova instância da classe MutableStack<E>.
      O operador * (spread operator) "desempacota" a lista elements (que é um Array<E> internamente) em argumentos individuais para o construtor de MutableStack.

 */
fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)


fun main() {
  val stack = mutableStackOf(0.62, 3.14, 2.7)
  val stack2QualquerCoisa = mutableStackOf("um", "dois", "tres")
  println(stack)
  println(stack2QualquerCoisa)
}