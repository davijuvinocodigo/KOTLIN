/**
 * Infix Functions.
 *
 * @see [Functions]
 * Conceito da infix function é permitir que uma função seja chamada de uma forma mais legível,
 * parecida com uma linguagem natural.
 */

import kotlin.math.pow

fun main() {

  // Definindo função infix
infix fun Int.vezes(outro: Int): Int = this * outro

infix fun String.concatenarCom(outro: String): String = "$this $outro"

// Uso
val resultado1 = 5 vezes 3
println(resultado1)  // 15

val frase = "Olá" concatenarCom "Mundo"
println(frase)  // "Olá Mundo"


val p1 = Ponto(0, 0)
val p2 = Ponto(3, 4)
val distancia = p1 distanciaPara p2
println(distancia)  // 5.0

}

// Com classes
class Ponto(val x: Int, val y: Int) {
    infix fun distanciaPara(outro: Ponto): Double {
        return Math.sqrt((x - outro.x).toDouble().pow(2) + (y - outro.y).toDouble().pow(2))
    }
}