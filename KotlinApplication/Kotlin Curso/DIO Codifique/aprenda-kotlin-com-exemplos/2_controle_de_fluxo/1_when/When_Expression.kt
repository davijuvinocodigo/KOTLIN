/**
 * When Expression.
 *
 * @see [When]
    * When pode ser usado como uma expressão ou como uma instrução.
    * Quando usado como uma expressão, ele avalia cada condicional até encontrar um que corresponda ao valor fornecido e retorna o valor do bloco de código associado a esse condicional.
 */


fun whenExpression(obj: Any): Any {
    return when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
    }
}


fun main() {
    println(whenExpression(1))
    println(whenExpression("Hello"))
    println(whenExpression(1000L))
    println(whenExpression(2.5))
    println(whenExpression("other"))
}