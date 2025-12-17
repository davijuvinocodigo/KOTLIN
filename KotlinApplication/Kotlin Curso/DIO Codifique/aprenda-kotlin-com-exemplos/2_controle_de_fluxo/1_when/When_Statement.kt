/**
 * When Statement.
 *
 * @see [When]  
    * When pode ser usado como uma expressão ou como uma instrução.
    * Quando usado como uma instrução, ele avalia cada condicional até encontrar um que corresponda ao valor fornecido e executa o bloco de código associado a esse condicional.
 */

fun cases(obj: Any) {
    when (obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }
}

fun main() {
    cases(1)
    cases("Hello")
    cases(1000L)
    cases(2.5)
    cases("other")
}