/**
 * Expressões condicionais (análogas a operadores ternários).
 *
 * @see [Conditional Expression]
 */

fun main() {
    val idade = 20

    // Usando if como expressão condicional
    val categoria = if (idade < 13) {
        "Criança"
    } else if (idade in 13..19) {
        "Adolescente"
    } else {
        "Adulto"
    }


    val categoria2 = if (idade < 13) "Criança" else if (idade in 13..19) "Adolescente" else "Adulto"


    println("Categoria: $categoria") // Categoria: Adulto
    println("Categoria: $categoria2") // Categoria: Adulto
    println("Maior valor entre 10 e 20: ${max(10, 20)}") // Maior valor entre 10 e 20: 20
}


fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}