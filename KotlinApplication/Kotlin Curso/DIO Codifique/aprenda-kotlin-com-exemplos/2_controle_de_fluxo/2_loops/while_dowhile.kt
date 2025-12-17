/**
 * Estruturas de repetição/loop [while] e [do-while].
 *
 * @see [Loops]
 */

fun comerUmBolo() {
    println("Comendo um pedaço de bolo...")
}

fun assarUmBolo() {
    println("Assando um bolo...")
}

fun main() {

    var boloComido = 0
    var boloAssado = 0

    while (boloComido < 3) {

        comerUmBolo()
        boloComido++
    }

    do {
        assarUmBolo()
        boloAssado++
    } while (boloAssado < boloComido)
}