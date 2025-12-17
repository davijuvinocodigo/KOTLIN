/**
 * Intervalos (ranges) de caracteres com estruturas condicionais, como o [if].
 *
 * @see [Ranges]
 */

fun main() {
    val letrasReverso = 'e' downTo 'a' // Intervalo de caracteres decrescente
    val letrasComPasso = 'a'..'e' step 2 // Intervalo de caracteres com passo
    val letrasAte = 'a' until 'e'    // Intervalo de caracteres aberto
    val letrasFechado = 'a'..'e'    // Intervalo de caracteres fechado

    for (c in letrasReverso) {
        println("letrasReverso: $c")
    }
    for (c in letrasComPasso) {
        println("letrasComPasso: $c")
    }
    for (c in letrasAte) {
        println("letrasAte: $c")
    }
    for (c in letrasFechado) {
        println("letrasFechado: $c")
    }

    val x = 2
    if (x in 1..5) {
        println("$x está no intervalo de 1 a 5")
    } else {
        println("$x está fora do intervalo de 1 a 5")
    }
    println()

    if (x !in 6..10) {
        println("$x não está no intervalo de 6 a 10")
    } else {
        println("$x está no intervalo de 6 a 10")
    }

}