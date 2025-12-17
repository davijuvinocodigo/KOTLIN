/**
 * Definições mais comuns de intervalos (ranges) no Kotlin.
 *
 * @see [Ranges]
 */
fun main() {

    val fecharange = 1..5          // Intervalo fechado (inclusivo)
    val abrirange = 1 until 5       // Intervalo aberto (exclusivo)
    val passoStepEmDois = 1..10 step 2        // Intervalo com passo
    val decrescente = 5 downTo 1     // Intervalo decrescente
    val letras = 'a'..'e'           // Intervalo de caracteres

    for (i in fecharange) {
        println("fecharange: $i")
    }

    for (i in abrirange) {
        println("abrirange: $i")
    }

    for (i in passoStepEmDois) {
        println("passoStepEmDois: $i")
    }

    for (i in decrescente) {
        println("decrescente: $i")
    }

    for (c in letras) {
        println("letras: $c")
    }
}     