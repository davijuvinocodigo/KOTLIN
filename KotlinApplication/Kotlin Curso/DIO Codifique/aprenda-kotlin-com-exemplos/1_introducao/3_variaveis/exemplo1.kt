/**
 * Variáveis: [var] e [val].
 * var: variável mutável.
 * val: variável imutável (constante).
 * @see [Variables](https://play.kotlinlang.org/byExample/01_introduction/03_Variables)
 */
fun main() {

    var a: String = "initial"  // 1
    println(a) // variável inicializada e mutável pode ser alterada
    a = "changed"
    println(a)
    val b: Int = 1             // 2
    val c = 3                  // 3

}