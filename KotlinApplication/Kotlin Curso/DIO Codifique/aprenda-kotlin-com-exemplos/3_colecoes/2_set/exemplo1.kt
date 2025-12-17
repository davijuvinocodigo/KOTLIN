/**
 * Conjuntos.
 * UM Set em Kotlin é uma coleção não ordenada que não permite elementos duplicados. O tipo de conjunto padrão é imutável.   
 * @see [Set]
 */

fun main() {
    setImutaveis()
    setMutaveis()
}

fun setImutaveis() {
    // Conjuntos imutáveis
    val numeros: Set<Int> = setOf(1, 2, 3, 4, 5, 5)

    println(numeros)                 // Imprime o conjunto completo
    println(numeros.contains(3))     // Verifica se o elemento 3 está no conjunto
    println(numeros.size)            // Tamanho do conjunto
}

fun setMutaveis() {
    // Conjuntos mutáveis
    val letras: MutableSet<Char> = mutableSetOf('A', 'B', 'C')

    letras.add('D')                  // Adiciona um elemento
    letras.remove('B')               // Remove um elemento

    println(letras)                  // Imprime o conjunto atualizado
}